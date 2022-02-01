package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import com.tencent.qav.log.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@TargetApi(16)
public class AudioDeviceInterface
{
  private static boolean _dumpEnable = false;
  private static boolean _logEnable = true;
  private boolean _IsBluetoothStreamVolume = false;
  private int _RecordSamplerate = 8000;
  private TraeAudioSession _as = null;
  private AudioManager _audioManager = null;
  private AudioRecord _audioRecord = null;
  private boolean _audioRecordChanged = false;
  private boolean _audioRouteChanged = false;
  private int _audioSource = 0;
  private int _audioSourcePolicy = -1;
  private int _audioStreamTypePolicy = -1;
  private AudioTrack _audioTrack = null;
  private int _bufferedPlaySamples = 0;
  private int _bufferedRecSamples = 0;
  private int _channelPlayType = 4;
  private int _channelRecordType = 4;
  private String _connectedDev = "DEVICE_NONE";
  private Context _context = null;
  private boolean _doPlayInit = true;
  private boolean _doRecInit = true;
  private boolean _isPlaying = false;
  private boolean _isRecording = false;
  private int _modePolicy = -1;
  private ByteBuffer _playBuffer;
  private final ReentrantLock _playLock = new ReentrantLock();
  private int _playPosition = 0;
  private int _playSamplerate = 8000;
  private File _play_dump = null;
  private FileOutputStream _play_out = null;
  private boolean _preDone = false;
  private Condition _precon = this._prelock.newCondition();
  private ReentrantLock _prelock = new ReentrantLock();
  private ByteBuffer _recBuffer;
  private final ReentrantLock _recLock = new ReentrantLock();
  private File _rec_dump = null;
  private FileOutputStream _rec_out = null;
  private int _sessionId = 0;
  private int _streamType = 0;
  private byte[] _tempBufPlay;
  private byte[] _tempBufRec;
  private int switchState = 0;
  private boolean usingJava = true;
  
