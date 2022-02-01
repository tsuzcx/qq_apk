package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Process;

public class TraeAudioSession
  extends BroadcastReceiver
{
  static final String TAG = "TraeAudioSession";
  static int s_nSessionIdAllocator = 0;
  final String TRAE_ACTION_PHONE_STATE = "android.intent.action.PHONE_STATE";
  private boolean _canSwtich2Earphone = true;
  private String _connectedDev = "DEVICE_NONE";
  private ITraeAudioCallback mCallback;
  private Context mContext;
  private boolean mIsHostside = false;
  private long mSessionId = -9223372036854775808L;
  
  public TraeAudioSession(Context paramContext, ITraeAudioCallback paramITraeAudioCallback)
  {
    if (Process.myPid() == TraeAudioManager._gHostProcessId) {
      bool = true;
    }
    this.mIsHostside = bool;
    this.mSessionId = requestSessionId();
    this.mCallback = paramITraeAudioCallback;
    this.mContext = paramContext;
    if (paramContext == null) {}
    paramITraeAudioCallback = new IntentFilter();
    paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramITraeAudioCallback.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    if ((paramContext != null) && (paramContext.registerReceiver(this, paramITraeAudioCallback) == null)) {}
    registerAudioSession(true);
  }
  
  public static void ExConnectDevice(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", -9223372036854775808L);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    paramContext.sendBroadcast(localIntent);
  }
  
  private int registerAudioSession(boolean paramBoolean)
  {
    if (this.mContext == null) {
      return -1;
    }
    if (this.mIsHostside) {
      return TraeAudioManager.registerAudioSession(paramBoolean, this.mSessionId, this.mContext);
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REGISTERAUDIOSESSION");
    localIntent.putExtra("REGISTERAUDIOSESSION_ISREGISTER", paramBoolean);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static long requestSessionId()
  {
    long l = Process.myPid();
    int i = s_nSessionIdAllocator + 1;
    s_nSessionIdAllocator = i;
    return (l << 32) + i;
  }
  
  public int EarAction(int paramInt)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.earAction("OPERATION_EARACTION", this.mSessionId, this.mIsHostside, paramInt);
    }
    if ((this.mContext == null) || ((paramInt != 0) && (paramInt != 1))) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_EARACTION");
    localIntent.putExtra("EXTRA_EARACTION", paramInt);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int SetBluetoothConnectingTime(long paramLong)
  {
    return TraeAudioManager.setBluetoothConnectingTime(paramLong);
  }
  
  public int connectDevice(String paramString)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.connectDevice("OPERATION_CONNECTDEVICE", this.mSessionId, this.mIsHostside, paramString);
    }
    if ((this.mContext == null) || (paramString == null) || (paramString.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECTDEVICE");
    localIntent.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int connectHighestPriorityDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.connectHighestPriorityDevice("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getConnectedDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getConnectedDevice("OPERATION_GETCONNECTEDDEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTEDDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getConnectingDevice()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getConnectingDevice("OPERATION_GETCONNECTINGDEVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETCONNECTINGDEVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getDeviceList()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getDeviceList("OPERATION_GETDEVICELIST", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETDEVICELIST");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int getStreamType()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.getStreamType("OPERATION_GETSTREAMTYPE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_GETSTREAMTYPE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int isDeviceChangabled()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.isDeviceChangabled("OPERATION_ISDEVICECHANGABLED", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_ISDEVICECHANGABLED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        long l = paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L);
        paramContext = paramIntent.getStringExtra("PARAM_OPERATION");
        int j = paramIntent.getIntExtra("PARAM_RES_ERRCODE", 0);
        paramIntent.getLongExtra("PARAM_seq", 0L);
        String[] arrayOfString;
        String str1;
        String str2;
        if ("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY".equals(paramIntent.getAction()))
        {
          if ("NOTIFY_SERVICE_STATE".equals(paramContext))
          {
            bool = paramIntent.getBooleanExtra("NOTIFY_SERVICE_STATE_DATE", false);
            if (this.mCallback == null) {
              break;
            }
            this.mCallback.onServiceStateUpdate(bool);
            return;
          }
          if ("NOTIFY_DEVICELISTUPDATE".equals(paramContext))
          {
            arrayOfString = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
            str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
            str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
            paramIntent = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
            paramContext = "\n";
            bool = true;
            i = 0;
            if (i < arrayOfString.length)
            {
              paramContext = paramContext + "AudioSession|    " + i + " " + arrayOfString[i] + "\n";
              if (arrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
                break label999;
              }
              if (!arrayOfString[i].equals("DEVICE_BLUETOOTHHEADSET")) {
                break label1002;
              }
              break label999;
            }
            new StringBuilder().append(paramContext).append("\n").toString();
            this._canSwtich2Earphone = bool;
            this._connectedDev = str1;
            if (this.mCallback == null) {
              break;
            }
            this.mCallback.onDeviceListUpdate(arrayOfString, str1, str2, paramIntent);
            return;
          }
          if ("NOTIFY_DEVICECHANGABLE_UPDATE".equals(paramContext))
          {
            bool = paramIntent.getBooleanExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", true);
            if (this.mCallback == null) {
              break;
            }
            this.mCallback.onDeviceChangabledUpdate(bool);
            return;
          }
          if ("NOTIFY_STREAMTYPE_UPDATE".equals(paramContext))
          {
            i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
            if (this.mCallback == null) {
              break;
            }
            this.mCallback.onStreamTypeUpdate(i);
            return;
          }
          if ("NOTIFY_ROUTESWITCHSTART".equals(paramContext))
          {
            paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_FROM");
            paramIntent = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHSTART_TO");
            if ((this.mCallback == null) || (paramContext == null) || (paramIntent == null)) {
              break;
            }
            this.mCallback.onAudioRouteSwitchStart(paramContext, paramIntent);
            return;
          }
          if ("NOTIFY_ROUTESWITCHEND".equals(paramContext))
          {
            paramContext = paramIntent.getStringExtra("EXTRA_DATA_ROUTESWITCHEND_DEV");
            l = paramIntent.getLongExtra("EXTRA_DATA_ROUTESWITCHEND_TIME", -1L);
            if ((this.mCallback == null) || (paramContext == null) || (l == -1L)) {
              break;
            }
            this.mCallback.onAudioRouteSwitchEnd(paramContext, l);
            return;
          }
          if (!"NOTIFY_BEGIN_CONNECTED_DEVICE".equals(paramContext)) {
            break;
          }
          paramContext = paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME");
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onBeginConnectDevice(paramContext);
          return;
        }
        if ((!"com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES".equals(paramIntent.getAction())) || (this.mSessionId != l)) {
          break;
        }
        if ("OPERATION_GETDEVICELIST".equals(paramContext))
        {
          arrayOfString = paramIntent.getStringArrayExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST");
          str1 = paramIntent.getStringExtra("EXTRA_DATA_CONNECTEDDEVICE");
          str2 = paramIntent.getStringExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE");
          paramIntent = paramIntent.getStringExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME");
          paramContext = "\n";
          bool = true;
          i = 0;
          if (i < arrayOfString.length)
          {
            paramContext = paramContext + "AudioSession|    " + i + " " + arrayOfString[i] + "\n";
            if (arrayOfString[i].equals("DEVICE_WIREDHEADSET")) {
              break label1009;
            }
            if (!arrayOfString[i].equals("DEVICE_BLUETOOTHHEADSET")) {
              break label1012;
            }
            break label1009;
          }
          new StringBuilder().append(paramContext).append("\n").toString();
          this._canSwtich2Earphone = bool;
          this._connectedDev = str1;
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onGetDeviceListRes(j, arrayOfString, str1, str2, paramIntent);
          return;
        }
        if ("OPERATION_CONNECTDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("CONNECTDEVICE_RESULT_DEVICENAME");
          if (this.mCallback == null) {
            break;
          }
          paramIntent = this.mCallback;
          if (j != 0) {
            break label1019;
          }
          bool = true;
          paramIntent.onConnectDeviceRes(j, paramContext, bool);
          return;
        }
        if ("OPERATION_EARACTION".equals(paramContext))
        {
          paramIntent.getIntExtra("EXTRA_EARACTION", -1);
          if (this.mCallback == null) {
            break;
          }
          return;
        }
        if ("OPERATION_ISDEVICECHANGABLED".equals(paramContext))
        {
          bool = paramIntent.getBooleanExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", false);
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onIsDeviceChangabledRes(j, bool);
          return;
        }
        if ("OPERATION_GETCONNECTEDDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTEDDEVICE_REULT_LIST");
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onGetConnectedDeviceRes(j, paramContext);
          return;
        }
        if ("OPERATION_GETCONNECTINGDEVICE".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("GETCONNECTINGDEVICE_REULT_LIST");
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onGetConnectingDeviceRes(j, paramContext);
          return;
        }
        if ("OPERATION_GETSTREAMTYPE".equals(paramContext))
        {
          i = paramIntent.getIntExtra("EXTRA_DATA_STREAMTYPE", -1);
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onGetStreamTypeRes(j, i);
          return;
        }
        if ("NOTIFY_RING_COMPLETION".equals(paramContext))
        {
          paramContext = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
          if (this.mCallback == null) {
            break;
          }
          this.mCallback.onRingCompletion(j, paramContext);
          return;
        }
        if ((!"OPERATION_VOICECALL_PREPROCESS".equals(paramContext)) || (this.mCallback == null)) {
          break;
        }
        this.mCallback.onVoicecallPreprocessRes(j);
        return;
      }
      catch (Exception paramContext)
      {
        return;
      }
      label999:
      boolean bool = false;
      label1002:
      i += 1;
      continue;
      label1009:
      bool = false;
      label1012:
      i += 1;
      continue;
      label1019:
      bool = false;
    }
  }
  
  public int recoverAudioFocus()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.recoverAudioFocus("OPERATION_RECOVER_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_RECOVER_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void release()
  {
    if (this.mContext != null) {}
    try
    {
      this.mContext.unregisterReceiver(this);
      label15:
      registerAudioSession(false);
      this.mContext = null;
      this.mCallback = null;
      return;
    }
    catch (Exception localException)
    {
      break label15;
    }
  }
  
  public int requestReleaseAudioFocus()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.requestReleaseAudioFocus("OPERATION_REQUEST_RELEASE_AUDIO_FOCUS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void setCallback(ITraeAudioCallback paramITraeAudioCallback)
  {
    this.mCallback = paramITraeAudioCallback;
  }
  
  @Deprecated
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    return startRing(0L, paramInt1, paramInt2, paramUri, paramString, paramBoolean);
  }
  
  @Deprecated
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    return startRing(0L, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2);
  }
  
  @Deprecated
  public int startRing(int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    return startRing(0L, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
  }
  
  public int startRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString, boolean paramBoolean)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing(paramLong, "OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString, paramBoolean, 1, "normal-ring", false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", "normal-ring");
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    localIntent.putExtra("PARAM_seq", paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean, int paramInt3, String paramString2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing(paramLong, "OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean, paramInt3, paramString2, false);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", false);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    localIntent.putExtra("PARAM_seq", paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startRing(long paramLong, int paramInt1, int paramInt2, Uri paramUri, String paramString1, boolean paramBoolean1, int paramInt3, String paramString2, boolean paramBoolean2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startRing(paramLong, "OPERATION_STARTRING", this.mSessionId, this.mIsHostside, paramInt1, paramInt2, paramUri, paramString1, paramBoolean1, paramInt3, paramString2, paramBoolean2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_RING_DATASOURCE", paramInt1);
    localIntent.putExtra("PARAM_RING_RSID", paramInt2);
    localIntent.putExtra("PARAM_RING_URI", paramUri);
    localIntent.putExtra("PARAM_RING_FILEPATH", paramString1);
    localIntent.putExtra("PARAM_RING_LOOP", paramBoolean1);
    localIntent.putExtra("PARAM_RING_LOOPCOUNT", paramInt3);
    localIntent.putExtra("PARAM_RING_MODE", paramBoolean2);
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", paramString2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTRING");
    localIntent.putExtra("PARAM_seq", paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int startService(long paramLong, String paramString1, String paramString2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.startService(paramLong, "OPERATION_STARTSERVICE", this.mSessionId, this.mIsHostside, paramString1, paramString2);
    }
    if ((this.mContext == null) || (paramString1 == null) || (paramString1.length() <= 0)) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STARTSERVICE");
    localIntent.putExtra("EXTRA_DATA_DEVICECONFIG", paramString1);
    localIntent.putExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString2);
    localIntent.putExtra("PARAM_seq", paramLong);
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  @Deprecated
  public int startService(String paramString1, String paramString2)
  {
    return startService(0L, paramString1, paramString2);
  }
  
  @Deprecated
  public int stopRing()
  {
    return stopRing(0L);
  }
  
  public int stopRing(long paramLong)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.stopRing(paramLong, "OPERATION_STOPRING", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPRING");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int stopService()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.stopService("OPERATION_STOPSERVICE", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_STOPSERVICE");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallAudioParamChanged(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voiceCallAudioParamChanged("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_AUDIOPARAM_CHANGED");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPostprocess()
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPostprocess("OPERATION_VOICECALL_POSTROCESS", this.mSessionId, this.mIsHostside);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_POSTROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public int voiceCallPreprocess(int paramInt1, int paramInt2)
  {
    if (this.mIsHostside) {
      return TraeAudioManager.voicecallPreprocess("OPERATION_VOICECALL_PREPROCESS", this.mSessionId, this.mIsHostside, paramInt1, paramInt2);
    }
    if (this.mContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
    localIntent.putExtra("PARAM_SESSIONID", this.mSessionId);
    localIntent.putExtra("PARAM_MODEPOLICY", paramInt1);
    localIntent.putExtra("PARAM_STREAMTYPE", paramInt2);
    localIntent.putExtra("PARAM_OPERATION", "OPERATION_VOICECALL_PREPROCESS");
    this.mContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public static abstract interface ITraeAudioCallback
  {
    public abstract void onAudioRouteSwitchEnd(String paramString, long paramLong);
    
    public abstract void onAudioRouteSwitchStart(String paramString1, String paramString2);
    
    public abstract void onBeginConnectDevice(String paramString);
    
    public abstract void onConnectDeviceRes(int paramInt, String paramString, boolean paramBoolean);
    
    public abstract void onDeviceChangabledUpdate(boolean paramBoolean);
    
    public abstract void onDeviceListUpdate(String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void onGetConnectedDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetConnectingDeviceRes(int paramInt, String paramString);
    
    public abstract void onGetDeviceListRes(int paramInt, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
    
    public abstract void onGetStreamTypeRes(int paramInt1, int paramInt2);
    
    public abstract void onIsDeviceChangabledRes(int paramInt, boolean paramBoolean);
    
    public abstract void onRingCompletion(int paramInt, String paramString);
    
    public abstract void onServiceStateUpdate(boolean paramBoolean);
    
    public abstract void onStreamTypeUpdate(int paramInt);
    
    public abstract void onVoicecallPreprocessRes(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioSession
 * JD-Core Version:    0.7.0.1
 */