  public AudioDeviceInterface()
  {
    try
    {
      this._playBuffer = ByteBuffer.allocateDirect(1920);
      this._recBuffer = ByteBuffer.allocateDirect(1920);
      this._tempBufPlay = new byte[1920];
      this._tempBufRec = new byte[1920];
      int i = Build.VERSION.SDK_INT;
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "AudioDeviceInterface apiLevel:" + i);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " SDK_INT:" + Build.VERSION.SDK_INT);
      }
      if ((i > 0) || (QLog.isColorLevel())) {
        QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException.getMessage());
        }
      }
    }
  }
  
  private int GetPlayoutVolume()
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null) {
      i = this._audioManager.getStreamVolume(0);
    }
    return i;
  }
  
  private int InitPlayback(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback entry: sampleRate " + paramInt1);
    }
    if ((this._isPlaying) || (this._audioTrack != null) || (paramInt2 > 2) || (paramInt2 < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitPlayback _isPlaying:" + this._isPlaying);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    label557:
    for (;;)
    {
      int j;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if (paramInt2 == 2)
        {
          this._channelPlayType = 12;
          this._playSamplerate = paramInt1;
          int k = AudioTrack.getMinBufferSize(paramInt1, this._channelPlayType, 2);
          if (this._channelPlayType == 12)
          {
            if (!QLog.isColorLevel()) {
              break label439;
            }
            QLog.w("TRAE", 2, "InitPlayback, _channelPlayType stero");
          }
          int m = paramInt1 * 20 * paramInt2 * 2 / 1000;
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: minPlayBufSize:" + k + " 20msFz:" + m);
          }
          this._bufferedPlaySamples = 0;
          if (this._audioTrack != null)
          {
            this._audioTrack.release();
            this._audioTrack = null;
          }
          int[] arrayOfInt = new int[4];
          tmp254_252 = arrayOfInt;
          tmp254_252[0] = 0;
          tmp258_254 = tmp254_252;
          tmp258_254[1] = 0;
          tmp262_258 = tmp258_254;
          tmp262_258[2] = 3;
          tmp266_262 = tmp262_258;
          tmp266_262[3] = 1;
          tmp266_262;
          this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
          if (this._audioRouteChanged) {
            break label465;
          }
          arrayOfInt[0] = this._streamType;
          paramInt1 = k;
          paramInt2 = 0;
          if ((paramInt2 >= arrayOfInt.length) || (this._audioTrack != null)) {
            break;
          }
          this._streamType = arrayOfInt[paramInt2];
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: min play buf size is " + k + " hw_sr:" + AudioTrack.getNativeOutputSampleRate(this._streamType));
          }
          int i = 1;
          if (i > 2) {
            break label726;
          }
          j = k * i;
          if ((j >= m * 4) || (i >= 2)) {
            break label557;
          }
          i += 1;
          paramInt1 = j;
          continue;
        }
        this._channelPlayType = 4;
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      continue;
      label439:
      if ((this._channelPlayType == 4) && (QLog.isColorLevel()))
      {
        QLog.w("TRAE", 2, "InitPlayback, _channelPlayType Mono");
        continue;
        label465:
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "_audioRouteChanged:" + this._audioRouteChanged + " _streamType:" + this._streamType);
        }
        if ((this._audioManager.getMode() == 0) && (this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {}
        for (this._streamType = 3;; this._streamType = 0)
        {
          this._audioRouteChanged = false;
          break;
        }
        try
        {
          this._audioTrack = new AudioTrack(this._streamType, this._playSamplerate, this._channelPlayType, 2, j, 1);
          paramInt1 = j;
          if (this._audioTrack.getState() == 1) {
            break label726;
          }
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InitPlayback: play not initialized playBufSize:" + j + " sr:" + this._playSamplerate);
          }
          this._audioTrack.release();
          this._audioTrack = null;
        }
        catch (Exception localException2)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, localException2.getMessage() + " _audioTrack:" + this._audioTrack);
          }
          if (this._audioTrack != null) {
            this._audioTrack.release();
          }
          this._audioTrack = null;
        }
        continue;
        label726:
        paramInt2 += 1;
      }
    }
    if (this._audioTrack == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitPlayback fail!!!");
      }
      return -1;
    }
    if ((this._as != null) && (this._audioManager != null)) {
      this._as.voiceCallAudioParamChanged(this._audioManager.getMode(), this._streamType);
    }
    this._playPosition = this._audioTrack.getPlaybackHeadPosition();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitPlayback exit: streamType:" + this._streamType + " samplerate:" + this._playSamplerate + " _playPosition:" + this._playPosition + " playBufSize:" + paramInt1);
    }
    if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      paramInt1 = 6;
      if (paramInt1 != 6) {
        break label920;
      }
    }
    label920:
    for (this._IsBluetoothStreamVolume = true;; this._IsBluetoothStreamVolume = false)
    {
      TraeAudioManager.forceVolumeControlStream(this._audioManager, paramInt1);
      return 0;
      paramInt1 = this._audioTrack.getStreamType();
      break;
    }
  }
  
  private int InitRecording(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording entry:" + paramInt1);
    }
    if ((this._isRecording) || (this._audioRecord != null) || (paramInt2 > 2) || (paramInt2 < 1))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "InitRecording _isRecording:" + this._isRecording);
      }
      return -1;
    }
    if (this._audioManager == null) {}
    for (;;)
    {
      int i;
      int k;
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        this._channelRecordType = 16;
        if (paramInt2 == 2) {
          this._channelRecordType = 12;
        }
        this._RecordSamplerate = paramInt1;
        int m = AudioRecord.getMinBufferSize(paramInt1, this._channelRecordType, 2);
        int n = paramInt1 * 20 * paramInt2 * 2 / 1000;
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording: min rec buf size is " + m + " sr:" + getLowlatencySamplerate() + " fp" + getLowlatencyFramesPerBuffer() + " 20msFZ:" + n);
        }
        this._bufferedRecSamples = (paramInt1 * 5 / 200);
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "  rough rec delay set to " + this._bufferedRecSamples);
        }
        if (this._audioRecord != null)
        {
          this._audioRecord.release();
          this._audioRecord = null;
        }
        int[] arrayOfInt = new int[4];
        int[] tmp305_303 = arrayOfInt;
        tmp305_303[0] = 0;
        int[] tmp309_305 = tmp305_303;
        tmp309_305[1] = 1;
        int[] tmp313_309 = tmp309_305;
        tmp313_309[2] = 5;
        int[] tmp317_313 = tmp313_309;
        tmp317_313[3] = 0;
        tmp317_313;
        arrayOfInt[0] = TraeAudioManager.getAudioSource(this._audioSourcePolicy);
        if (!this._audioRecordChanged)
        {
          paramInt2 = m;
          i = 0;
          if ((i >= arrayOfInt.length) || (this._audioRecord != null)) {
            break;
          }
          this._audioSource = arrayOfInt[i];
          int j = 1;
          if (j > 2) {
            break label692;
          }
          k = m * j;
          if ((k >= n * 4) || (j >= 2)) {
            break label517;
          }
          j += 1;
          paramInt2 = k;
          continue;
        }
        if (this._audioManager.getMode() != 0) {
          break label505;
        }
      }
      catch (Exception localException1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException1.getMessage());
        }
        return -1;
      }
      if (this._connectedDev.equals("DEVICE_SPEAKERPHONE")) {
        localException1[0] = TraeAudioManager.getAudioSource(0);
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording _audioRecordChanged as[0]:" + localException1[0]);
        }
        this._audioRecordChanged = false;
        break;
        label505:
        localException1[0] = TraeAudioManager.getAudioSource(7);
      }
      try
      {
        label517:
        this._audioRecord = new AudioRecord(this._audioSource, paramInt1, this._channelRecordType, 2, k);
        paramInt2 = k;
        if (this._audioRecord.getState() == 1) {
          break label692;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "InitRecording:  rec not initialized,try agine,  minbufsize:" + k + " sr:" + paramInt1 + " as:" + this._audioSource);
        }
        this._audioRecord.release();
        this._audioRecord = null;
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, localException2.getMessage() + " _audioRecord:" + this._audioRecord);
        }
        if (this._audioRecord != null) {
          this._audioRecord.release();
        }
        this._audioRecord = null;
      }
      continue;
      label692:
      i += 1;
    }
    if (this._audioRecord == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InitRecording fail!!!");
      }
      return -1;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " [Config] InitRecording: audioSession:" + this._sessionId + " audioSource:" + this._audioSource + " rec sample rate set to " + paramInt1 + " recBufSize:" + paramInt2);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitRecording exit");
    }
    return this._bufferedRecSamples;
  }
  
  private int InitSetting(int paramInt1, int paramInt2, int paramInt3)
  {
    this._audioSourcePolicy = paramInt1;
    this._audioStreamTypePolicy = paramInt2;
    this._modePolicy = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InitSetting: _audioSourcePolicy:" + this._audioSourcePolicy + " _audioStreamTypePolicy:" + this._audioStreamTypePolicy + " _modePolicy:" + this._modePolicy);
    }
    return 0;
  }
  
  public static final void LogTraceEntry(String paramString)
  {
    if (!_logEnable) {}
    do
    {
      return;
      paramString = getTraceInfo() + " entry:" + paramString;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, paramString);
  }
  
  public static final void LogTraceExit()
  {
    if (!_logEnable) {}
    String str;
    do
    {
      return;
      str = getTraceInfo() + " exit";
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, str);
  }
  
  private int OpenslesNeedResetAudioTrack(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        if (!TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
          return -1;
        }
        if ((this._audioRouteChanged) || (paramBoolean))
        {
          if ((this._audioManager == null) && (this._context != null)) {
            this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
          }
          if (this._audioManager == null) {
            return 0;
          }
          if ((this._audioManager.getMode() != 0) || (!this._connectedDev.equals("DEVICE_SPEAKERPHONE"))) {
            continue;
          }
          this._audioStreamTypePolicy = 3;
          this._audioRouteChanged = false;
          this._audioRecordChanged = false;
        }
      }
      catch (Exception localException)
      {
        localException = localException;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("TRAE", 2, "PlayAudio Exception: " + localException.getMessage());
        continue;
      }
      finally {}
      return this._audioStreamTypePolicy;
      this._audioStreamTypePolicy = 0;
    }
  }
  
  /* Error */
  private int PlayAudio(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: aload_0
    //   4: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   7: ifne +70 -> 77
    //   10: iconst_1
    //   11: istore_2
    //   12: aload_0
    //   13: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   16: ifnonnull +66 -> 82
    //   19: iconst_1
    //   20: istore_3
    //   21: iload_2
    //   22: iload_3
    //   23: ior
    //   24: ifeq +63 -> 87
    //   27: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   30: ifeq +45 -> 75
    //   33: ldc 188
    //   35: iconst_2
    //   36: new 190	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 421
    //   46: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_0
    //   50: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   53: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   56: ldc_w 423
    //   59: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_0
    //   63: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   66: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_m1
    //   76: ireturn
    //   77: iconst_0
    //   78: istore_2
    //   79: goto -67 -> 12
    //   82: iconst_0
    //   83: istore_3
    //   84: goto -63 -> 21
    //   87: aload_0
    //   88: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   91: invokevirtual 426	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   94: iload 4
    //   96: istore_2
    //   97: aload_0
    //   98: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   101: astore 11
    //   103: aload 11
    //   105: ifnonnull +13 -> 118
    //   108: aload_0
    //   109: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   112: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   115: bipush 254
    //   117: ireturn
    //   118: iload 4
    //   120: istore_2
    //   121: aload_0
    //   122: getfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   125: istore 8
    //   127: iload 8
    //   129: iconst_1
    //   130: if_icmpne +16 -> 146
    //   133: bipush 237
    //   135: invokestatic 435	android/os/Process:setThreadPriority	(I)V
    //   138: iload 4
    //   140: istore_2
    //   141: aload_0
    //   142: iconst_0
    //   143: putfield 111	com/tencent/sharp/jni/AudioDeviceInterface:_doPlayInit	Z
    //   146: iload 4
    //   148: istore_2
    //   149: getstatic 70	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   152: ifeq +33 -> 185
    //   155: iload 4
    //   157: istore_2
    //   158: aload_0
    //   159: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   162: astore 11
    //   164: aload 11
    //   166: ifnull +19 -> 185
    //   169: iload 4
    //   171: istore_2
    //   172: aload_0
    //   173: getfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   176: aload_0
    //   177: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   180: iconst_0
    //   181: iconst_0
    //   182: invokevirtual 441	java/io/FileOutputStream:write	([BII)V
    //   185: iload 4
    //   187: istore_2
    //   188: aload_0
    //   189: getfield 145	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   192: ifne +548 -> 740
    //   195: iconst_0
    //   196: istore_3
    //   197: iload 4
    //   199: istore_2
    //   200: aload_0
    //   201: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   204: aload_0
    //   205: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   208: invokevirtual 445	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   211: pop
    //   212: iload_3
    //   213: ifeq +1034 -> 1247
    //   216: iload_1
    //   217: istore_2
    //   218: aload_0
    //   219: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   222: invokevirtual 449	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   225: pop
    //   226: iload_1
    //   227: istore_2
    //   228: invokestatic 455	android/os/SystemClock:elapsedRealtime	()J
    //   231: lstore 9
    //   233: iload_1
    //   234: istore_2
    //   235: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   238: ifeq +50 -> 288
    //   241: iload_1
    //   242: istore_2
    //   243: ldc 188
    //   245: iconst_2
    //   246: new 190	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 457
    //   256: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_0
    //   260: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   263: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   266: ldc_w 459
    //   269: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload_0
    //   273: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   276: invokevirtual 339	android/media/AudioTrack:getStreamType	()I
    //   279: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   282: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   288: iload_1
    //   289: istore_2
    //   290: aload_0
    //   291: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   294: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   297: istore_3
    //   298: iload_3
    //   299: iconst_3
    //   300: if_icmpne +140 -> 440
    //   303: iload_1
    //   304: istore_2
    //   305: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   308: ifeq +14 -> 322
    //   311: iload_1
    //   312: istore_2
    //   313: ldc 188
    //   315: iconst_2
    //   316: ldc_w 464
    //   319: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   322: iload_1
    //   323: istore_2
    //   324: aload_0
    //   325: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   328: invokevirtual 467	android/media/AudioTrack:stop	()V
    //   331: iload_1
    //   332: istore_2
    //   333: aload_0
    //   334: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   337: invokevirtual 470	android/media/AudioTrack:flush	()V
    //   340: iload_1
    //   341: istore_2
    //   342: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   345: ifeq +37 -> 382
    //   348: iload_1
    //   349: istore_2
    //   350: ldc 188
    //   352: iconst_2
    //   353: new 190	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   360: ldc_w 472
    //   363: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_0
    //   367: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   370: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   373: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   376: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: iload_1
    //   383: istore_2
    //   384: aload_0
    //   385: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   388: invokevirtual 268	android/media/AudioTrack:release	()V
    //   391: iload_1
    //   392: istore_2
    //   393: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   396: ifeq +37 -> 433
    //   399: iload_1
    //   400: istore_2
    //   401: ldc 188
    //   403: iconst_2
    //   404: new 190	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 474
    //   414: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: aload_0
    //   418: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   421: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   424: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   427: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: iload_1
    //   434: istore_2
    //   435: aload_0
    //   436: aconst_null
    //   437: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   440: iload_1
    //   441: istore_2
    //   442: aload_0
    //   443: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   446: aload_0
    //   447: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   450: iconst_2
    //   451: invokestatic 259	android/media/AudioTrack:getMinBufferSize	(III)I
    //   454: istore 6
    //   456: iload_1
    //   457: istore_2
    //   458: iconst_4
    //   459: newarray int
    //   461: astore 11
    //   463: iload_1
    //   464: istore_2
    //   465: aload 11
    //   467: dup
    //   468: iconst_0
    //   469: iconst_0
    //   470: iastore
    //   471: dup
    //   472: iconst_1
    //   473: iconst_0
    //   474: iastore
    //   475: dup
    //   476: iconst_2
    //   477: iconst_3
    //   478: iastore
    //   479: dup
    //   480: iconst_3
    //   481: iconst_1
    //   482: iastore
    //   483: pop
    //   484: iload_1
    //   485: istore_2
    //   486: aload 11
    //   488: iconst_0
    //   489: aload_0
    //   490: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   493: iastore
    //   494: iload_1
    //   495: istore_2
    //   496: aload_0
    //   497: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   500: bipush 20
    //   502: imul
    //   503: iconst_1
    //   504: imul
    //   505: iconst_2
    //   506: imul
    //   507: sipush 1000
    //   510: idiv
    //   511: istore 4
    //   513: iload_1
    //   514: istore_2
    //   515: iload 4
    //   517: istore_3
    //   518: aload_0
    //   519: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   522: bipush 12
    //   524: if_icmpne +986 -> 1510
    //   527: iload 4
    //   529: iconst_2
    //   530: imul
    //   531: istore_3
    //   532: goto +978 -> 1510
    //   535: iload_1
    //   536: istore_2
    //   537: iload 4
    //   539: aload 11
    //   541: arraylength
    //   542: if_icmpge +564 -> 1106
    //   545: iload_1
    //   546: istore_2
    //   547: aload_0
    //   548: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   551: ifnonnull +555 -> 1106
    //   554: iload_1
    //   555: istore_2
    //   556: aload_0
    //   557: aload 11
    //   559: iload 4
    //   561: iaload
    //   562: putfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   565: iload_1
    //   566: istore_2
    //   567: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   570: ifeq +946 -> 1516
    //   573: iload_1
    //   574: istore_2
    //   575: ldc 188
    //   577: iconst_2
    //   578: new 190	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 275
    //   588: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 6
    //   593: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   596: ldc_w 277
    //   599: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: aload_0
    //   603: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   606: invokestatic 280	android/media/AudioTrack:getNativeOutputSampleRate	(I)I
    //   609: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: goto +898 -> 1516
    //   621: astore 11
    //   623: iload 4
    //   625: istore_2
    //   626: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   629: ifeq -491 -> 138
    //   632: iload 4
    //   634: istore_2
    //   635: ldc 188
    //   637: iconst_2
    //   638: new 190	java/lang/StringBuilder
    //   641: dup
    //   642: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   645: ldc_w 476
    //   648: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: aload 11
    //   653: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   656: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: goto -527 -> 138
    //   668: astore 11
    //   670: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   673: ifeq +33 -> 706
    //   676: ldc 188
    //   678: iconst_2
    //   679: new 190	java/lang/StringBuilder
    //   682: dup
    //   683: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   686: ldc_w 414
    //   689: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload 11
    //   694: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   697: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   703: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   706: aload_0
    //   707: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   710: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   713: iload_2
    //   714: ireturn
    //   715: astore 11
    //   717: iload 4
    //   719: istore_2
    //   720: aload 11
    //   722: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   725: goto -540 -> 185
    //   728: astore 11
    //   730: aload_0
    //   731: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   734: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   737: aload 11
    //   739: athrow
    //   740: iload 4
    //   742: istore_2
    //   743: aload_0
    //   744: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   747: ifnonnull +32 -> 779
    //   750: iload 4
    //   752: istore_2
    //   753: aload_0
    //   754: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   757: ifnull +22 -> 779
    //   760: iload 4
    //   762: istore_2
    //   763: aload_0
    //   764: aload_0
    //   765: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   768: ldc 229
    //   770: invokevirtual 235	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   773: checkcast 237	android/media/AudioManager
    //   776: putfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   779: iload 4
    //   781: istore_2
    //   782: aload_0
    //   783: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   786: invokevirtual 289	android/media/AudioManager:getMode	()I
    //   789: ifne +57 -> 846
    //   792: iload 4
    //   794: istore_2
    //   795: aload_0
    //   796: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   799: ldc_w 291
    //   802: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   805: ifeq +41 -> 846
    //   808: iload 4
    //   810: istore_2
    //   811: aload_0
    //   812: iconst_3
    //   813: putfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   816: iload 4
    //   818: istore_2
    //   819: aload_0
    //   820: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   823: aload_0
    //   824: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   827: invokevirtual 339	android/media/AudioTrack:getStreamType	()I
    //   830: if_icmpne +725 -> 1555
    //   833: iconst_0
    //   834: istore_3
    //   835: iload 4
    //   837: istore_2
    //   838: aload_0
    //   839: iconst_0
    //   840: putfield 145	com/tencent/sharp/jni/AudioDeviceInterface:_audioRouteChanged	Z
    //   843: goto -646 -> 197
    //   846: iload 4
    //   848: istore_2
    //   849: aload_0
    //   850: iconst_0
    //   851: putfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   854: goto -38 -> 816
    //   857: astore 11
    //   859: iload_1
    //   860: istore_2
    //   861: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   864: ifeq -424 -> 440
    //   867: iload_1
    //   868: istore_2
    //   869: ldc 188
    //   871: iconst_2
    //   872: ldc_w 481
    //   875: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   878: goto -438 -> 440
    //   881: aload_0
    //   882: new 255	android/media/AudioTrack
    //   885: dup
    //   886: aload_0
    //   887: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   890: aload_0
    //   891: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   894: aload_0
    //   895: getfield 133	com/tencent/sharp/jni/AudioDeviceInterface:_channelPlayType	I
    //   898: iconst_2
    //   899: iload 7
    //   901: iconst_1
    //   902: invokespecial 300	android/media/AudioTrack:<init>	(IIIIII)V
    //   905: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   908: iload_1
    //   909: istore_2
    //   910: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   913: ifeq +34 -> 947
    //   916: iload_1
    //   917: istore_2
    //   918: ldc 188
    //   920: iconst_2
    //   921: new 190	java/lang/StringBuilder
    //   924: dup
    //   925: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   928: ldc_w 309
    //   931: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   934: aload_0
    //   935: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   938: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   941: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   944: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   947: iload_1
    //   948: istore_2
    //   949: aload_0
    //   950: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   953: invokevirtual 303	android/media/AudioTrack:getState	()I
    //   956: iconst_1
    //   957: if_icmpeq +603 -> 1560
    //   960: iload_1
    //   961: istore_2
    //   962: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   965: ifeq +45 -> 1010
    //   968: iload_1
    //   969: istore_2
    //   970: ldc 188
    //   972: iconst_2
    //   973: new 190	java/lang/StringBuilder
    //   976: dup
    //   977: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   980: ldc_w 305
    //   983: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   986: iload 7
    //   988: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   991: ldc_w 307
    //   994: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   997: aload_0
    //   998: getfield 86	com/tencent/sharp/jni/AudioDeviceInterface:_playSamplerate	I
    //   1001: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1004: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1007: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1010: iload_1
    //   1011: istore_2
    //   1012: aload_0
    //   1013: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1016: invokevirtual 268	android/media/AudioTrack:release	()V
    //   1019: iload_1
    //   1020: istore_2
    //   1021: aload_0
    //   1022: aconst_null
    //   1023: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1026: goto +520 -> 1546
    //   1029: astore 12
    //   1031: iload_1
    //   1032: istore_2
    //   1033: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1036: ifeq +42 -> 1078
    //   1039: iload_1
    //   1040: istore_2
    //   1041: ldc 188
    //   1043: iconst_2
    //   1044: new 190	java/lang/StringBuilder
    //   1047: dup
    //   1048: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1051: aload 12
    //   1053: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1056: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: ldc_w 309
    //   1062: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: aload_0
    //   1066: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1069: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1072: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1075: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1078: iload_1
    //   1079: istore_2
    //   1080: aload_0
    //   1081: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1084: ifnull +12 -> 1096
    //   1087: iload_1
    //   1088: istore_2
    //   1089: aload_0
    //   1090: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1093: invokevirtual 268	android/media/AudioTrack:release	()V
    //   1096: iload_1
    //   1097: istore_2
    //   1098: aload_0
    //   1099: aconst_null
    //   1100: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1103: goto +443 -> 1546
    //   1106: iload_1
    //   1107: istore_2
    //   1108: aload_0
    //   1109: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1112: astore 11
    //   1114: aload 11
    //   1116: ifnull +57 -> 1173
    //   1119: aload_0
    //   1120: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1123: invokevirtual 484	android/media/AudioTrack:play	()V
    //   1126: aload_0
    //   1127: getfield 139	com/tencent/sharp/jni/AudioDeviceInterface:_as	Lcom/tencent/sharp/jni/TraeAudioSession;
    //   1130: aload_0
    //   1131: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1134: invokevirtual 289	android/media/AudioManager:getMode	()I
    //   1137: aload_0
    //   1138: getfield 84	com/tencent/sharp/jni/AudioDeviceInterface:_streamType	I
    //   1141: invokevirtual 319	com/tencent/sharp/jni/TraeAudioSession:voiceCallAudioParamChanged	(II)I
    //   1144: pop
    //   1145: aload_0
    //   1146: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   1149: astore 11
    //   1151: aload_0
    //   1152: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   1155: ldc_w 332
    //   1158: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1161: ifeq +75 -> 1236
    //   1164: bipush 6
    //   1166: istore_2
    //   1167: aload 11
    //   1169: iload_2
    //   1170: invokestatic 336	com/tencent/sharp/jni/TraeAudioManager:forceVolumeControlStream	(Landroid/media/AudioManager;I)V
    //   1173: iload_1
    //   1174: istore_2
    //   1175: iload_1
    //   1176: istore_3
    //   1177: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1180: ifeq +44 -> 1224
    //   1183: iload_1
    //   1184: istore_2
    //   1185: ldc 188
    //   1187: iconst_2
    //   1188: new 190	java/lang/StringBuilder
    //   1191: dup
    //   1192: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1195: ldc_w 486
    //   1198: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1201: invokestatic 455	android/os/SystemClock:elapsedRealtime	()J
    //   1204: lload 9
    //   1206: lsub
    //   1207: invokevirtual 489	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1210: ldc_w 491
    //   1213: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1219: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1222: iload_1
    //   1223: istore_3
    //   1224: aload_0
    //   1225: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1228: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1231: iload_3
    //   1232: istore_2
    //   1233: goto -520 -> 713
    //   1236: aload_0
    //   1237: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1240: invokevirtual 339	android/media/AudioTrack:getStreamType	()I
    //   1243: istore_2
    //   1244: goto -77 -> 1167
    //   1247: iload 4
    //   1249: istore_2
    //   1250: aload_0
    //   1251: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1254: aload_0
    //   1255: getfield 173	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufPlay	[B
    //   1258: iconst_0
    //   1259: iload_1
    //   1260: invokevirtual 494	android/media/AudioTrack:write	([BII)I
    //   1263: istore 4
    //   1265: iload 4
    //   1267: istore_2
    //   1268: aload_0
    //   1269: getfield 169	com/tencent/sharp/jni/AudioDeviceInterface:_playBuffer	Ljava/nio/ByteBuffer;
    //   1272: invokevirtual 449	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1275: pop
    //   1276: iload 4
    //   1278: ifge +67 -> 1345
    //   1281: iload 4
    //   1283: istore_2
    //   1284: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1287: ifeq +49 -> 1336
    //   1290: iload 4
    //   1292: istore_2
    //   1293: ldc 188
    //   1295: iconst_2
    //   1296: new 190	java/lang/StringBuilder
    //   1299: dup
    //   1300: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1303: ldc_w 496
    //   1306: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1309: iload 4
    //   1311: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1314: ldc_w 498
    //   1317: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: iload_1
    //   1321: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1324: ldc_w 500
    //   1327: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1330: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1333: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1336: aload_0
    //   1337: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1340: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1343: iconst_m1
    //   1344: ireturn
    //   1345: iload 4
    //   1347: iload_1
    //   1348: if_icmpeq +58 -> 1406
    //   1351: iload 4
    //   1353: istore_2
    //   1354: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1357: ifeq +49 -> 1406
    //   1360: iload 4
    //   1362: istore_2
    //   1363: ldc 188
    //   1365: iconst_2
    //   1366: new 190	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1373: ldc_w 502
    //   1376: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: iload 4
    //   1381: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1384: ldc_w 498
    //   1387: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1390: iload_1
    //   1391: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1394: ldc_w 500
    //   1397: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1400: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1403: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1406: iload 4
    //   1408: istore_2
    //   1409: aload_0
    //   1410: aload_0
    //   1411: getfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1414: iload 4
    //   1416: iconst_1
    //   1417: ishr
    //   1418: iadd
    //   1419: putfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1422: iload 4
    //   1424: istore_2
    //   1425: aload_0
    //   1426: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   1429: invokevirtual 322	android/media/AudioTrack:getPlaybackHeadPosition	()I
    //   1432: istore_1
    //   1433: iload 4
    //   1435: istore_2
    //   1436: iload_1
    //   1437: aload_0
    //   1438: getfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1441: if_icmpge +11 -> 1452
    //   1444: iload 4
    //   1446: istore_2
    //   1447: aload_0
    //   1448: iconst_0
    //   1449: putfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1452: iload 4
    //   1454: istore_2
    //   1455: aload_0
    //   1456: aload_0
    //   1457: getfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1460: iload_1
    //   1461: aload_0
    //   1462: getfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1465: isub
    //   1466: isub
    //   1467: putfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1470: iload 4
    //   1472: istore_2
    //   1473: aload_0
    //   1474: iload_1
    //   1475: putfield 123	com/tencent/sharp/jni/AudioDeviceInterface:_playPosition	I
    //   1478: iload 4
    //   1480: istore_2
    //   1481: iload 4
    //   1483: istore_3
    //   1484: aload_0
    //   1485: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   1488: ifne -264 -> 1224
    //   1491: iload 4
    //   1493: istore_2
    //   1494: aload_0
    //   1495: getfield 121	com/tencent/sharp/jni/AudioDeviceInterface:_bufferedPlaySamples	I
    //   1498: istore_1
    //   1499: iload 4
    //   1501: istore_3
    //   1502: goto -278 -> 1224
    //   1505: astore 11
    //   1507: goto -334 -> 1173
    //   1510: iconst_0
    //   1511: istore 4
    //   1513: goto -978 -> 535
    //   1516: iconst_1
    //   1517: istore 5
    //   1519: iload 5
    //   1521: iconst_2
    //   1522: if_icmpgt +38 -> 1560
    //   1525: iload 6
    //   1527: iload 5
    //   1529: imul
    //   1530: istore 7
    //   1532: iload 7
    //   1534: iload_3
    //   1535: iconst_4
    //   1536: imul
    //   1537: if_icmpge -656 -> 881
    //   1540: iload 5
    //   1542: iconst_2
    //   1543: if_icmpge -662 -> 881
    //   1546: iload 5
    //   1548: iconst_1
    //   1549: iadd
    //   1550: istore 5
    //   1552: goto -33 -> 1519
    //   1555: iconst_1
    //   1556: istore_3
    //   1557: goto -722 -> 835
    //   1560: iload 4
    //   1562: iconst_1
    //   1563: iadd
    //   1564: istore 4
    //   1566: goto -1031 -> 535
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1569	0	this	AudioDeviceInterface
    //   0	1569	1	paramInt	int
    //   11	1483	2	i	int
    //   20	1537	3	j	int
    //   1	1564	4	k	int
    //   1517	34	5	m	int
    //   454	1076	6	n	int
    //   899	639	7	i1	int
    //   125	6	8	bool	boolean
    //   231	974	9	l	long
    //   101	457	11	localObject1	Object
    //   621	31	11	localException1	Exception
    //   668	25	11	localException2	Exception
    //   715	6	11	localIOException	java.io.IOException
    //   728	10	11	localObject2	Object
    //   857	1	11	localIllegalStateException	java.lang.IllegalStateException
    //   1112	56	11	localObject3	Object
    //   1505	1	11	localException3	Exception
    //   1029	23	12	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   133	138	621	java/lang/Exception
    //   97	103	668	java/lang/Exception
    //   121	127	668	java/lang/Exception
    //   141	146	668	java/lang/Exception
    //   149	155	668	java/lang/Exception
    //   158	164	668	java/lang/Exception
    //   172	185	668	java/lang/Exception
    //   188	195	668	java/lang/Exception
    //   200	212	668	java/lang/Exception
    //   218	226	668	java/lang/Exception
    //   228	233	668	java/lang/Exception
    //   235	241	668	java/lang/Exception
    //   243	288	668	java/lang/Exception
    //   290	298	668	java/lang/Exception
    //   305	311	668	java/lang/Exception
    //   313	322	668	java/lang/Exception
    //   324	331	668	java/lang/Exception
    //   333	340	668	java/lang/Exception
    //   342	348	668	java/lang/Exception
    //   350	382	668	java/lang/Exception
    //   384	391	668	java/lang/Exception
    //   393	399	668	java/lang/Exception
    //   401	433	668	java/lang/Exception
    //   435	440	668	java/lang/Exception
    //   442	456	668	java/lang/Exception
    //   458	463	668	java/lang/Exception
    //   465	484	668	java/lang/Exception
    //   486	494	668	java/lang/Exception
    //   496	513	668	java/lang/Exception
    //   518	527	668	java/lang/Exception
    //   537	545	668	java/lang/Exception
    //   547	554	668	java/lang/Exception
    //   556	565	668	java/lang/Exception
    //   567	573	668	java/lang/Exception
    //   575	618	668	java/lang/Exception
    //   626	632	668	java/lang/Exception
    //   635	665	668	java/lang/Exception
    //   720	725	668	java/lang/Exception
    //   743	750	668	java/lang/Exception
    //   753	760	668	java/lang/Exception
    //   763	779	668	java/lang/Exception
    //   782	792	668	java/lang/Exception
    //   795	808	668	java/lang/Exception
    //   811	816	668	java/lang/Exception
    //   819	833	668	java/lang/Exception
    //   838	843	668	java/lang/Exception
    //   849	854	668	java/lang/Exception
    //   861	867	668	java/lang/Exception
    //   869	878	668	java/lang/Exception
    //   910	916	668	java/lang/Exception
    //   918	947	668	java/lang/Exception
    //   949	960	668	java/lang/Exception
    //   962	968	668	java/lang/Exception
    //   970	1010	668	java/lang/Exception
    //   1012	1019	668	java/lang/Exception
    //   1021	1026	668	java/lang/Exception
    //   1033	1039	668	java/lang/Exception
    //   1041	1078	668	java/lang/Exception
    //   1080	1087	668	java/lang/Exception
    //   1089	1096	668	java/lang/Exception
    //   1098	1103	668	java/lang/Exception
    //   1108	1114	668	java/lang/Exception
    //   1177	1183	668	java/lang/Exception
    //   1185	1222	668	java/lang/Exception
    //   1250	1265	668	java/lang/Exception
    //   1268	1276	668	java/lang/Exception
    //   1284	1290	668	java/lang/Exception
    //   1293	1336	668	java/lang/Exception
    //   1354	1360	668	java/lang/Exception
    //   1363	1406	668	java/lang/Exception
    //   1409	1422	668	java/lang/Exception
    //   1425	1433	668	java/lang/Exception
    //   1436	1444	668	java/lang/Exception
    //   1447	1452	668	java/lang/Exception
    //   1455	1470	668	java/lang/Exception
    //   1473	1478	668	java/lang/Exception
    //   1484	1491	668	java/lang/Exception
    //   1494	1499	668	java/lang/Exception
    //   172	185	715	java/io/IOException
    //   97	103	728	finally
    //   121	127	728	finally
    //   133	138	728	finally
    //   141	146	728	finally
    //   149	155	728	finally
    //   158	164	728	finally
    //   172	185	728	finally
    //   188	195	728	finally
    //   200	212	728	finally
    //   218	226	728	finally
    //   228	233	728	finally
    //   235	241	728	finally
    //   243	288	728	finally
    //   290	298	728	finally
    //   305	311	728	finally
    //   313	322	728	finally
    //   324	331	728	finally
    //   333	340	728	finally
    //   342	348	728	finally
    //   350	382	728	finally
    //   384	391	728	finally
    //   393	399	728	finally
    //   401	433	728	finally
    //   435	440	728	finally
    //   442	456	728	finally
    //   458	463	728	finally
    //   465	484	728	finally
    //   486	494	728	finally
    //   496	513	728	finally
    //   518	527	728	finally
    //   537	545	728	finally
    //   547	554	728	finally
    //   556	565	728	finally
    //   567	573	728	finally
    //   575	618	728	finally
    //   626	632	728	finally
    //   635	665	728	finally
    //   670	706	728	finally
    //   720	725	728	finally
    //   743	750	728	finally
    //   753	760	728	finally
    //   763	779	728	finally
    //   782	792	728	finally
    //   795	808	728	finally
    //   811	816	728	finally
    //   819	833	728	finally
    //   838	843	728	finally
    //   849	854	728	finally
    //   861	867	728	finally
    //   869	878	728	finally
    //   881	908	728	finally
    //   910	916	728	finally
    //   918	947	728	finally
    //   949	960	728	finally
    //   962	968	728	finally
    //   970	1010	728	finally
    //   1012	1019	728	finally
    //   1021	1026	728	finally
    //   1033	1039	728	finally
    //   1041	1078	728	finally
    //   1080	1087	728	finally
    //   1089	1096	728	finally
    //   1098	1103	728	finally
    //   1108	1114	728	finally
    //   1119	1164	728	finally
    //   1167	1173	728	finally
    //   1177	1183	728	finally
    //   1185	1222	728	finally
    //   1236	1244	728	finally
    //   1250	1265	728	finally
    //   1268	1276	728	finally
    //   1284	1290	728	finally
    //   1293	1336	728	finally
    //   1354	1360	728	finally
    //   1363	1406	728	finally
    //   1409	1422	728	finally
    //   1425	1433	728	finally
    //   1436	1444	728	finally
    //   1447	1452	728	finally
    //   1455	1470	728	finally
    //   1473	1478	728	finally
    //   1484	1491	728	finally
    //   1494	1499	728	finally
    //   305	311	857	java/lang/IllegalStateException
    //   313	322	857	java/lang/IllegalStateException
    //   324	331	857	java/lang/IllegalStateException
    //   333	340	857	java/lang/IllegalStateException
    //   342	348	857	java/lang/IllegalStateException
    //   350	382	857	java/lang/IllegalStateException
    //   384	391	857	java/lang/IllegalStateException
    //   393	399	857	java/lang/IllegalStateException
    //   401	433	857	java/lang/IllegalStateException
    //   435	440	857	java/lang/IllegalStateException
    //   881	908	1029	java/lang/Exception
    //   1119	1164	1505	java/lang/Exception
    //   1167	1173	1505	java/lang/Exception
    //   1236	1244	1505	java/lang/Exception
  }
  
  /* Error */
  private int RecordAudio(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: iconst_0
    //   4: istore 5
    //   6: aload_0
    //   7: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   10: ifne +40 -> 50
    //   13: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   16: ifeq +32 -> 48
    //   19: ldc 188
    //   21: iconst_2
    //   22: new 190	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   29: ldc_w 505
    //   32: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   39: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: iconst_m1
    //   49: ireturn
    //   50: aload_0
    //   51: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   54: invokevirtual 426	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   57: iload 5
    //   59: istore_2
    //   60: aload_0
    //   61: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   64: astore 10
    //   66: aload 10
    //   68: ifnonnull +13 -> 81
    //   71: aload_0
    //   72: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   75: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   78: bipush 254
    //   80: ireturn
    //   81: iload 5
    //   83: istore_2
    //   84: aload_0
    //   85: getfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   88: istore 9
    //   90: iload 9
    //   92: iconst_1
    //   93: if_icmpne +16 -> 109
    //   96: bipush 237
    //   98: invokestatic 435	android/os/Process:setThreadPriority	(I)V
    //   101: iload 5
    //   103: istore_2
    //   104: aload_0
    //   105: iconst_0
    //   106: putfield 113	com/tencent/sharp/jni/AudioDeviceInterface:_doRecInit	Z
    //   109: iload 5
    //   111: istore_2
    //   112: aload_0
    //   113: getfield 147	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   116: ifne +425 -> 541
    //   119: iconst_0
    //   120: istore_3
    //   121: iload_3
    //   122: ifeq +906 -> 1028
    //   125: iload 5
    //   127: istore_2
    //   128: aload_0
    //   129: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   132: invokevirtual 449	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   135: pop
    //   136: iload 5
    //   138: istore_2
    //   139: aload_0
    //   140: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   143: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   146: istore_1
    //   147: iload_1
    //   148: iconst_3
    //   149: if_icmpne +57 -> 206
    //   152: iload 5
    //   154: istore_2
    //   155: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   158: ifeq +38 -> 196
    //   161: iload 5
    //   163: istore_2
    //   164: ldc 188
    //   166: iconst_2
    //   167: new 190	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 510
    //   177: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload_0
    //   181: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   184: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   187: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   190: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   193: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   196: iload 5
    //   198: istore_2
    //   199: aload_0
    //   200: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   203: invokevirtual 511	android/media/AudioRecord:stop	()V
    //   206: iload 5
    //   208: istore_2
    //   209: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   212: ifeq +38 -> 250
    //   215: iload 5
    //   217: istore_2
    //   218: ldc 188
    //   220: iconst_2
    //   221: new 190	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 513
    //   231: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_0
    //   235: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   238: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   241: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   244: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   250: iload 5
    //   252: istore_2
    //   253: aload_0
    //   254: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   257: invokevirtual 362	android/media/AudioRecord:release	()V
    //   260: iload 5
    //   262: istore_2
    //   263: aload_0
    //   264: aconst_null
    //   265: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   268: iload 5
    //   270: istore_2
    //   271: aload_0
    //   272: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   275: aload_0
    //   276: getfield 135	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   279: iconst_2
    //   280: invokestatic 347	android/media/AudioRecord:getMinBufferSize	(III)I
    //   283: istore 7
    //   285: iload 5
    //   287: istore_2
    //   288: iconst_4
    //   289: newarray int
    //   291: astore 10
    //   293: iload 5
    //   295: istore_2
    //   296: aload 10
    //   298: dup
    //   299: iconst_0
    //   300: iconst_0
    //   301: iastore
    //   302: dup
    //   303: iconst_1
    //   304: iconst_1
    //   305: iastore
    //   306: dup
    //   307: iconst_2
    //   308: iconst_5
    //   309: iastore
    //   310: dup
    //   311: iconst_3
    //   312: iconst_0
    //   313: iastore
    //   314: pop
    //   315: iload 5
    //   317: istore_2
    //   318: aload 10
    //   320: iconst_0
    //   321: aload_0
    //   322: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   325: invokestatic 365	com/tencent/sharp/jni/TraeAudioManager:getAudioSource	(I)I
    //   328: iastore
    //   329: iload 5
    //   331: istore_2
    //   332: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   335: ifeq +35 -> 370
    //   338: iload 5
    //   340: istore_2
    //   341: ldc 188
    //   343: iconst_2
    //   344: new 190	java/lang/StringBuilder
    //   347: dup
    //   348: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   351: ldc_w 515
    //   354: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 10
    //   359: iconst_0
    //   360: iaload
    //   361: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   364: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: iload 5
    //   372: istore_2
    //   373: aload_0
    //   374: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   377: bipush 20
    //   379: imul
    //   380: iconst_1
    //   381: imul
    //   382: iconst_2
    //   383: imul
    //   384: sipush 1000
    //   387: idiv
    //   388: istore_3
    //   389: iload 5
    //   391: istore_2
    //   392: iload_3
    //   393: istore_1
    //   394: aload_0
    //   395: getfield 135	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   398: bipush 12
    //   400: if_icmpne +853 -> 1253
    //   403: iload_3
    //   404: iconst_2
    //   405: imul
    //   406: istore_1
    //   407: goto +846 -> 1253
    //   410: iload 5
    //   412: istore_2
    //   413: iload_3
    //   414: aload 10
    //   416: arraylength
    //   417: if_icmpge +531 -> 948
    //   420: iload 5
    //   422: istore_2
    //   423: aload_0
    //   424: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   427: ifnonnull +521 -> 948
    //   430: iload 5
    //   432: istore_2
    //   433: aload_0
    //   434: aload 10
    //   436: iload_3
    //   437: iaload
    //   438: putfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   441: iconst_1
    //   442: istore 4
    //   444: goto +814 -> 1258
    //   447: astore 10
    //   449: iload 5
    //   451: istore_2
    //   452: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   455: ifeq -354 -> 101
    //   458: iload 5
    //   460: istore_2
    //   461: ldc 188
    //   463: iconst_2
    //   464: new 190	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   471: ldc_w 517
    //   474: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: aload 10
    //   479: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   482: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   488: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   491: goto -390 -> 101
    //   494: astore 10
    //   496: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   499: ifeq +33 -> 532
    //   502: ldc 188
    //   504: iconst_2
    //   505: new 190	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   512: ldc_w 519
    //   515: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload 10
    //   520: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   523: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: aload_0
    //   533: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   536: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   539: iload_2
    //   540: ireturn
    //   541: iload 5
    //   543: istore_2
    //   544: aload_0
    //   545: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   548: ifnonnull +32 -> 580
    //   551: iload 5
    //   553: istore_2
    //   554: aload_0
    //   555: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   558: ifnull +22 -> 580
    //   561: iload 5
    //   563: istore_2
    //   564: aload_0
    //   565: aload_0
    //   566: getfield 94	com/tencent/sharp/jni/AudioDeviceInterface:_context	Landroid/content/Context;
    //   569: ldc 229
    //   571: invokevirtual 235	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   574: checkcast 237	android/media/AudioManager
    //   577: putfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   580: iload 5
    //   582: istore_2
    //   583: aload_0
    //   584: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   587: astore 10
    //   589: aload 10
    //   591: ifnonnull +12 -> 603
    //   594: aload_0
    //   595: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   598: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   601: iconst_m1
    //   602: ireturn
    //   603: iload 5
    //   605: istore_2
    //   606: aload_0
    //   607: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   610: invokevirtual 289	android/media/AudioManager:getMode	()I
    //   613: ifne +72 -> 685
    //   616: iload 5
    //   618: istore_2
    //   619: aload_0
    //   620: getfield 143	com/tencent/sharp/jni/AudioDeviceInterface:_connectedDev	Ljava/lang/String;
    //   623: ldc_w 291
    //   626: invokevirtual 297	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   629: ifeq +56 -> 685
    //   632: iload 5
    //   634: istore_2
    //   635: aload_0
    //   636: iconst_0
    //   637: invokestatic 365	com/tencent/sharp/jni/TraeAudioManager:getAudioSource	(I)I
    //   640: putfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   643: iload 5
    //   645: istore_2
    //   646: aload_0
    //   647: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   650: aload_0
    //   651: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   654: invokevirtual 521	android/media/AudioRecord:getAudioSource	()I
    //   657: if_icmpne +637 -> 1294
    //   660: iconst_0
    //   661: istore_3
    //   662: iload 5
    //   664: istore_2
    //   665: aload_0
    //   666: iconst_0
    //   667: putfield 147	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecordChanged	Z
    //   670: goto -549 -> 121
    //   673: astore 10
    //   675: aload_0
    //   676: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   679: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   682: aload 10
    //   684: athrow
    //   685: iload 5
    //   687: istore_2
    //   688: aload_0
    //   689: bipush 7
    //   691: invokestatic 365	com/tencent/sharp/jni/TraeAudioManager:getAudioSource	(I)I
    //   694: putfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   697: goto -54 -> 643
    //   700: astore 10
    //   702: iload 5
    //   704: istore_2
    //   705: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   708: ifeq +15 -> 723
    //   711: iload 5
    //   713: istore_2
    //   714: ldc 188
    //   716: iconst_2
    //   717: ldc_w 523
    //   720: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: iload 5
    //   725: istore_2
    //   726: aload 10
    //   728: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   731: aload_0
    //   732: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   735: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   738: iconst_m1
    //   739: ireturn
    //   740: aload_0
    //   741: new 346	android/media/AudioRecord
    //   744: dup
    //   745: aload_0
    //   746: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   749: aload_0
    //   750: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   753: aload_0
    //   754: getfield 135	com/tencent/sharp/jni/AudioDeviceInterface:_channelRecordType	I
    //   757: iconst_2
    //   758: iload 8
    //   760: invokespecial 370	android/media/AudioRecord:<init>	(IIIII)V
    //   763: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   766: iload 5
    //   768: istore_2
    //   769: aload_0
    //   770: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   773: invokevirtual 371	android/media/AudioRecord:getState	()I
    //   776: iconst_1
    //   777: if_icmpeq +522 -> 1299
    //   780: iload 5
    //   782: istore_2
    //   783: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   786: ifeq +59 -> 845
    //   789: iload 5
    //   791: istore_2
    //   792: ldc 188
    //   794: iconst_2
    //   795: new 190	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 373
    //   805: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: iload 8
    //   810: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   813: ldc_w 307
    //   816: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_0
    //   820: getfield 88	com/tencent/sharp/jni/AudioDeviceInterface:_RecordSamplerate	I
    //   823: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   826: ldc_w 375
    //   829: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload_0
    //   833: getfield 90	com/tencent/sharp/jni/AudioDeviceInterface:_audioSource	I
    //   836: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   839: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   842: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   845: iload 5
    //   847: istore_2
    //   848: aload_0
    //   849: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   852: invokevirtual 362	android/media/AudioRecord:release	()V
    //   855: iload 5
    //   857: istore_2
    //   858: aload_0
    //   859: aconst_null
    //   860: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   863: goto +422 -> 1285
    //   866: astore 11
    //   868: iload 5
    //   870: istore_2
    //   871: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   874: ifeq +43 -> 917
    //   877: iload 5
    //   879: istore_2
    //   880: ldc 188
    //   882: iconst_2
    //   883: new 190	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   890: aload 11
    //   892: invokevirtual 225	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   895: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: ldc_w 377
    //   901: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: aload_0
    //   905: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   908: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   911: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: iload 5
    //   919: istore_2
    //   920: aload_0
    //   921: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   924: ifnull +13 -> 937
    //   927: iload 5
    //   929: istore_2
    //   930: aload_0
    //   931: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   934: invokevirtual 362	android/media/AudioRecord:release	()V
    //   937: iload 5
    //   939: istore_2
    //   940: aload_0
    //   941: aconst_null
    //   942: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   945: goto +340 -> 1285
    //   948: iload 5
    //   950: istore_2
    //   951: aload_0
    //   952: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   955: astore 10
    //   957: iload 6
    //   959: istore_2
    //   960: aload 10
    //   962: ifnull +16 -> 978
    //   965: iload 5
    //   967: istore_2
    //   968: aload_0
    //   969: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   972: invokevirtual 527	android/media/AudioRecord:startRecording	()V
    //   975: iload 6
    //   977: istore_2
    //   978: aload_0
    //   979: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   982: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   985: goto -446 -> 539
    //   988: astore 10
    //   990: iload 5
    //   992: istore_2
    //   993: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   996: ifeq +15 -> 1011
    //   999: iload 5
    //   1001: istore_2
    //   1002: ldc 188
    //   1004: iconst_2
    //   1005: ldc_w 529
    //   1008: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1011: iload 5
    //   1013: istore_2
    //   1014: aload 10
    //   1016: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   1019: aload_0
    //   1020: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1023: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1026: iconst_m1
    //   1027: ireturn
    //   1028: iload 5
    //   1030: istore_2
    //   1031: aload_0
    //   1032: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   1035: invokevirtual 449	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   1038: pop
    //   1039: iload 5
    //   1041: istore_2
    //   1042: aload_0
    //   1043: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   1046: aload_0
    //   1047: getfield 175	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   1050: iconst_0
    //   1051: iload_1
    //   1052: invokevirtual 532	android/media/AudioRecord:read	([BII)I
    //   1055: istore_3
    //   1056: iload_3
    //   1057: ifge +64 -> 1121
    //   1060: iload_3
    //   1061: istore_2
    //   1062: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1065: ifeq +47 -> 1112
    //   1068: iload_3
    //   1069: istore_2
    //   1070: ldc 188
    //   1072: iconst_2
    //   1073: new 190	java/lang/StringBuilder
    //   1076: dup
    //   1077: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1080: ldc_w 534
    //   1083: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: iload_3
    //   1087: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: ldc_w 498
    //   1093: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1096: iload_1
    //   1097: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1100: ldc_w 500
    //   1103: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1109: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1112: aload_0
    //   1113: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1116: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1119: iconst_m1
    //   1120: ireturn
    //   1121: iload_3
    //   1122: istore_2
    //   1123: aload_0
    //   1124: getfield 171	com/tencent/sharp/jni/AudioDeviceInterface:_recBuffer	Ljava/nio/ByteBuffer;
    //   1127: aload_0
    //   1128: getfield 175	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   1131: iconst_0
    //   1132: iload_3
    //   1133: invokevirtual 538	java/nio/ByteBuffer:put	([BII)Ljava/nio/ByteBuffer;
    //   1136: pop
    //   1137: iload_3
    //   1138: istore_2
    //   1139: getstatic 70	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   1142: ifeq +31 -> 1173
    //   1145: iload_3
    //   1146: istore_2
    //   1147: aload_0
    //   1148: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   1151: astore 10
    //   1153: aload 10
    //   1155: ifnull +18 -> 1173
    //   1158: iload_3
    //   1159: istore_2
    //   1160: aload_0
    //   1161: getfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   1164: aload_0
    //   1165: getfield 175	com/tencent/sharp/jni/AudioDeviceInterface:_tempBufRec	[B
    //   1168: iconst_0
    //   1169: iload_3
    //   1170: invokevirtual 441	java/io/FileOutputStream:write	([BII)V
    //   1173: iload_3
    //   1174: istore_2
    //   1175: iload_3
    //   1176: iload_1
    //   1177: if_icmpeq -199 -> 978
    //   1180: iload_3
    //   1181: istore_2
    //   1182: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   1185: ifeq +47 -> 1232
    //   1188: iload_3
    //   1189: istore_2
    //   1190: ldc 188
    //   1192: iconst_2
    //   1193: new 190	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 540
    //   1203: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: iload_3
    //   1207: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1210: ldc_w 498
    //   1213: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: iload_1
    //   1217: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1220: ldc_w 500
    //   1223: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1229: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1232: aload_0
    //   1233: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   1236: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   1239: iconst_m1
    //   1240: ireturn
    //   1241: astore 10
    //   1243: iload_3
    //   1244: istore_2
    //   1245: aload 10
    //   1247: invokevirtual 479	java/io/IOException:printStackTrace	()V
    //   1250: goto -77 -> 1173
    //   1253: iconst_0
    //   1254: istore_3
    //   1255: goto -845 -> 410
    //   1258: iload 4
    //   1260: iconst_2
    //   1261: if_icmpgt +38 -> 1299
    //   1264: iload 7
    //   1266: iload 4
    //   1268: imul
    //   1269: istore 8
    //   1271: iload 8
    //   1273: iload_1
    //   1274: iconst_4
    //   1275: imul
    //   1276: if_icmpge -536 -> 740
    //   1279: iload 4
    //   1281: iconst_2
    //   1282: if_icmpge -542 -> 740
    //   1285: iload 4
    //   1287: iconst_1
    //   1288: iadd
    //   1289: istore 4
    //   1291: goto -33 -> 1258
    //   1294: iconst_1
    //   1295: istore_3
    //   1296: goto -634 -> 662
    //   1299: iload_3
    //   1300: iconst_1
    //   1301: iadd
    //   1302: istore_3
    //   1303: goto -893 -> 410
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1306	0	this	AudioDeviceInterface
    //   0	1306	1	paramInt	int
    //   59	1186	2	i	int
    //   120	1183	3	j	int
    //   442	848	4	k	int
    //   4	1036	5	m	int
    //   1	975	6	n	int
    //   283	986	7	i1	int
    //   758	519	8	i2	int
    //   88	6	9	bool	boolean
    //   64	371	10	localObject1	Object
    //   447	31	10	localException1	Exception
    //   494	25	10	localException2	Exception
    //   587	3	10	localAudioManager	AudioManager
    //   673	10	10	localObject2	Object
    //   700	27	10	localIllegalStateException1	java.lang.IllegalStateException
    //   955	6	10	localAudioRecord	AudioRecord
    //   988	27	10	localIllegalStateException2	java.lang.IllegalStateException
    //   1151	3	10	localFileOutputStream	FileOutputStream
    //   1241	5	10	localIOException	java.io.IOException
    //   866	25	11	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   96	101	447	java/lang/Exception
    //   60	66	494	java/lang/Exception
    //   84	90	494	java/lang/Exception
    //   104	109	494	java/lang/Exception
    //   112	119	494	java/lang/Exception
    //   128	136	494	java/lang/Exception
    //   139	147	494	java/lang/Exception
    //   155	161	494	java/lang/Exception
    //   164	196	494	java/lang/Exception
    //   199	206	494	java/lang/Exception
    //   209	215	494	java/lang/Exception
    //   218	250	494	java/lang/Exception
    //   253	260	494	java/lang/Exception
    //   263	268	494	java/lang/Exception
    //   271	285	494	java/lang/Exception
    //   288	293	494	java/lang/Exception
    //   296	315	494	java/lang/Exception
    //   318	329	494	java/lang/Exception
    //   332	338	494	java/lang/Exception
    //   341	370	494	java/lang/Exception
    //   373	389	494	java/lang/Exception
    //   394	403	494	java/lang/Exception
    //   413	420	494	java/lang/Exception
    //   423	430	494	java/lang/Exception
    //   433	441	494	java/lang/Exception
    //   452	458	494	java/lang/Exception
    //   461	491	494	java/lang/Exception
    //   544	551	494	java/lang/Exception
    //   554	561	494	java/lang/Exception
    //   564	580	494	java/lang/Exception
    //   583	589	494	java/lang/Exception
    //   606	616	494	java/lang/Exception
    //   619	632	494	java/lang/Exception
    //   635	643	494	java/lang/Exception
    //   646	660	494	java/lang/Exception
    //   665	670	494	java/lang/Exception
    //   688	697	494	java/lang/Exception
    //   705	711	494	java/lang/Exception
    //   714	723	494	java/lang/Exception
    //   726	731	494	java/lang/Exception
    //   769	780	494	java/lang/Exception
    //   783	789	494	java/lang/Exception
    //   792	845	494	java/lang/Exception
    //   848	855	494	java/lang/Exception
    //   858	863	494	java/lang/Exception
    //   871	877	494	java/lang/Exception
    //   880	917	494	java/lang/Exception
    //   920	927	494	java/lang/Exception
    //   930	937	494	java/lang/Exception
    //   940	945	494	java/lang/Exception
    //   951	957	494	java/lang/Exception
    //   968	975	494	java/lang/Exception
    //   993	999	494	java/lang/Exception
    //   1002	1011	494	java/lang/Exception
    //   1014	1019	494	java/lang/Exception
    //   1031	1039	494	java/lang/Exception
    //   1042	1056	494	java/lang/Exception
    //   1062	1068	494	java/lang/Exception
    //   1070	1112	494	java/lang/Exception
    //   1123	1137	494	java/lang/Exception
    //   1139	1145	494	java/lang/Exception
    //   1147	1153	494	java/lang/Exception
    //   1160	1173	494	java/lang/Exception
    //   1182	1188	494	java/lang/Exception
    //   1190	1232	494	java/lang/Exception
    //   1245	1250	494	java/lang/Exception
    //   60	66	673	finally
    //   84	90	673	finally
    //   96	101	673	finally
    //   104	109	673	finally
    //   112	119	673	finally
    //   128	136	673	finally
    //   139	147	673	finally
    //   155	161	673	finally
    //   164	196	673	finally
    //   199	206	673	finally
    //   209	215	673	finally
    //   218	250	673	finally
    //   253	260	673	finally
    //   263	268	673	finally
    //   271	285	673	finally
    //   288	293	673	finally
    //   296	315	673	finally
    //   318	329	673	finally
    //   332	338	673	finally
    //   341	370	673	finally
    //   373	389	673	finally
    //   394	403	673	finally
    //   413	420	673	finally
    //   423	430	673	finally
    //   433	441	673	finally
    //   452	458	673	finally
    //   461	491	673	finally
    //   496	532	673	finally
    //   544	551	673	finally
    //   554	561	673	finally
    //   564	580	673	finally
    //   583	589	673	finally
    //   606	616	673	finally
    //   619	632	673	finally
    //   635	643	673	finally
    //   646	660	673	finally
    //   665	670	673	finally
    //   688	697	673	finally
    //   705	711	673	finally
    //   714	723	673	finally
    //   726	731	673	finally
    //   740	766	673	finally
    //   769	780	673	finally
    //   783	789	673	finally
    //   792	845	673	finally
    //   848	855	673	finally
    //   858	863	673	finally
    //   871	877	673	finally
    //   880	917	673	finally
    //   920	927	673	finally
    //   930	937	673	finally
    //   940	945	673	finally
    //   951	957	673	finally
    //   968	975	673	finally
    //   993	999	673	finally
    //   1002	1011	673	finally
    //   1014	1019	673	finally
    //   1031	1039	673	finally
    //   1042	1056	673	finally
    //   1062	1068	673	finally
    //   1070	1112	673	finally
    //   1123	1137	673	finally
    //   1139	1145	673	finally
    //   1147	1153	673	finally
    //   1160	1173	673	finally
    //   1182	1188	673	finally
    //   1190	1232	673	finally
    //   1245	1250	673	finally
    //   155	161	700	java/lang/IllegalStateException
    //   164	196	700	java/lang/IllegalStateException
    //   199	206	700	java/lang/IllegalStateException
    //   740	766	866	java/lang/Exception
    //   968	975	988	java/lang/IllegalStateException
    //   1160	1173	1241	java/io/IOException
  }
  
  private int SetPlayoutVolume(int paramInt)
  {
    if ((this._audioManager == null) && (this._context != null)) {
      this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
    }
    int i = -1;
    if (this._audioManager != null)
    {
      this._audioManager.setStreamVolume(0, paramInt, 0);
      i = 0;
    }
    return i;
  }
  
  /* Error */
  private int StartPlayback()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   6: ifeq +20 -> 26
    //   9: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   12: ifeq +12 -> 24
    //   15: ldc 188
    //   17: iconst_2
    //   18: ldc_w 550
    //   21: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   30: ifnonnull +40 -> 70
    //   33: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   36: ifeq -12 -> 24
    //   39: ldc 188
    //   41: iconst_2
    //   42: new 190	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   49: ldc_w 552
    //   52: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload_0
    //   56: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   59: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iconst_m1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   74: invokevirtual 484	android/media/AudioTrack:play	()V
    //   77: getstatic 70	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   80: ifeq +52 -> 132
    //   83: aload_0
    //   84: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   87: ifnull +11 -> 98
    //   90: aload_0
    //   91: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   94: invokevirtual 289	android/media/AudioManager:getMode	()I
    //   97: istore_1
    //   98: aload_0
    //   99: new 554	java/io/File
    //   102: dup
    //   103: aload_0
    //   104: ldc_w 556
    //   107: iload_1
    //   108: invokespecial 560	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   111: invokespecial 562	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: putfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   117: aload_0
    //   118: new 437	java/io/FileOutputStream
    //   121: dup
    //   122: aload_0
    //   123: getfield 127	com/tencent/sharp/jni/AudioDeviceInterface:_play_dump	Ljava/io/File;
    //   126: invokespecial 565	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   129: putfield 131	com/tencent/sharp/jni/AudioDeviceInterface:_play_out	Ljava/io/FileOutputStream;
    //   132: aload_0
    //   133: iconst_1
    //   134: putfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   137: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   140: ifeq +12 -> 152
    //   143: ldc 188
    //   145: iconst_2
    //   146: ldc_w 567
    //   149: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   152: iconst_0
    //   153: ireturn
    //   154: astore_2
    //   155: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   158: ifeq +12 -> 170
    //   161: ldc 188
    //   163: iconst_2
    //   164: ldc_w 569
    //   167: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_2
    //   171: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   174: iconst_m1
    //   175: ireturn
    //   176: astore_2
    //   177: aload_2
    //   178: invokevirtual 570	java/io/FileNotFoundException:printStackTrace	()V
    //   181: goto -49 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AudioDeviceInterface
    //   1	107	1	i	int
    //   154	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   176	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   70	77	154	java/lang/IllegalStateException
    //   117	132	176	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StartRecording()
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_1
    //   2: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   5: ifeq +12 -> 17
    //   8: ldc 188
    //   10: iconst_2
    //   11: ldc_w 573
    //   14: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   17: aload_0
    //   18: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   21: ifeq +40 -> 61
    //   24: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   27: ifeq +32 -> 59
    //   30: ldc 188
    //   32: iconst_2
    //   33: new 190	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 575
    //   43: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: aload_0
    //   47: getfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   50: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iconst_m1
    //   60: ireturn
    //   61: aload_0
    //   62: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   65: ifnonnull +40 -> 105
    //   68: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   71: ifeq -12 -> 59
    //   74: ldc 188
    //   76: iconst_2
    //   77: new 190	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   84: ldc_w 577
    //   87: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_0
    //   91: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   94: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   97: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   103: iconst_m1
    //   104: ireturn
    //   105: aload_0
    //   106: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   109: invokevirtual 527	android/media/AudioRecord:startRecording	()V
    //   112: getstatic 70	com/tencent/sharp/jni/AudioDeviceInterface:_dumpEnable	Z
    //   115: ifeq +52 -> 167
    //   118: aload_0
    //   119: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   122: ifnull +11 -> 133
    //   125: aload_0
    //   126: getfield 102	com/tencent/sharp/jni/AudioDeviceInterface:_audioManager	Landroid/media/AudioManager;
    //   129: invokevirtual 289	android/media/AudioManager:getMode	()I
    //   132: istore_1
    //   133: aload_0
    //   134: new 554	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: ldc_w 579
    //   142: iload_1
    //   143: invokespecial 560	com/tencent/sharp/jni/AudioDeviceInterface:getDumpFilePath	(Ljava/lang/String;I)Ljava/lang/String;
    //   146: invokespecial 562	java/io/File:<init>	(Ljava/lang/String;)V
    //   149: putfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   152: aload_0
    //   153: new 437	java/io/FileOutputStream
    //   156: dup
    //   157: aload_0
    //   158: getfield 125	com/tencent/sharp/jni/AudioDeviceInterface:_rec_dump	Ljava/io/File;
    //   161: invokespecial 565	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   164: putfield 129	com/tencent/sharp/jni/AudioDeviceInterface:_rec_out	Ljava/io/FileOutputStream;
    //   167: aload_0
    //   168: iconst_1
    //   169: putfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   172: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   175: ifeq +12 -> 187
    //   178: ldc 188
    //   180: iconst_2
    //   181: ldc_w 581
    //   184: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iconst_0
    //   188: ireturn
    //   189: astore_2
    //   190: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   193: ifeq +12 -> 205
    //   196: ldc 188
    //   198: iconst_2
    //   199: ldc_w 529
    //   202: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload_2
    //   206: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   209: iconst_m1
    //   210: ireturn
    //   211: astore_2
    //   212: aload_2
    //   213: invokevirtual 570	java/io/FileNotFoundException:printStackTrace	()V
    //   216: goto -49 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	AudioDeviceInterface
    //   1	142	1	i	int
    //   189	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   211	2	2	localFileNotFoundException	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   105	112	189	java/lang/IllegalStateException
    //   152	167	211	java/io/FileNotFoundException
  }
  
  /* Error */
  private int StopPlayback()
  {
    // Byte code:
    //   0: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   3: ifeq +32 -> 35
    //   6: ldc 188
    //   8: iconst_2
    //   9: new 190	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 584
    //   19: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_0
    //   23: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   26: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   29: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   35: aload_0
    //   36: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   39: ifnonnull +53 -> 92
    //   42: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   45: ifeq +45 -> 90
    //   48: ldc 188
    //   50: iconst_2
    //   51: new 190	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 586
    //   61: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_0
    //   65: getfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   68: invokevirtual 250	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   71: ldc_w 423
    //   74: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: aload_0
    //   78: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   81: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_m1
    //   91: ireturn
    //   92: aload_0
    //   93: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   96: invokevirtual 426	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   99: aload_0
    //   100: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   103: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   106: istore_1
    //   107: iload_1
    //   108: iconst_3
    //   109: if_icmpne +70 -> 179
    //   112: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   115: ifeq +12 -> 127
    //   118: ldc 188
    //   120: iconst_2
    //   121: ldc_w 464
    //   124: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   127: aload_0
    //   128: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   131: invokevirtual 467	android/media/AudioTrack:stop	()V
    //   134: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   137: ifeq +35 -> 172
    //   140: ldc 188
    //   142: iconst_2
    //   143: new 190	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   150: ldc_w 472
    //   153: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: aload_0
    //   157: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   160: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   163: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   166: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   169: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   172: aload_0
    //   173: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   176: invokevirtual 470	android/media/AudioTrack:flush	()V
    //   179: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   182: ifeq +35 -> 217
    //   185: ldc 188
    //   187: iconst_2
    //   188: new 190	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 474
    //   198: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   205: invokevirtual 462	android/media/AudioTrack:getPlayState	()I
    //   208: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   221: invokevirtual 268	android/media/AudioTrack:release	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 80	com/tencent/sharp/jni/AudioDeviceInterface:_audioTrack	Landroid/media/AudioTrack;
    //   229: aload_0
    //   230: iconst_0
    //   231: putfield 117	com/tencent/sharp/jni/AudioDeviceInterface:_isPlaying	Z
    //   234: aload_0
    //   235: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   238: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   241: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   244: ifeq +12 -> 256
    //   247: ldc 188
    //   249: iconst_2
    //   250: ldc_w 588
    //   253: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   256: iconst_0
    //   257: ireturn
    //   258: astore_2
    //   259: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   262: ifeq +12 -> 274
    //   265: ldc 188
    //   267: iconst_2
    //   268: ldc_w 481
    //   271: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   274: aload_2
    //   275: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   278: aload_0
    //   279: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   282: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   285: iconst_m1
    //   286: ireturn
    //   287: astore_2
    //   288: aload_0
    //   289: getfield 107	com/tencent/sharp/jni/AudioDeviceInterface:_playLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   292: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   295: aload_2
    //   296: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	297	0	this	AudioDeviceInterface
    //   106	4	1	i	int
    //   258	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   287	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   112	127	258	java/lang/IllegalStateException
    //   127	134	258	java/lang/IllegalStateException
    //   99	107	287	finally
    //   112	127	287	finally
    //   127	134	287	finally
    //   134	172	287	finally
    //   172	179	287	finally
    //   179	217	287	finally
    //   217	234	287	finally
    //   259	274	287	finally
    //   274	278	287	finally
  }
  
  /* Error */
  private int StopRecording()
  {
    // Byte code:
    //   0: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 188
    //   8: iconst_2
    //   9: ldc_w 591
    //   12: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_0
    //   16: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   19: ifnonnull +40 -> 59
    //   22: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   25: ifeq +32 -> 57
    //   28: ldc 188
    //   30: iconst_2
    //   31: new 190	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 593
    //   41: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: aload_0
    //   45: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   48: invokevirtual 312	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: ireturn
    //   59: aload_0
    //   60: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   63: invokevirtual 426	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   66: aload_0
    //   67: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   70: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   73: istore_1
    //   74: iload_1
    //   75: iconst_3
    //   76: if_icmpne +48 -> 124
    //   79: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   82: ifeq +35 -> 117
    //   85: ldc 188
    //   87: iconst_2
    //   88: new 190	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   95: ldc_w 510
    //   98: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   105: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   108: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: aload_0
    //   118: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   121: invokevirtual 511	android/media/AudioRecord:stop	()V
    //   124: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   127: ifeq +35 -> 162
    //   130: ldc 188
    //   132: iconst_2
    //   133: new 190	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 191	java/lang/StringBuilder:<init>	()V
    //   140: ldc_w 513
    //   143: invokevirtual 197	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: aload_0
    //   147: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   150: invokevirtual 508	android/media/AudioRecord:getRecordingState	()I
    //   153: invokevirtual 200	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: invokevirtual 204	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   159: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_0
    //   163: getfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   166: invokevirtual 362	android/media/AudioRecord:release	()V
    //   169: aload_0
    //   170: aconst_null
    //   171: putfield 82	com/tencent/sharp/jni/AudioDeviceInterface:_audioRecord	Landroid/media/AudioRecord;
    //   174: aload_0
    //   175: iconst_0
    //   176: putfield 115	com/tencent/sharp/jni/AudioDeviceInterface:_isRecording	Z
    //   179: aload_0
    //   180: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   183: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   186: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   189: ifeq +12 -> 201
    //   192: ldc 188
    //   194: iconst_2
    //   195: ldc_w 595
    //   198: invokestatic 208	com/tencent/qav/log/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iconst_0
    //   202: ireturn
    //   203: astore_2
    //   204: invokestatic 186	com/tencent/qav/log/QLog:isColorLevel	()Z
    //   207: ifeq +12 -> 219
    //   210: ldc 188
    //   212: iconst_2
    //   213: ldc_w 523
    //   216: invokestatic 253	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   219: aload_2
    //   220: invokevirtual 524	java/lang/IllegalStateException:printStackTrace	()V
    //   223: aload_0
    //   224: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   227: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   230: iconst_m1
    //   231: ireturn
    //   232: astore_2
    //   233: aload_0
    //   234: getfield 109	com/tencent/sharp/jni/AudioDeviceInterface:_recLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   237: invokevirtual 429	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   240: aload_2
    //   241: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	242	0	this	AudioDeviceInterface
    //   73	4	1	i	int
    //   203	17	2	localIllegalStateException	java.lang.IllegalStateException
    //   232	9	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   79	117	203	java/lang/IllegalStateException
    //   117	124	203	java/lang/IllegalStateException
    //   66	74	232	finally
    //   79	117	232	finally
    //   117	124	232	finally
    //   124	162	232	finally
    //   162	179	232	finally
    //   204	219	232	finally
    //   219	223	232	finally
  }
  
  @TargetApi(16)
  private int getAudioSessionId(AudioRecord paramAudioRecord)
  {
    return 0;
  }
  
  private String getDumpFilePath(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "manufacture:" + Build.MANUFACTURER);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "MODEL:" + Build.MODEL);
    }
    paramString = Environment.getExternalStorageDirectory().getPath() + "/MF-" + Build.MANUFACTURER + "-M-" + Build.MODEL + "-as-" + TraeAudioManager.getAudioSource(this._audioSourcePolicy) + "-st-" + this._streamType + "-m-" + paramInt + "-" + paramString;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump:" + paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "dump replace:" + paramString.replace(" ", "_"));
    }
    return paramString.replace(" ", "_");
  }
  
  private int getLowlatencyFramesPerBuffer()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
      return 0;
    }
    boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
      if (bool != true) {
        break label146;
      }
    }
    label146:
    for (String str = "Y";; str = "N")
    {
      QLog.w("TRAE", 2, str);
      if ((Build.VERSION.SDK_INT >= 17) || (!QLog.isColorLevel())) {
        break;
      }
      QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
      return 0;
    }
  }
  
  private int getLowlatencySamplerate()
  {
    if ((this._context == null) || (Build.VERSION.SDK_INT < 9)) {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "getLowlatencySamplerate err, _context:" + this._context + " api:" + Build.VERSION.SDK_INT);
      }
    }
    label146:
    label153:
    do
    {
      return 0;
      boolean bool = this._context.getPackageManager().hasSystemFeature("android.hardware.audio.low_latency");
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("LOW_LATENCY:");
        if (bool != true) {
          break label146;
        }
      }
      for (String str = "Y";; str = "N")
      {
        QLog.w("TRAE", 2, str);
        if (Build.VERSION.SDK_INT >= 17) {
          break label153;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("TRAE", 2, "API Level too low not support PROPERTY_OUTPUT_SAMPLE_RATE");
        return 0;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, "getLowlatencySamplerate not support right now!");
    return 0;
  }
  
  public static String getTraceInfo()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    StackTraceElement[] arrayOfStackTraceElement = new Throwable().getStackTrace();
    int i = arrayOfStackTraceElement.length;
    localStringBuffer.append("").append(arrayOfStackTraceElement[2].getClassName()).append(".").append(arrayOfStackTraceElement[2].getMethodName()).append(": ").append(arrayOfStackTraceElement[2].getLineNumber());
    return localStringBuffer.toString();
  }
  
  private void initTRAEAudioManager()
  {
    if (this._context != null)
    {
      TraeAudioManager.init(this._context);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "initTRAEAudioManager , TraeAudioSession startService");
      }
    }
  }
  
  private void onOutputChanage(String paramString)
  {
    setAudioRouteSwitchState(paramString);
    this._connectedDev = paramString;
    if ((this._audioManager == null) && (this._context != null)) {}
    for (;;)
    {
      try
      {
        this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        if ((this._audioManager != null) && (this._audioTrack != null))
        {
          if (this._connectedDev.equals("DEVICE_BLUETOOTHHEADSET"))
          {
            i = 6;
            if ((!this._IsBluetoothStreamVolume) || (i == 6)) {
              break label136;
            }
            TraeAudioManager.forceVolumeControlStream(this._audioManager, i);
            this._IsBluetoothStreamVolume = false;
          }
        }
        else
        {
          if (TraeAudioManager.isCloseSystemAPM(this._modePolicy)) {
            break;
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TRAE", 2, paramString.getMessage());
        return;
      }
      int i = this._audioTrack.getStreamType();
      continue;
      label136:
      if ((!this._IsBluetoothStreamVolume) && (i == 6))
      {
        TraeAudioManager.forceVolumeControlStream(this._audioManager, i);
        this._IsBluetoothStreamVolume = true;
      }
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" onOutputChanage:").append(paramString);
      if (this._audioManager != null) {
        break label359;
      }
      localObject = " am==null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(" st:").append(this._streamType);
      if (this._audioTrack != null) {
        break label389;
      }
      localObject = "_audioTrack==null";
      label233:
      QLog.w("TRAE", 2, (String)localObject);
    }
    for (;;)
    {
      try
      {
        if (this._audioManager == null) {
          this._audioManager = ((AudioManager)this._context.getSystemService("audio"));
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append(" curr mode:").append(paramString);
          if (this._audioManager != null) {
            continue;
          }
          paramString = "am==null";
          QLog.w("TRAE", 2, paramString);
        }
        if ((this._connectedDev.equals("DEVICE_SPEAKERPHONE")) && (this._audioManager != null)) {
          this._audioManager.setMode(0);
        }
      }
      catch (Exception paramString)
      {
        label359:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label389:
        QLog.w("TRAE", 2, paramString.getMessage());
        continue;
      }
      this._audioRouteChanged = true;
      this._audioRecordChanged = true;
      return;
      localObject = " mode:" + this._audioManager.getMode();
      break;
      localObject = " at.st:" + this._audioTrack.getStreamType();
      break label233;
      paramString = " mode:" + this._audioManager.getMode();
    }
  }
  
  private void setAudioRouteSwitchState(String paramString)
  {
    if (paramString.equals("DEVICE_EARPHONE"))
    {
      this.switchState = 1;
      return;
    }
    if (paramString.equals("DEVICE_SPEAKERPHONE"))
    {
      this.switchState = 2;
      return;
    }
    if (paramString.equals("DEVICE_WIREDHEADSET"))
    {
      this.switchState = 3;
      return;
    }
    if (paramString.equals("DEVICE_BLUETOOTHHEADSET"))
    {
      this.switchState = 4;
      return;
    }
    this.switchState = 0;
  }
  
  private int sigHowling(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "java onHowling flg:" + paramInt);
    }
    if (this._as == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHowling too early" + paramInt);
      }
      return -1;
    }
    return 0;
  }
  
  private void uninitTRAEAudioManager()
  {
    if (this._context != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "uninitTRAEAudioManager , stopService");
      }
      TraeAudioManager.uninit();
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("TRAE", 2, "uninitTRAEAudioManager , context null");
  }
  
  public int call_postprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    if (this._as != null)
    {
      this._as.voiceCallPostprocess();
      this._as.release();
      this._as = null;
    }
    LogTraceExit();
    return 0;
  }
  
  public int call_preprocess()
  {
    LogTraceEntry("");
    this.switchState = 0;
    this._streamType = TraeAudioManager.getAudioStreamType(this._audioStreamTypePolicy);
    if (this._as == null) {
      this._as = new TraeAudioSession(this._context, new TraeAudioSession.ITraeAudioCallback()
      {
        public void onAudioRouteSwitchEnd(String paramAnonymousString, long paramAnonymousLong) {}
        
        public void onAudioRouteSwitchStart(String paramAnonymousString1, String paramAnonymousString2) {}
        
        public void onBeginConnectDevice(String paramAnonymousString) {}
        
        public void onConnectDeviceRes(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean) {}
        
        public void onDeviceChangabledUpdate(boolean paramAnonymousBoolean) {}
        
        public void onDeviceListUpdate(String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3)
        {
          if (AudioDeviceInterface.this.usingJava) {
            AudioDeviceInterface.this.onOutputChanage(paramAnonymousString1);
          }
        }
        
        public void onGetConnectedDeviceRes(int paramAnonymousInt, String paramAnonymousString)
        {
          if (paramAnonymousInt == 0) {
            AudioDeviceInterface.this.onOutputChanage(paramAnonymousString);
          }
        }
        
        public void onGetConnectingDeviceRes(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onGetDeviceListRes(int paramAnonymousInt, String[] paramAnonymousArrayOfString, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
        
        public void onGetStreamTypeRes(int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public void onIsDeviceChangabledRes(int paramAnonymousInt, boolean paramAnonymousBoolean) {}
        
        public void onRingCompletion(int paramAnonymousInt, String paramAnonymousString) {}
        
        public void onServiceStateUpdate(boolean paramAnonymousBoolean)
        {
          if (!paramAnonymousBoolean) {}
          try
          {
            AudioDeviceInterface.this._prelock.lock();
            AudioDeviceInterface.access$102(AudioDeviceInterface.this, true);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
            }
            AudioDeviceInterface.this._precon.signalAll();
            AudioDeviceInterface.this._prelock.unlock();
            return;
          }
          catch (Exception localException) {}
        }
        
        public void onStreamTypeUpdate(int paramAnonymousInt) {}
        
        public void onVoicecallPreprocessRes(int paramAnonymousInt)
        {
          try
          {
            AudioDeviceInterface.this._prelock.lock();
            AudioDeviceInterface.access$102(AudioDeviceInterface.this, true);
            if (QLog.isColorLevel()) {
              QLog.e("TRAE", 2, "onVoicecallPreprocessRes signalAll");
            }
            AudioDeviceInterface.this._precon.signalAll();
            AudioDeviceInterface.this._prelock.unlock();
            return;
          }
          catch (Exception localException) {}
        }
      });
    }
    this._preDone = false;
    if (this._as != null) {
      this._prelock.lock();
    }
    int i;
    int j;
    label208:
    for (;;)
    {
      try
      {
        this._as.getConnectedDevice();
        this._as.voiceCallPreprocess(this._modePolicy, this._streamType);
        i = 7;
        j = i - 1;
        if (i <= 0) {}
      }
      finally
      {
        this._prelock.unlock();
      }
      try
      {
        if (!this._preDone)
        {
          this._precon.await(1L, TimeUnit.SECONDS);
          if (!QLog.isColorLevel()) {
            break label208;
          }
          QLog.e("TRAE", 2, "call_preprocess waiting...  as:" + this._as);
          i = j;
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "call_preprocess done!");
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        continue;
        i = j;
      }
      this._prelock.unlock();
      LogTraceExit();
      return 0;
    }
  }
  
  public int getAudioRouteSwitchState()
  {
    return this.switchState;
  }
  
  public void setContext(Context paramContext)
  {
    this._context = paramContext;
  }
  
  public void setJavaInterface(int paramInt)
  {
    if (paramInt == 0) {}
    for (this.usingJava = false;; this.usingJava = true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setJavaInterface flg:" + paramInt);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.AudioDeviceInterface
 * JD-Core Version:    0.7.0.1
 */