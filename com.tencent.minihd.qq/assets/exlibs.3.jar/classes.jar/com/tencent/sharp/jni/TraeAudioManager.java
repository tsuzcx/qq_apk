package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qav.QavSDK;
import com.tencent.qav.log.AVLog;
import com.tencent.qav.log.QLog;
import com.tencent.qav.session.SessionInfo;
import com.tencent.qav.session.SessionMgr;
import com.tencent.qav.thread.ThreadManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioManager
  extends BroadcastReceiver
{
  public static final String ACTION_GVIDEO_TRAEAUDIOMANAGER_REQUEST = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
  public static final String ACTION_TRAEAUDIOMANAGER_NOTIFY = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY";
  public static final String ACTION_TRAEAUDIOMANAGER_REQUEST = "com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST";
  public static final String ACTION_TRAEAUDIOMANAGER_RES = "com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES";
  public static final int AUDIO_MANAGER_ACTIVE_NONE = 0;
  public static final int AUDIO_MANAGER_ACTIVE_RING = 2;
  public static final int AUDIO_MANAGER_ACTIVE_VOICECALL = 1;
  public static final String CONNECTDEVICE_DEVICENAME = "CONNECTDEVICE_DEVICENAME";
  public static final String CONNECTDEVICE_RESULT_DEVICENAME = "CONNECTDEVICE_RESULT_DEVICENAME";
  public static final String DEVICE_BLUETOOTHHEADSET = "DEVICE_BLUETOOTHHEADSET";
  public static final String DEVICE_EARPHONE = "DEVICE_EARPHONE";
  public static final String DEVICE_NONE = "DEVICE_NONE";
  public static final String DEVICE_SPEAKERPHONE = "DEVICE_SPEAKERPHONE";
  public static final int DEVICE_STATUS_CONNECTED = 2;
  public static final int DEVICE_STATUS_CONNECTING = 1;
  public static final int DEVICE_STATUS_DISCONNECTED = 0;
  public static final int DEVICE_STATUS_DISCONNECTING = 3;
  public static final int DEVICE_STATUS_ERROR = -1;
  public static final int DEVICE_STATUS_UNCHANGEABLE = 4;
  public static final String DEVICE_WIREDHEADSET = "DEVICE_WIREDHEADSET";
  public static final int EARACTION_AWAY = 0;
  public static final int EARACTION_CLOSE = 1;
  public static final String EXTRA_DATA_AVAILABLEDEVICE_LIST = "EXTRA_DATA_AVAILABLEDEVICE_LIST";
  public static final String EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON = "EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON";
  public static final String EXTRA_DATA_CONNECTEDDEVICE = "EXTRA_DATA_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_DEVICECONFIG = "EXTRA_DATA_DEVICECONFIG";
  public static final String EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME = "EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME";
  public static final String EXTRA_DATA_PREV_CONNECTEDDEVICE = "EXTRA_DATA_PREV_CONNECTEDDEVICE";
  public static final String EXTRA_DATA_ROUTESWITCHEND_DEV = "EXTRA_DATA_ROUTESWITCHEND_DEV";
  public static final String EXTRA_DATA_ROUTESWITCHEND_TIME = "EXTRA_DATA_ROUTESWITCHEND_TIME";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_FROM = "EXTRA_DATA_ROUTESWITCHSTART_FROM";
  public static final String EXTRA_DATA_ROUTESWITCHSTART_TO = "EXTRA_DATA_ROUTESWITCHSTART_TO";
  public static final String EXTRA_DATA_STREAMTYPE = "EXTRA_DATA_STREAMTYPE";
  public static final String EXTRA_EARACTION = "EXTRA_EARACTION";
  public static final int FORCE_ANALOG_DOCK = 8;
  public static final int FORCE_BT_A2DP = 4;
  public static final int FORCE_BT_CAR_DOCK = 6;
  public static final int FORCE_BT_DESK_DOCK = 7;
  public static final int FORCE_BT_SCO = 3;
  public static final int FORCE_DEFAULT = 0;
  public static final int FORCE_DIGITAL_DOCK = 9;
  public static final int FORCE_HEADPHONES = 2;
  public static final int FORCE_NONE = 0;
  public static final int FORCE_NO_BT_A2DP = 10;
  public static final int FORCE_SPEAKER = 1;
  public static final int FORCE_WIRED_ACCESSORY = 5;
  public static final int FOR_COMMUNICATION = 0;
  public static final int FOR_DOCK = 3;
  public static final int FOR_MEDIA = 1;
  public static final int FOR_RECORD = 2;
  public static final String GETCONNECTEDDEVICE_RESULT_LIST = "GETCONNECTEDDEVICE_REULT_LIST";
  public static final String GETCONNECTINGDEVICE_RESULT_LIST = "GETCONNECTINGDEVICE_REULT_LIST";
  public static final String ISDEVICECHANGABLED_RESULT_ISCHANGABLED = "ISDEVICECHANGABLED_REULT_ISCHANGABLED";
  public static final String NOTIFY_BEGIN_CONNECTED_DEVICE = "NOTIFY_BEGIN_CONNECTED_DEVICE";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE = "NOTIFY_DEVICECHANGABLE_UPDATE";
  public static final String NOTIFY_DEVICECHANGABLE_UPDATE_DATE = "NOTIFY_DEVICECHANGABLE_UPDATE_DATE";
  public static final String NOTIFY_DEVICELIST_UPDATE = "NOTIFY_DEVICELISTUPDATE";
  public static final String NOTIFY_RING_COMPLETION = "NOTIFY_RING_COMPLETION";
  public static final String NOTIFY_ROUTESWITCHEND = "NOTIFY_ROUTESWITCHEND";
  public static final String NOTIFY_ROUTESWITCHSTART = "NOTIFY_ROUTESWITCHSTART";
  public static final String NOTIFY_SERVICE_STATE = "NOTIFY_SERVICE_STATE";
  public static final String NOTIFY_SERVICE_STATE_DATE = "NOTIFY_SERVICE_STATE_DATE";
  public static final String NOTIFY_STREAMTYPE_UPDATE = "NOTIFY_STREAMTYPE_UPDATE";
  private static final int NUM_FORCE_CONFIG = 11;
  private static final int NUM_FORCE_USE = 4;
  public static final String OPERATION_CONNECTDEVICE = "OPERATION_CONNECTDEVICE";
  public static final String OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE = "OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE";
  public static final String OPERATION_EARACTION = "OPERATION_EARACTION";
  public static final String OPERATION_GETCONNECTEDDEVICE = "OPERATION_GETCONNECTEDDEVICE";
  public static final String OPERATION_GETCONNECTINGDEVICE = "OPERATION_GETCONNECTINGDEVICE";
  public static final String OPERATION_GETDEVICELIST = "OPERATION_GETDEVICELIST";
  public static final String OPERATION_GETSTREAMTYPE = "OPERATION_GETSTREAMTYPE";
  public static final String OPERATION_ISDEVICECHANGABLED = "OPERATION_ISDEVICECHANGABLED";
  public static final String OPERATION_RECOVER_AUDIO_FOCUS = "OPERATION_RECOVER_AUDIO_FOCUS";
  public static final String OPERATION_REGISTERAUDIOSESSION = "OPERATION_REGISTERAUDIOSESSION";
  public static final String OPERATION_REQUEST_RELEASE_AUDIO_FOCUS = "OPERATION_REQUEST_RELEASE_AUDIO_FOCUS";
  public static final String OPERATION_STARTRING = "OPERATION_STARTRING";
  public static final String OPERATION_STARTSERVICE = "OPERATION_STARTSERVICE";
  public static final String OPERATION_STOPRING = "OPERATION_STOPRING";
  public static final String OPERATION_STOPSERVICE = "OPERATION_STOPSERVICE";
  public static final String OPERATION_VOICECALL_AUDIOPARAM_CHANGED = "OPERATION_VOICECALL_AUDIOPARAM_CHANGED";
  public static final String OPERATION_VOICECALL_POSTPROCESS = "OPERATION_VOICECALL_POSTROCESS";
  public static final String OPERATION_VOICECALL_PREPROCESS = "OPERATION_VOICECALL_PREPROCESS";
  public static final String PARAM_DEVICE = "PARAM_DEVICE";
  public static final String PARAM_ERROR = "PARAM_ERROR";
  public static final String PARAM_From = "PARAM_From";
  public static final String PARAM_ISHOSTSIDE = "PARAM_ISHOSTSIDE";
  public static final String PARAM_MODEPOLICY = "PARAM_MODEPOLICY";
  public static final String PARAM_OPERATION = "PARAM_OPERATION";
  public static final String PARAM_RES_ERRCODE = "PARAM_RES_ERRCODE";
  public static final String PARAM_RING_DATASOURCE = "PARAM_RING_DATASOURCE";
  public static final String PARAM_RING_FILEPATH = "PARAM_RING_FILEPATH";
  public static final String PARAM_RING_LOOP = "PARAM_RING_LOOP";
  public static final String PARAM_RING_LOOPCOUNT = "PARAM_RING_LOOPCOUNT";
  public static final String PARAM_RING_MODE = "PARAM_RING_MODE";
  public static final String PARAM_RING_RSID = "PARAM_RING_RSID";
  public static final String PARAM_RING_URI = "PARAM_RING_URI";
  public static final String PARAM_RING_USERDATA_STRING = "PARAM_RING_USERDATA_STRING";
  public static final String PARAM_SESSIONID = "PARAM_SESSIONID";
  public static final String PARAM_STATUS = "PARAM_STATUS";
  public static final String PARAM_STREAMTYPE = "PARAM_STREAMTYPE";
  public static final String PARAM_seq = "PARAM_seq";
  public static final String REGISTERAUDIOSESSION_ISREGISTER = "REGISTERAUDIOSESSION_ISREGISTER";
  public static final int RES_ERRCODE_DEVICE_BTCONNCECTED_TIMEOUT = 10;
  public static final int RES_ERRCODE_DEVICE_NOT_VISIABLE = 8;
  public static final int RES_ERRCODE_DEVICE_UNCHANGEABLE = 9;
  public static final int RES_ERRCODE_DEVICE_UNKOWN = 7;
  public static final int RES_ERRCODE_NONE = 0;
  public static final int RES_ERRCODE_RING_NOT_EXIST = 5;
  public static final int RES_ERRCODE_SERVICE_OFF = 1;
  public static final int RES_ERRCODE_STOPRING_INTERRUPT = 4;
  public static final int RES_ERRCODE_VOICECALLPOST_INTERRUPT = 6;
  public static final int RES_ERRCODE_VOICECALL_EXIST = 2;
  public static final int RES_ERRCODE_VOICECALL_NOT_EXIST = 3;
  private static final String TAG = "TraeAudioManager";
  public static final String VIDEO_CONFIG = "DEVICE_EARPHONE;DEVICE_SPEAKERPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  public static final String VOICECALL_CONFIG = "DEVICE_SPEAKERPHONE;DEVICE_EARPHONE;DEVICE_BLUETOOTHHEADSET;DEVICE_WIREDHEADSET;";
  static int _gHostProcessId = -1;
  static TraeAudioManager _ginstance;
  static ReentrantLock _glock;
  static final String[] forceName = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  private static long sBluetoothDelayTime = 5000L;
  String BTDisConnectSessionConnectedDev = "DEVICE_NONE";
  int _activeMode = 0;
  AudioManager _am = null;
  TraeAudioSessionHost _audioSessionHost = null;
  BluetoohHeadsetCheckInterface _bluetoothCheck = null;
  Context _context = null;
  DeviceConfigManager _deviceConfigManager = null;
  int _modePolicy = -1;
  int _prevMode = 0;
  int _streamType = 0;
  switchThread _switchThread = null;
  TraeAudioManagerLooper mTraeAudioManagerLooper = null;
  boolean running_stat = true;
  String sessionConnectedDev = "DEVICE_NONE";
  
  static
  {
    _glock = new ReentrantLock();
    _ginstance = null;
  }
  
  TraeAudioManager(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this._context = paramContext;
    this.mTraeAudioManagerLooper = new TraeAudioManagerLooper(this);
    AudioDeviceInterface.LogTraceExit();
  }
  
  static boolean IsEabiLowVersion()
  {
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if ((IsEabiLowVersionByAbi(str2)) && (IsEabiLowVersionByAbi(str1))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return IsEabiLowVersionByAbi(str2);
    }
    return false;
  }
  
  public static boolean IsEabiLowVersionByAbi(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return true;
      if (paramString.contains("x86")) {
        return false;
      }
      if (paramString.contains("mips")) {
        return false;
      }
    } while ((paramString.equalsIgnoreCase("armeabi")) || (!paramString.equalsIgnoreCase("armeabi-v7a")));
    return false;
  }
  
  public static boolean checkDevName(String paramString)
  {
    if (paramString == null) {}
    while ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  static int connectDevice(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    return sendMessage(32775, localHashMap);
  }
  
  static int connectHighestPriorityDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32789, localHashMap);
  }
  
  static int earAction(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return sendMessage(32776, localHashMap);
  }
  
  static void forceVolumeControlStream(AudioManager paramAudioManager, int paramInt)
  {
    if (Build.MANUFACTURER.equals("Google")) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Google phone nothing to do");
      }
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 28) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Android P system nothing to do, version: " + Build.VERSION.SDK_INT);
      return;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Class[] arrayOfClass = new Class[arrayOfObject.length];
      arrayOfClass[0] = Integer.TYPE;
      paramAudioManager = invokeMethod(paramAudioManager, "forceVolumeControlStream", arrayOfObject, arrayOfClass);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
  }
  
  static int getAudioSource(int paramInt)
  {
    int i = 0;
    if (IsEabiLowVersion()) {
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      return paramInt;
    }
    paramInt = i;
    if (j >= 11) {
      paramInt = 7;
    }
    return paramInt;
  }
  
  static int getAudioStreamType(int paramInt)
  {
    int i = 3;
    if (IsEabiLowVersion()) {
      return 3;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {}
    for (;;)
    {
      return paramInt;
      paramInt = i;
      if (j >= 9) {
        paramInt = 0;
      }
    }
  }
  
  static int getCallAudioMode(int paramInt)
  {
    int i = 0;
    if (IsEabiLowVersion()) {
      return 0;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      return paramInt;
    }
    paramInt = i;
    if (j >= 11) {
      paramInt = 3;
    }
    return paramInt;
  }
  
  static int getConnectedDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32778, localHashMap);
  }
  
  static int getConnectingDevice(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32779, localHashMap);
  }
  
  static int getDeviceList(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32774, localHashMap);
  }
  
  static String getForceConfigName(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < forceName.length)) {
      return forceName[paramInt];
    }
    return "unknow";
  }
  
  static int getForceUse(int paramInt)
  {
    Integer localInteger = Integer.valueOf(0);
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "getForceUse", (Object[])localObject, arrayOfClass);
    if (localObject != null) {
      localInteger = (Integer)localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "getForceUse  usage:" + paramInt + " config:" + localInteger + " ->" + getForceConfigName(localInteger.intValue()));
    }
    return localInteger.intValue();
  }
  
  static long getSeq(HashMap<String, Object> paramHashMap)
  {
    if ((paramHashMap != null) && (paramHashMap.containsKey("PARAM_seq")))
    {
      paramHashMap = paramHashMap.get("PARAM_seq");
      if ((paramHashMap instanceof Long)) {
        return ((Long)paramHashMap).longValue();
      }
    }
    return 0L;
  }
  
  static int getStreamType(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32784, localHashMap);
  }
  
  private boolean getSysSpeakerphoneOn()
  {
    try
    {
      boolean bool = this._am.isSpeakerphoneOn();
      return bool;
    }
    catch (Exception localException)
    {
      AVLog.e("TraeAudioManager", localException.getMessage());
    }
    return false;
  }
  
  public static int init(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance == null) {
      _ginstance = new TraeAudioManager(paramContext);
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  public static Object invokeMethod(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      try
      {
        paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
        return paramObject;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "invokeMethod Exception:" + paramObject.getMessage());
    return null;
  }
  
  public static Object invokeStaticMethod(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static boolean isCloseSystemAPM(int paramInt)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return false;
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
          break;
        }
        if (Build.MODEL.equals("MI 2")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2A")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2S")) {
          return true;
        }
      } while (!Build.MODEL.equals("MI 2SC"));
      return true;
    } while ((!Build.MANUFACTURER.equals("samsung")) || (!Build.MODEL.equals("SCH-I959")));
    return true;
  }
  
  static int isDeviceChangabled(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32777, localHashMap);
  }
  
  public static boolean isHandfree(String paramString)
  {
    if (!checkDevName(paramString)) {}
    while (!"DEVICE_SPEAKERPHONE".equals(paramString)) {
      return false;
    }
    return true;
  }
  
  static int recoverAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32791, localHashMap);
  }
  
  public static int registerAudioSession(boolean paramBoolean, long paramLong, Context paramContext)
  {
    int j = -1;
    _glock.lock();
    int i = j;
    if (_ginstance != null)
    {
      i = j;
      if (_ginstance._audioSessionHost != null)
      {
        if (!paramBoolean) {
          break label59;
        }
        _ginstance._audioSessionHost.add(paramLong, paramContext);
      }
    }
    for (;;)
    {
      i = 0;
      _glock.unlock();
      return i;
      label59:
      _ginstance._audioSessionHost.remove(paramLong);
    }
  }
  
  static int requestReleaseAudioFocus(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32790, localHashMap);
  }
  
  public static int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    _glock.lock();
    if (_ginstance != null) {
      i = _ginstance.internalSendMessage(paramInt, paramHashMap);
    }
    _glock.unlock();
    return i;
  }
  
  static int setBluetoothConnectingTime(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "setBluetoothConnectingTime,time: " + paramLong);
    }
    sBluetoothDelayTime = paramLong;
    return 0;
  }
  
  static void setForceUse(int paramInt1, int paramInt2)
  {
    Object localObject = new Object[2];
    localObject[0] = Integer.valueOf(paramInt1);
    localObject[1] = Integer.valueOf(paramInt2);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Integer.TYPE;
    localObject = invokeStaticMethod("android.media.AudioSystem", "setForceUse", (Object[])localObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + getForceConfigName(paramInt2) + " res:" + localObject);
    }
  }
  
  static void setParameters(String paramString)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = paramString;
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = String.class;
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "setParameters  :" + paramString);
    }
    invokeStaticMethod("android.media.AudioSystem", "setParameters", arrayOfObject, arrayOfClass);
  }
  
  static void setPhoneState(int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = Integer.TYPE;
    invokeStaticMethod("android.media.AudioSystem", "setPhoneState", arrayOfObject, arrayOfClass);
  }
  
  static int startRing(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    localHashMap.put("PARAM_seq", Long.valueOf(paramLong1));
    return sendMessage(32782, localHashMap);
  }
  
  static int startService(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString3);
    localHashMap.put("PARAM_seq", Long.valueOf(paramLong1));
    return sendMessage(32772, localHashMap);
  }
  
  static int stopRing(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_seq", Long.valueOf(paramLong1));
    return sendMessage(32783, localHashMap);
  }
  
  static int stopService(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32773, localHashMap);
  }
  
  public static void uninit()
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + _ginstance);
    _glock.lock();
    if (_ginstance != null)
    {
      _ginstance.release();
      _ginstance = null;
    }
    _glock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int voiceCallAudioParamChanged(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32788, localHashMap);
  }
  
  static int voicecallPostprocess(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return sendMessage(32781, localHashMap);
  }
  
  static int voicecallPreprocess(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return sendMessage(32780, localHashMap);
  }
  
  public BluetoohHeadsetCheckInterface CreateBluetoothCheck(Context paramContext, DeviceConfigManager paramDeviceConfigManager)
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT != 18))
    {
      localObject1 = new BluetoohHeadsetCheck();
      localObject2 = localObject1;
      if (!((BluetoohHeadsetCheckInterface)localObject1).init(paramContext, paramDeviceConfigManager)) {
        localObject2 = new BluetoohHeadsetCheckFake();
      }
      if (QLog.isColorLevel())
      {
        paramDeviceConfigManager = new StringBuilder().append("CreateBluetoothCheck:").append(((BluetoohHeadsetCheckInterface)localObject2).interfaceDesc()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label143;
        }
      }
    }
    label143:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TraeAudioManager", 2, paramContext);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new BluetoohHeadsetCheckFor2x();
        break;
      }
      localObject1 = new BluetoohHeadsetCheckFake();
      break;
    }
  }
  
  int InternalConnectDevice(String paramString, HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        return -1;
        if ((!this._deviceConfigManager.getConnectedDevice().equals("DEVICE_NONE")) && (paramString.equals(this._deviceConfigManager.getConnectedDevice()))) {
          return 0;
        }
        if ((checkDevName(paramString) == true) && (this._deviceConfigManager.getVisible(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " checkDevName fail");
      return -1;
      if (InternalIsDeviceChangeable() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TraeAudioManager", 2, " InternalIsDeviceChangeable fail");
    return -1;
    this._deviceConfigManager.setConnecting(paramString);
    if (this._switchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "_switchThread:" + this._switchThread.getDeviceName());
      }
      this.running_stat = false;
      this._switchThread.quit(0L);
      this._switchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this._switchThread = new earphoneSwitchThread();
    }
    for (;;)
    {
      if (this._switchThread != null)
      {
        this.running_stat = true;
        this._switchThread.setDeviceConnectParam(paramHashMap);
        paramHashMap = new Intent();
        paramHashMap.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        paramHashMap.putExtra("PARAM_OPERATION", "NOTIFY_BEGIN_CONNECTED_DEVICE");
        paramHashMap.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
      }
      try
      {
        this._context.sendBroadcast(paramHashMap);
        this._switchThread.start(0L);
        AudioDeviceInterface.LogTraceExit();
        return 0;
        if (paramString.equals("DEVICE_SPEAKERPHONE"))
        {
          this._switchThread = new speakerSwitchThread();
          continue;
        }
        if (paramString.equals("DEVICE_WIREDHEADSET"))
        {
          this._switchThread = new headsetSwitchThread();
          continue;
        }
        if (!paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
          continue;
        }
        this._switchThread = new bluetoothHeadsetSwitchThread();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalConnectDevice notify error, e = " + paramString);
          }
        }
      }
    }
  }
  
  boolean InternalIsDeviceChangeable()
  {
    String str = this._deviceConfigManager.getConnectingDevice();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int InternalNotifyDeviceChangableUpdate()
  {
    if (this._context == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
    localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", InternalIsDeviceChangeable());
    try
    {
      this._context.sendBroadcast(localIntent);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceChangableUpdate e = " + localException);
        }
      }
    }
  }
  
  int InternalNotifyDeviceListUpdate()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this._context == null) {
      return -1;
    }
    Object localObject = this._deviceConfigManager.getSnapParams();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this._deviceConfigManager.getBluetoothName());
    try
    {
      this._context.sendBroadcast(localIntent);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceListUpdate e = " + localException);
        }
      }
    }
  }
  
  int InternalSessionConnectDevice(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this._context == null)) {
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    int i = 0;
    boolean bool = InternalIsDeviceChangeable();
    StringBuilder localStringBuilder;
    if (checkDevName(str) != true)
    {
      i = 7;
      this.BTDisConnectSessionConnectedDev = str;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("sessonID:").append((Long)paramHashMap.get("PARAM_SESSIONID")).append(" devName:").append(str).append(" bChangabled:");
        if (!bool) {
          break label216;
        }
      }
    }
    label216:
    for (Object localObject = "Y";; localObject = "N")
    {
      QLog.w("TraeAudioManager", 2, (String)localObject + " err:" + i);
      if (i == 0) {
        break label224;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
      sendResBroadcast((Intent)localObject, paramHashMap, i);
      return -1;
      if (!this._deviceConfigManager.getVisible(str))
      {
        i = 8;
        break;
      }
      if (bool) {
        break;
      }
      i = 9;
      this.sessionConnectedDev = str;
      break;
    }
    label224:
    if (str.equals(this._deviceConfigManager.getConnectedDevice()))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " --has connected!");
      }
      localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
      sendResBroadcast((Intent)localObject, paramHashMap, i);
      return 0;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " --connecting...");
    }
    InternalConnectDevice(str, paramHashMap);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int InternalSessionEarAction(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  int InternalSessionGetConnectedDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this._deviceConfigManager.getConnectedDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionGetConnectingDevice(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this._deviceConfigManager.getConnectingDevice());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int InternalSessionIsDeviceChangabled(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", InternalIsDeviceChangeable());
    sendResBroadcast(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void InternalSetMode(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "SetMode entry:" + paramInt);
    }
    if (this._am == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "setMode:" + paramInt + " fail am=null");
      }
    }
    do
    {
      return;
      this._am.setMode(paramInt);
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("setMode:").append(paramInt);
    if (this._am.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      QLog.w("TraeAudioManager", 2, str);
      return;
    }
  }
  
  int InternalSetSpeaker(long paramLong, Context paramContext, boolean paramBoolean)
  {
    int k;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no context");
      }
      k = -1;
      return k;
    }
    paramContext = (AudioManager)paramContext.getSystemService("audio");
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no audio manager");
      }
      return -1;
    }
    boolean bool = isCloseSystemAPM(this._modePolicy);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, isSpeakerphoneOn[" + paramContext.isSpeakerphoneOn() + "], speakerOn[" + paramBoolean + "], isCloseSystemAPM[" + bool + "], _activeMode[" + this._activeMode + "], seq[" + paramLong + "]");
    }
    if ((bool) && (this._activeMode != 2)) {
      return InternalSetSpeakerSpe(paramContext, paramBoolean);
    }
    int i = 0;
    int j = i;
    for (;;)
    {
      try
      {
        if (paramContext.isSpeakerphoneOn() != paramBoolean)
        {
          j = i;
          paramContext.setSpeakerphoneOn(paramBoolean);
        }
        j = i;
        if (paramContext.isSpeakerphoneOn() != paramBoolean) {
          break label344;
        }
        i = 0;
        k = i;
        j = i;
        if (!QLog.isColorLevel()) {
          break;
        }
        j = i;
        QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, res[" + i + "], mode[" + paramContext.getMode() + "], seq[" + paramLong + "]");
        return i;
      }
      catch (Exception paramContext)
      {
        k = j;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, seq[" + paramLong + "]", paramContext);
      return j;
      label344:
      i = -1;
    }
  }
  
  int InternalSetSpeakerSpe(AudioManager paramAudioManager, boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this._streamType + " media_force_use:" + getForceUse(1));
    }
    if (paramBoolean)
    {
      InternalSetMode(0);
      paramAudioManager.setSpeakerphoneOn(true);
      setForceUse(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label178;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      InternalSetMode(3);
      paramAudioManager.setSpeakerphoneOn(false);
      setForceUse(1, 0);
      break;
      label178:
      i = -1;
    }
  }
  
  void _updateEarphoneVisable()
  {
    if (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))
    {
      this._deviceConfigManager.setVisible("DEVICE_EARPHONE", false);
      return;
    }
    this._deviceConfigManager.setVisible("DEVICE_EARPHONE", true);
  }
  
  void checkAutoDeviceListUpdate()
  {
    checkAutoDeviceListUpdate(null);
  }
  
  void checkAutoDeviceListUpdate(String paramString)
  {
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true)
    {
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      HashMap localHashMap = new HashMap();
      localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString);
      internalSendMessage(32785, localHashMap);
    }
  }
  
  void checkDevicePlug(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this._deviceConfigManager.getVisiableUpdateFlag() == true) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label117;
        }
      }
    }
    label117:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TraeAudioManager", 2, (String)localObject + " connectedDev:" + this._deviceConfigManager.getConnectedDevice());
      _updateEarphoneVisable();
      this._deviceConfigManager.resetVisiableUpdateFlag();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32786, (HashMap)localObject);
      return;
    }
    localObject = this._deviceConfigManager.getConnectedDevice();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      internalSendMessage(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    internalSendMessage(32793, new HashMap());
  }
  
  int internalSendMessage(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    if (this.mTraeAudioManagerLooper != null) {
      i = this.mTraeAudioManagerLooper.sendMessage(paramInt, paramHashMap);
    }
    return i;
  }
  
  void onHeadsetPlug(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = "" + " [" + paramContext + "] ";
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      localObject = new StringBuilder().append((String)localObject);
      if (i == 0)
      {
        paramContext = "unplugged";
        paramContext = paramContext;
      }
    }
    else
    {
      localObject = paramContext + " mic:";
      int j = paramIntent.getIntExtra("microphone", -1);
      paramContext = (Context)localObject;
      if (j != -1)
      {
        paramIntent = new StringBuilder().append((String)localObject);
        if (j != 1) {
          break label256;
        }
        paramContext = "Y";
        label168:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this._deviceConfigManager;
      if (1 != i) {
        break label263;
      }
    }
    label256:
    label263:
    for (boolean bool = true;; bool = false)
    {
      paramContext.setVisible("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      paramContext = "unkown";
      break label168;
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TraeAudioManager", 2, "onReceive intent or context is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        long l = paramIntent.getLongExtra("PARAM_seq", 0L);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
        }
        if (this._deviceConfigManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TraeAudioManager", 2, "_deviceConfigManager null!");
          }
        }
        else
        {
          boolean bool1 = this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET");
          boolean bool2 = this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET");
          if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
          {
            onHeadsetPlug(paramContext, paramIntent);
            if ((!bool1) && (this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET") == true)) {
              checkDevicePlug("DEVICE_WIREDHEADSET", true);
            }
            if ((bool1 == true) && (!this._deviceConfigManager.getVisible("DEVICE_WIREDHEADSET"))) {
              checkDevicePlug("DEVICE_WIREDHEADSET", false);
            }
          }
          else if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
          {
            if ("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE.qav", 2, "   OPERATION:" + str1);
              }
              if ("OPERATION_REGISTERAUDIOSESSION".equals(str1))
              {
                registerAudioSession(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
                return;
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                startService(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                stopService(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                getDeviceList(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                getStreamType(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                connectDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                connectHighestPriorityDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                earAction(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                isDeviceChangabled(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                getConnectedDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                getConnectingDevice(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              int i;
              int j;
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voicecallPreprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                voicecallPostprocess(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                voiceCallAudioParamChanged(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_STARTRING".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
                j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
                paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
                str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
                bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
                String str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
                int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
                bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
                startRing(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                stopRing(l, str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              }
            }
            else if (this._deviceConfigManager != null)
            {
              if (this._bluetoothCheck != null) {
                this._bluetoothCheck.onReceive(paramContext, paramIntent, this._deviceConfigManager);
              }
              if ((!bool2) && (this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET") == true)) {
                checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
              }
              if ((bool2 == true) && (!this._deviceConfigManager.getVisible("DEVICE_BLUETOOTHHEADSET")))
              {
                checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramContext) {}
    }
  }
  
  void printDevices()
  {
    AudioDeviceInterface.LogTraceEntry("");
    int j = this._deviceConfigManager.getDeviceNumber();
    int i = 0;
    while (i < j)
    {
      this._deviceConfigManager.getDeviceName(i);
      i += 1;
    }
    String[] arrayOfString = (String[])this._deviceConfigManager.getAvailableDeviceList().toArray(new String[0]);
    i = 0;
    while (i < arrayOfString.length)
    {
      String str = arrayOfString[i];
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void release()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.mTraeAudioManagerLooper != null)
    {
      this.mTraeAudioManagerLooper.quit();
      this.mTraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  int sendResBroadcast(Intent paramIntent, HashMap<String, Object> paramHashMap, int paramInt)
  {
    if ((this._context == null) || (paramHashMap == null)) {
      return -1;
    }
    Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    String str = (String)paramHashMap.get("PARAM_OPERATION");
    long l = getSeq(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "sendResBroadcast, operation[" + str + "], sid[" + localLong + "], seq[" + l + "]");
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      InternalNotifyDeviceListUpdate();
      return -1;
    }
    paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramIntent.putExtra("PARAM_SESSIONID", localLong);
    paramIntent.putExtra("PARAM_OPERATION", str);
    paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
    paramIntent.putExtra("PARAM_seq", l);
    try
    {
      this._context.sendBroadcast(paramIntent);
      return 0;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "sendResBroadcast Exception, operation[" + str + "], seq[" + l + "]", paramIntent);
        }
      }
    }
  }
  
  void updateDeviceStatus(String paramString)
  {
    int j = this._deviceConfigManager.getDeviceNumber();
    int i = 0;
    if (i < j)
    {
      boolean bool2 = false;
      String str = this._deviceConfigManager.getDeviceName(i);
      boolean bool1 = bool2;
      if (str != null)
      {
        if (!str.equals("DEVICE_BLUETOOTHHEADSET")) {
          break label100;
        }
        if (this._bluetoothCheck != null) {
          break label79;
        }
        bool1 = this._deviceConfigManager.setVisible(str, false);
      }
      for (;;)
      {
        if (bool1 == true) {}
        i += 1;
        break;
        label79:
        bool1 = this._deviceConfigManager.setVisible(str, this._bluetoothCheck.isConnected());
        continue;
        label100:
        if (str.equals("DEVICE_WIREDHEADSET"))
        {
          bool1 = this._deviceConfigManager.setVisible(str, this._am.isWiredHeadsetOn());
        }
        else
        {
          bool1 = bool2;
          if (str.equals("DEVICE_SPEAKERPHONE"))
          {
            this._deviceConfigManager.setVisible(str, true);
            bool1 = bool2;
          }
        }
      }
    }
    checkAutoDeviceListUpdate(paramString);
  }
  
  class BluetoohHeadsetCheck
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
    implements BluetoothProfile.ServiceListener
  {
    BluetoothAdapter _adapter = null;
    Context _ctx = null;
    TraeAudioManager.DeviceConfigManager _devCfg = null;
    BluetoothProfile _profile = null;
    
    BluetoohHeadsetCheck()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED");
      paramIntentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
      paramIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      if ("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", -1);
        j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", -1);
        paramIntent = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "BT ACTION_CONNECTION_STATE_CHANGED|   EXTRA_CONNECTION_STATE " + getBTAdapterConnectionState(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "    EXTRA_PREVIOUS_CONNECTION_STATE " + getBTAdapterConnectionState(j));
        }
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder().append("    EXTRA_DEVICE ").append(paramIntent).append(" ");
          if (paramIntent != null)
          {
            paramContext = paramIntent.getName();
            QLog.w("TraeAudioManager", 2, paramContext);
          }
        }
        else
        {
          if (i != 2) {
            break label268;
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder().append("   dev:");
            if (paramIntent == null) {
              break label256;
            }
            paramContext = paramIntent.getName();
            label197:
            QLog.w("TraeAudioManager", 2, paramContext + " connected,start sco...");
          }
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          localObject = this._devCfg;
          if (paramIntent == null) {
            break label262;
          }
          paramContext = paramIntent.getName();
          label243:
          ((TraeAudioManager.DeviceConfigManager)localObject).setBluetoothName(paramContext);
        }
      }
      label256:
      label262:
      label268:
      label443:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramContext = " ";
                break;
                paramContext = "null";
                break label197;
                paramContext = "unkown";
                break label243;
              } while (i != 0);
              this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
              return;
              if (!"android.media.ACTION_SCO_AUDIO_STATE_UPDATED".equals(paramIntent.getAction())) {
                break label443;
              }
              i = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", -1);
              j = paramIntent.getIntExtra("android.media.extra.SCO_AUDIO_PREVIOUS_STATE", -1);
              paramContext = (BluetoothDevice)paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
              if (QLog.isColorLevel()) {
                QLog.w("TraeAudioManager", 2, "BT ACTION_SCO_AUDIO_STATE_UPDATED|   EXTRA_CONNECTION_STATE  dev:" + paramContext);
              }
              if (QLog.isColorLevel()) {
                QLog.w("TraeAudioManager", 2, "   EXTRA_SCO_AUDIO_STATE " + getSCOAudioStateExtraString(i) + "  Bluetooth visible:" + this._devCfg.getVisible("DEVICE_BLUETOOTHHEADSET"));
              }
            } while (!QLog.isColorLevel());
            QLog.w("TraeAudioManager", 2, "   EXTRA_SCO_AUDIO_PREVIOUS_STATE " + getSCOAudioStateExtraString(j));
            return;
          } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(paramIntent.getAction()));
          paramContext = BluetoothAdapter.getDefaultAdapter();
          QLog.w("TraeAudioManager", 2, "BluetoothA2dp STATE_CHANGE: " + paramContext.getProfileConnectionState(2));
        } while (paramContext.getProfileConnectionState(2) != 1);
        QLog.w("TraeAudioManager", 2, "BluetoothA2dp STATE_CONNECTING, Bluetooth visible: " + this._devCfg.getVisible("DEVICE_BLUETOOTHHEADSET") + " ConnectedDev: " + TraeAudioManager.this._deviceConfigManager.getConnectedDevice());
      } while ((!this._devCfg.getVisible("DEVICE_BLUETOOTHHEADSET")) || (TraeAudioManager.this._deviceConfigManager.getConnectedDevice().equals("DEVICE_BLUETOOTHHEADSET")));
      this._devCfg.setDeviceCanUse("DEVICE_BLUETOOTHHEADSET", true);
      this._devCfg.setVisiableUpdateFlag(true);
      TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
    }
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AudioDeviceInterface.LogTraceEntry("");
      if ((paramContext == null) || (paramDeviceConfigManager == null)) {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " err ctx==null||_devCfg==null");
        }
      }
      do
      {
        do
        {
          return false;
          this._ctx = paramContext;
          this._devCfg = paramDeviceConfigManager;
          this._adapter = BluetoothAdapter.getDefaultAdapter();
          if (this._adapter != null) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("TraeAudioManager", 2, " err getDefaultAdapter fail!");
        return false;
        if ((!this._adapter.isEnabled()) || (this._profile != null) || (this._adapter.getProfileProxy(this._ctx, this, 1))) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, "BluetoohHeadsetCheck: getProfileProxy HEADSET fail!");
      return false;
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheck";
    }
    
    public boolean isConnected()
    {
      bool2 = false;
      bool1 = bool2;
      if (this._profile != null) {}
      for (;;)
      {
        try
        {
          List localList = this._profile.getConnectedDevices();
          if (localList == null) {
            return false;
          }
          int i = localList.size();
          if (i <= 0) {
            continue;
          }
          bool1 = true;
        }
        catch (Exception localException)
        {
          bool1 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("TraeAudioManager", 2, " isConnected e = " + localException);
          bool1 = bool2;
          continue;
        }
        return bool1;
        bool1 = false;
      }
    }
    
    public void onServiceConnected(int paramInt, BluetoothProfile paramBluetoothProfile)
    {
      if (paramInt == 1)
      {
        if ((this._profile != null) && (this._profile != paramBluetoothProfile))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "BluetoohHeadsetCheck: HEADSET Connected proxy:" + paramBluetoothProfile + " _profile:" + this._profile);
          }
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
        this._profile = paramBluetoothProfile;
        ThreadManager.executeOnSubThread(new Runnable()
        {
          public void run()
          {
            BluetoothDevice localBluetoothDevice = null;
            Object localObject = localBluetoothDevice;
            if (TraeAudioManager.BluetoohHeadsetCheck.this._profile != null) {}
            try
            {
              localObject = TraeAudioManager.BluetoohHeadsetCheck.this._profile.getConnectedDevices();
              if (localObject != null)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("TraeAudioManager", 2, "TRAEBluetoohProxy: HEADSET Connected devs:" + ((List)localObject).size() + " _profile:" + TraeAudioManager.BluetoohHeadsetCheck.this._profile);
                }
                int i = 0;
                while (i < ((List)localObject).size())
                {
                  localBluetoothDevice = (BluetoothDevice)((List)localObject).get(i);
                  int j = TraeAudioManager.BluetoohHeadsetCheck.this._profile.getConnectionState(localBluetoothDevice);
                  if (j == 2) {
                    TraeAudioManager.BluetoohHeadsetCheck.this._devCfg.setBluetoothName(localBluetoothDevice.getName());
                  }
                  if (QLog.isColorLevel()) {
                    QLog.w("TraeAudioManager", 2, "   " + i + " " + localBluetoothDevice.getName() + " ConnectionState:" + j);
                  }
                  i += 1;
                }
              }
            }
            catch (Exception localException)
            {
              for (;;)
              {
                localObject = localBluetoothDevice;
                if (QLog.isColorLevel())
                {
                  QLog.e("TraeAudioManager", 2, "onServiceConnected.run e = " + localException);
                  localObject = localBluetoothDevice;
                }
              }
              if (TraeAudioManager.BluetoohHeadsetCheck.this._devCfg != null)
              {
                localObject = null;
                if (TraeAudioManager.this._deviceConfigManager != null) {
                  localObject = TraeAudioManager.this._deviceConfigManager.getBluetoothName();
                }
                if (TextUtils.isEmpty((CharSequence)localObject)) {
                  TraeAudioManager.BluetoohHeadsetCheck.this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                }
              }
              else
              {
                return;
              }
            }
            if (TraeAudioManager.BluetoohHeadsetCheck.this.isConnected())
            {
              TraeAudioManager.BluetoohHeadsetCheck.this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
              TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
              return;
            }
            TraeAudioManager.BluetoohHeadsetCheck.this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          }
        });
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void onServiceDisconnected(int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile + " profile:" + paramInt);
      if (paramInt == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "TRAEBluetoohProxy: HEADSET Disconnected");
        }
        if (isConnected()) {
          TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", false);
        }
        if (this._profile != null)
        {
          this._adapter.closeProfileProxy(1, this._profile);
          this._profile = null;
        }
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("_profile:" + this._profile);
      try
      {
        if (this._adapter != null)
        {
          if (this._profile != null) {
            this._adapter.closeProfileProxy(1, this._profile);
          }
          this._profile = null;
        }
        AudioDeviceInterface.LogTraceExit();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, " closeProfileProxy:e:" + localException.getMessage());
          }
        }
      }
    }
  }
  
  class BluetoohHeadsetCheckFake
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckFake()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter) {}
    
    void _onReceive(Context paramContext, Intent paramIntent) {}
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      return true;
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFake";
    }
    
    public boolean isConnected()
    {
      return false;
    }
    
    public void release() {}
  }
  
  class BluetoohHeadsetCheckFor2x
    extends TraeAudioManager.BluetoohHeadsetCheckInterface
  {
    public static final String ACTION_BLUETOOTHHEADSET_AUDIO_STATE_CHANGED = "android.bluetooth.headset.action.AUDIO_STATE_CHANGED";
    public static final String ACTION_BLUETOOTHHEADSET_STATE_CHANGED = "android.bluetooth.headset.action.STATE_CHANGED";
    static final int STATE_CONNECTED = 2;
    static final int STATE_DISCONNECTED = 0;
    Class<?> BluetoothHeadsetClass = null;
    Object BluetoothHeadsetObj = null;
    Class<?> ListenerClass = null;
    Context _ctx = null;
    TraeAudioManager.DeviceConfigManager _devCfg = null;
    Method getCurrentHeadsetMethod = null;
    
    BluetoohHeadsetCheckFor2x()
    {
      super();
    }
    
    void _addAction(IntentFilter paramIntentFilter)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " " + interfaceDesc() + " _addAction");
      }
      paramIntentFilter.addAction("android.bluetooth.headset.action.AUDIO_STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.headset.action.STATE_CHANGED");
    }
    
    void _onReceive(Context paramContext, Intent paramIntent)
    {
      int i;
      int j;
      int k;
      if ("android.bluetooth.headset.action.AUDIO_STATE_CHANGED".equals(paramIntent.getAction()))
      {
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "++ AUDIO_STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       AUDIO_STATE " + k);
        }
        if (k != 2) {}
      }
      do
      {
        do
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          do
          {
            return;
          } while (k != 0);
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
          return;
        } while (!"android.bluetooth.headset.action.STATE_CHANGED".equals(paramIntent.getAction()));
        i = paramIntent.getIntExtra("android.bluetooth.headset.extra.STATE", -2);
        j = paramIntent.getIntExtra("android.bluetooth.headset.extra.PREVIOUS_STATE", -2);
        k = paramIntent.getIntExtra("android.bluetooth.headset.extra.AUDIO_STATE", -2);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "++ STATE_CHANGED|  STATE " + i);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       PREVIOUS_STATE " + j);
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "       AUDIO_STATE " + k);
        }
        if (k == 2)
        {
          this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
          return;
        }
      } while (k != 0);
      this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
    }
    
    public boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      AudioDeviceInterface.LogTraceEntry("");
      this._ctx = paramContext;
      this._devCfg = paramDeviceConfigManager;
      if ((this._ctx == null) || (this._devCfg == null)) {}
      for (;;)
      {
        return false;
        try
        {
          this.BluetoothHeadsetClass = Class.forName("android.bluetooth.BluetoothHeadset");
          if (this.BluetoothHeadsetClass == null) {
            continue;
          }
        }
        catch (Exception paramDeviceConfigManager)
        {
          try
          {
            this.ListenerClass = Class.forName("android.bluetooth.BluetoothHeadset$ServiceListener");
          }
          catch (Exception paramDeviceConfigManager)
          {
            try
            {
              this.getCurrentHeadsetMethod = this.BluetoothHeadsetClass.getDeclaredMethod("getCurrentHeadset", new Class[0]);
              if (this.getCurrentHeadsetMethod == null) {
                continue;
              }
            }
            catch (NoSuchMethodException paramDeviceConfigManager)
            {
              try
              {
                do
                {
                  for (;;)
                  {
                    this.BluetoothHeadsetObj = this.BluetoothHeadsetClass.getConstructor(new Class[] { Context.class, this.ListenerClass }).newInstance(new Object[] { paramContext, null });
                    if (this.BluetoothHeadsetObj == null) {
                      break;
                    }
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", isConnected());
                    if (!isConnected()) {
                      break label337;
                    }
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", true);
                    TraeAudioManager.this.checkDevicePlug("DEVICE_BLUETOOTHHEADSET", true);
                    AudioDeviceInterface.LogTraceExit();
                    return true;
                    paramDeviceConfigManager = paramDeviceConfigManager;
                    if (QLog.isColorLevel())
                    {
                      QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset class not found");
                      continue;
                      paramDeviceConfigManager = paramDeviceConfigManager;
                      if (QLog.isColorLevel()) {
                        QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset.ServiceListener class not found:" + paramDeviceConfigManager);
                      }
                    }
                  }
                  paramDeviceConfigManager = paramDeviceConfigManager;
                } while (!QLog.isColorLevel());
                QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset NoSuchMethodException");
              }
              catch (IllegalArgumentException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalArgumentException");
                  }
                }
              }
              catch (InstantiationException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor InstantiationException");
                  }
                }
              }
              catch (IllegalAccessException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor IllegalAccessException");
                  }
                }
              }
              catch (InvocationTargetException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor InvocationTargetException");
                  }
                }
              }
              catch (NoSuchMethodException paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel())
                  {
                    QLog.e("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset getConstructor NoSuchMethodException");
                    continue;
                    label337:
                    this._devCfg.setVisible("DEVICE_BLUETOOTHHEADSET", false);
                  }
                }
              }
            }
          }
        }
      }
    }
    
    public String interfaceDesc()
    {
      return "BluetoohHeadsetCheckFor2x";
    }
    
    public boolean isConnected()
    {
      String str4 = null;
      if ((this.getCurrentHeadsetMethod == null) || (this.getCurrentHeadsetMethod == null)) {
        return false;
      }
      try
      {
        Object localObject = this.getCurrentHeadsetMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder().append("BTLooperThread BluetoothHeadset method getCurrentHeadset res:");
          if (localObject != null)
          {
            str4 = " Y";
            QLog.w("TraeAudioManager", 2, str4);
          }
        }
        else
        {
          if (localObject == null) {
            break label152;
          }
          return true;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        for (;;)
        {
          String str1 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalArgumentException");
            str1 = str4;
          }
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          String str2 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset IllegalAccessException");
            str2 = str4;
          }
        }
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        for (;;)
        {
          String str3 = str4;
          if (QLog.isColorLevel())
          {
            QLog.w("TraeAudioManager", 2, "BTLooperThread BluetoothHeadset method getCurrentHeadset InvocationTargetException");
            str3 = str4;
            continue;
            str4 = "N";
          }
        }
      }
      label152:
      return false;
    }
    
    public void release()
    {
      AudioDeviceInterface.LogTraceEntry("");
      Object localObject2 = null;
      if (this.BluetoothHeadsetObj == null) {}
      for (;;)
      {
        return;
        try
        {
          localMethod = this.BluetoothHeadsetClass.getDeclaredMethod("close", new Class[0]);
          if (localMethod == null) {
            continue;
          }
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          try
          {
            label46:
            do
            {
              Method localMethod;
              localMethod.invoke(this.BluetoothHeadsetObj, new Object[0]);
              this.BluetoothHeadsetClass = null;
              this.ListenerClass = null;
              this.BluetoothHeadsetObj = null;
              this.getCurrentHeadsetMethod = null;
              AudioDeviceInterface.LogTraceExit();
              return;
              localNoSuchMethodException = localNoSuchMethodException;
              localObject1 = localObject2;
            } while (!QLog.isColorLevel());
            QLog.e("TraeAudioManager", 2, "BTLooperThread _uninitHeadsetfor2x method close NoSuchMethodException");
            Object localObject1 = localObject2;
          }
          catch (InvocationTargetException localInvocationTargetException)
          {
            break label46;
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            break label46;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            break label46;
          }
        }
      }
    }
  }
  
  abstract class BluetoohHeadsetCheckInterface
  {
    BluetoohHeadsetCheckInterface() {}
    
    abstract void _addAction(IntentFilter paramIntentFilter);
    
    abstract void _onReceive(Context paramContext, Intent paramIntent);
    
    public void addAction(IntentFilter paramIntentFilter)
    {
      paramIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_CONNECTED");
      paramIntentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
      _addAction(paramIntentFilter);
    }
    
    String getBTActionStateChangedExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_OFF";
        continue;
        str = "STATE_TURNING_ON";
        continue;
        str = "STATE_ON";
        continue;
        str = "STATE_TURNING_OFF";
      }
    }
    
    String getBTAdapterConnectionState(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "STATE_DISCONNECTED";
        continue;
        str = "STATE_CONNECTING";
        continue;
        str = "STATE_CONNECTED";
        continue;
        str = "STATE_DISCONNECTING";
      }
    }
    
    String getSCOAudioStateExtraString(int paramInt)
    {
      String str;
      switch (paramInt)
      {
      default: 
        str = "unknow";
      }
      for (;;)
      {
        return str + ":" + paramInt;
        str = "SCO_AUDIO_STATE_DISCONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTED";
        continue;
        str = "SCO_AUDIO_STATE_CONNECTING";
        continue;
        str = "SCO_AUDIO_STATE_ERROR";
      }
    }
    
    public abstract boolean init(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager);
    
    public abstract String interfaceDesc();
    
    public abstract boolean isConnected();
    
    public void onReceive(Context paramContext, Intent paramIntent, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
    {
      if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(paramIntent.getAction()))
      {
        int i = paramIntent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
        int j = paramIntent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", -1);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_STATE " + getBTActionStateChangedExtraString(i));
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "BT ACTION_STATE_CHANGED|   EXTRA_PREVIOUS_STATE " + getBTActionStateChangedExtraString(j));
        }
        if (i == 10)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "    BT off");
          }
          paramDeviceConfigManager.setVisible("DEVICE_BLUETOOTHHEADSET", false);
        }
        while ((i != 12) || (!QLog.isColorLevel())) {
          return;
        }
        QLog.w("TraeAudioManager", 2, "BT OFF-->ON,Visiable it...");
        return;
      }
      _onReceive(paramContext, paramIntent);
    }
    
    public abstract void release();
  }
  
  class DeviceConfigManager
  {
    String _bluetoothDevName = "unknow";
    String connectedDevice = "DEVICE_NONE";
    String connectingDevice = "DEVICE_NONE";
    HashMap<String, DeviceConfig> deviceConfigs = new HashMap();
    ReentrantLock mLock = new ReentrantLock();
    String prevConnectedDevice = "DEVICE_NONE";
    boolean visiableUpdate = false;
    
    public DeviceConfigManager() {}
    
    boolean _addConfig(String paramString, int paramInt)
    {
      AudioDeviceInterface.LogTraceEntry(" devName:" + paramString + " priority:" + paramInt);
      DeviceConfig localDeviceConfig = new DeviceConfig();
      if ((!localDeviceConfig.init(paramString, paramInt)) || (this.deviceConfigs.containsKey(paramString))) {
        return false;
      }
      this.deviceConfigs.put(paramString, localDeviceConfig);
      this.visiableUpdate = true;
      AudioDeviceInterface.LogTraceExit();
      return true;
    }
    
    ArrayList<String> _getAvailableDeviceList()
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        DeviceConfig localDeviceConfig = (DeviceConfig)((Map.Entry)localIterator.next()).getValue();
        if ((localDeviceConfig != null) && (localDeviceConfig.getVisible()) && (localDeviceConfig.getDeviceCanUse())) {
          localArrayList.add(localDeviceConfig.getDeviceName());
        }
      }
      return localArrayList;
    }
    
    String _getConnectedDevice()
    {
      String str2 = "DEVICE_NONE";
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(this.connectedDevice);
      String str1 = str2;
      if (localDeviceConfig != null)
      {
        str1 = str2;
        if (localDeviceConfig.getVisible()) {
          str1 = this.connectedDevice;
        }
      }
      return str1;
    }
    
    String _getPrevConnectedDevice()
    {
      String str2 = "DEVICE_NONE";
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(this.prevConnectedDevice);
      String str1 = str2;
      if (localDeviceConfig != null)
      {
        str1 = str2;
        if (localDeviceConfig.getVisible()) {
          str1 = this.prevConnectedDevice;
        }
      }
      return str1;
    }
    
    public void clearConfig()
    {
      this.mLock.lock();
      this.deviceConfigs.clear();
      this.prevConnectedDevice = "DEVICE_NONE";
      this.connectedDevice = "DEVICE_NONE";
      this.connectingDevice = "DEVICE_NONE";
      this.mLock.unlock();
    }
    
    public ArrayList<String> getAvailableDeviceList()
    {
      new ArrayList();
      this.mLock.lock();
      ArrayList localArrayList = _getAvailableDeviceList();
      this.mLock.unlock();
      return localArrayList;
    }
    
    public String getAvailabledHighestPriorityDevice()
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((DeviceConfig)localObject2).getVisible()) && (((DeviceConfig)localObject2).getDeviceCanUse())) {
          if (localObject1 == null) {
            localObject1 = localObject2;
          } else if (((DeviceConfig)localObject2).getPriority() >= localObject1.getPriority()) {
            localObject1 = localObject2;
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getAvailabledHighestPriorityDevice(String paramString)
    {
      Object localObject1 = null;
      this.mLock.lock();
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (Map.Entry)localIterator.next();
        ((Map.Entry)localObject2).getKey();
        ((Map.Entry)localObject2).getValue();
        localObject2 = (DeviceConfig)((Map.Entry)localObject2).getValue();
        if ((localObject2 != null) && (((DeviceConfig)localObject2).getVisible()) && (!((DeviceConfig)localObject2).getDeviceName().equals(paramString))) {
          if (localObject1 == null) {
            localObject1 = localObject2;
          } else if (((DeviceConfig)localObject2).getPriority() >= localObject1.getPriority()) {
            localObject1 = localObject2;
          }
        }
      }
      this.mLock.unlock();
      if (localObject1 != null) {
        return localObject1.getDeviceName();
      }
      return "DEVICE_SPEAKERPHONE";
    }
    
    public String getBluetoothName()
    {
      return this._bluetoothDevName;
    }
    
    public String getConnectedDevice()
    {
      this.mLock.lock();
      String str = _getConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public String getConnectingDevice()
    {
      this.mLock.lock();
      Object localObject2 = null;
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(this.connectingDevice);
      Object localObject1 = localObject2;
      if (localDeviceConfig != null)
      {
        localObject1 = localObject2;
        if (localDeviceConfig.getVisible()) {
          localObject1 = this.connectingDevice;
        }
      }
      this.mLock.unlock();
      return localObject1;
    }
    
    public String getDeviceName(int paramInt)
    {
      String str = "DEVICE_NONE";
      int i = 0;
      this.mLock.lock();
      Object localObject2 = null;
      Iterator localIterator = this.deviceConfigs.entrySet().iterator();
      for (;;)
      {
        Object localObject1 = localObject2;
        if (localIterator.hasNext())
        {
          localObject1 = (Map.Entry)localIterator.next();
          if (i == paramInt) {
            localObject1 = (DeviceConfig)((Map.Entry)localObject1).getValue();
          }
        }
        else
        {
          if (localObject1 != null) {
            str = ((DeviceConfig)localObject1).getDeviceName();
          }
          this.mLock.unlock();
          return str;
        }
        i += 1;
      }
    }
    
    public int getDeviceNumber()
    {
      this.mLock.lock();
      int i = this.deviceConfigs.size();
      this.mLock.unlock();
      return i;
    }
    
    public String getPrevConnectedDevice()
    {
      this.mLock.lock();
      String str = _getPrevConnectedDevice();
      this.mLock.unlock();
      return str;
    }
    
    public int getPriority(String paramString)
    {
      int i = -1;
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {
        i = paramString.getPriority();
      }
      this.mLock.unlock();
      return i;
    }
    
    public HashMap<String, Object> getSnapParams()
    {
      HashMap localHashMap = new HashMap();
      this.mLock.lock();
      localHashMap.put("EXTRA_DATA_AVAILABLEDEVICE_LIST", _getAvailableDeviceList());
      localHashMap.put("EXTRA_DATA_CONNECTEDDEVICE", _getConnectedDevice());
      localHashMap.put("EXTRA_DATA_PREV_CONNECTEDDEVICE", _getPrevConnectedDevice());
      this.mLock.unlock();
      return localHashMap;
    }
    
    public boolean getVisiableUpdateFlag()
    {
      this.mLock.lock();
      boolean bool = this.visiableUpdate;
      this.mLock.unlock();
      return bool;
    }
    
    public boolean getVisible(String paramString)
    {
      boolean bool = false;
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      if (paramString != null) {
        bool = paramString.getVisible();
      }
      this.mLock.unlock();
      return bool;
    }
    
    public boolean init(String paramString)
    {
      AudioDeviceInterface.LogTraceEntry(" strConfigs:" + paramString);
      if ((paramString == null) || (paramString.length() <= 0)) {
        return false;
      }
      String str = paramString.replace("\n", "").replace("\r", "");
      if ((str == null) || (str.length() <= 0)) {
        return false;
      }
      paramString = str;
      if (str.indexOf(";") < 0) {
        paramString = str + ";";
      }
      paramString = paramString.split(";");
      if ((paramString == null) || (1 > paramString.length)) {
        return false;
      }
      this.mLock.lock();
      int i = 0;
      while (i < paramString.length)
      {
        _addConfig(paramString[i], i);
        i += 1;
      }
      this.mLock.unlock();
      TraeAudioManager.this.printDevices();
      return true;
    }
    
    public boolean isConnected(String paramString)
    {
      boolean bool2 = false;
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      boolean bool1 = bool2;
      if (localDeviceConfig != null)
      {
        bool1 = bool2;
        if (localDeviceConfig.getVisible()) {
          bool1 = this.connectedDevice.equals(paramString);
        }
      }
      this.mLock.unlock();
      return bool1;
    }
    
    public void resetVisiableUpdateFlag()
    {
      this.mLock.lock();
      this.visiableUpdate = false;
      this.mLock.unlock();
    }
    
    public void setBluetoothName(String paramString)
    {
      if (paramString == null)
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      if (paramString.isEmpty())
      {
        this._bluetoothDevName = "unknow";
        return;
      }
      this._bluetoothDevName = paramString;
    }
    
    public boolean setConnected(String paramString)
    {
      boolean bool2 = false;
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      boolean bool1 = bool2;
      if (localDeviceConfig != null)
      {
        bool1 = bool2;
        if (localDeviceConfig.getVisible())
        {
          if ((this.connectedDevice != null) && (!this.connectedDevice.equals(paramString))) {
            this.prevConnectedDevice = this.connectedDevice;
          }
          this.connectedDevice = paramString;
          this.connectingDevice = "";
          bool1 = true;
        }
      }
      this.mLock.unlock();
      return bool1;
    }
    
    public boolean setConnecting(String paramString)
    {
      boolean bool2 = false;
      this.mLock.lock();
      DeviceConfig localDeviceConfig = (DeviceConfig)this.deviceConfigs.get(paramString);
      boolean bool1 = bool2;
      if (localDeviceConfig != null)
      {
        bool1 = bool2;
        if (localDeviceConfig.getVisible())
        {
          this.connectingDevice = paramString;
          bool1 = true;
        }
      }
      this.mLock.unlock();
      return bool1;
    }
    
    public boolean setDeviceCanUse(String paramString, boolean paramBoolean)
    {
      boolean bool2 = false;
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.getDeviceCanUse() != paramBoolean)
        {
          paramString.setDeviceCanUse(paramBoolean);
          this.visiableUpdate = true;
          bool1 = true;
        }
      }
      this.mLock.unlock();
      return bool1;
    }
    
    public void setVisiableUpdateFlag(boolean paramBoolean)
    {
      this.mLock.lock();
      this.visiableUpdate = paramBoolean;
      this.mLock.unlock();
    }
    
    public boolean setVisible(String paramString, boolean paramBoolean)
    {
      boolean bool2 = false;
      this.mLock.lock();
      paramString = (DeviceConfig)this.deviceConfigs.get(paramString);
      boolean bool1 = bool2;
      if (paramString != null)
      {
        bool1 = bool2;
        if (paramString.getVisible() != paramBoolean)
        {
          paramString.setVisible(paramBoolean);
          paramString.setDeviceCanUse(paramBoolean);
          this.visiableUpdate = true;
          bool1 = true;
        }
      }
      this.mLock.unlock();
      return bool1;
    }
    
    public class DeviceConfig
    {
      boolean deviceCanUse = false;
      String deviceName = "DEVICE_NONE";
      int priority = 0;
      boolean visible = false;
      
      public DeviceConfig() {}
      
      public boolean getDeviceCanUse()
      {
        return this.deviceCanUse;
      }
      
      public String getDeviceName()
      {
        return this.deviceName;
      }
      
      public int getPriority()
      {
        return this.priority;
      }
      
      public boolean getVisible()
      {
        return this.visible;
      }
      
      public boolean init(String paramString, int paramInt)
      {
        if ((paramString == null) || (paramString.length() <= 0)) {}
        while (TraeAudioManager.checkDevName(paramString) != true) {
          return false;
        }
        this.deviceName = paramString;
        this.priority = paramInt;
        return true;
      }
      
      public void setDeviceCanUse(boolean paramBoolean)
      {
        this.deviceCanUse = paramBoolean;
      }
      
      public void setVisible(boolean paramBoolean)
      {
        this.visible = paramBoolean;
      }
    }
  }
  
  public class Parameters
  {
    public static final String BLUETOOTHPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.BLUETOOTHPOLICY";
    public static final String CONTEXT = "com.tencent.sharp.TraeAudioManager.Parameters.CONTEXT";
    public static final String DEVICECONFIG = "com.tencent.sharp.TraeAudioManager.Parameters.DEVICECONFIG";
    public static final String MODEPOLICY = "com.tencent.sharp.TraeAudioManager.Parameters.MODEPOLICY";
    
    public Parameters() {}
  }
  
  class TraeAudioManagerLooper
    extends Thread
  {
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE = 32786;
    public static final int MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE = 32787;
    public static final int MESSAGE_AUTO_DEVICELIST_UPDATE = 32785;
    public static final int MESSAGE_BEGIN = 32768;
    public static final int MESSAGE_BLUETOOTH_SCO_DISCONNECTED = 32792;
    public static final int MESSAGE_CONNECTDEVICE = 32775;
    public static final int MESSAGE_CONNECT_HIGHEST_PRIORITY_DEVICE = 32789;
    public static final int MESSAGE_DISABLE = 32773;
    public static final int MESSAGE_EARACTION = 32776;
    public static final int MESSAGE_ENABLE = 32772;
    public static final int MESSAGE_GETCONNECTEDDEVICE = 32778;
    public static final int MESSAGE_GETCONNECTINGDEVICE = 32779;
    public static final int MESSAGE_GETDEVICELIST = 32774;
    public static final int MESSAGE_GETSTREAMTYPE = 32784;
    public static final int MESSAGE_ISDEVICECHANGABLED = 32777;
    public static final int MESSAGE_NOTIFY_DEVICELIST_UPDATE = 32793;
    public static final int MESSAGE_RECOVER_AUDIO_FOCUS = 32791;
    public static final int MESSAGE_REQUEST_RELEASE_AUDIO_FOCUS = 32790;
    public static final int MESSAGE_STARTRING = 32782;
    public static final int MESSAGE_STOPRING = 32783;
    public static final int MESSAGE_VOICECALLPOSTPROCESS = 32781;
    public static final int MESSAGE_VOICECALLPREPROCESS = 32780;
    public static final int MESSAGE_VOICECALL_AUIDOPARAM_CHANGED = 32788;
    boolean _enabled;
    int _focusSteamType;
    String _lastCfg;
    TraeAudioManager _parent;
    int _preRingMode;
    int _preServiceMode;
    String _ringOperation;
    TraeMediaPlayer _ringPlayer;
    long _ringSessionID;
    String _ringUserdata;
    final boolean[] _started;
    String _voiceCallOperation;
    long _voiceCallSessionID;
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener;
    Handler mMsgHandler;
    
    /* Error */
    public TraeAudioManagerLooper(TraeAudioManager paramTraeAudioManager)
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 90	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:this$0	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   5: aload_0
      //   6: invokespecial 93	java/lang/Thread:<init>	()V
      //   9: aload_0
      //   10: aconst_null
      //   11: putfield 95	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mMsgHandler	Landroid/os/Handler;
      //   14: aload_0
      //   15: aconst_null
      //   16: putfield 97	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringPlayer	Lcom/tencent/sharp/jni/TraeMediaPlayer;
      //   19: aload_0
      //   20: ldc2_w 98
      //   23: putfield 101	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringSessionID	J
      //   26: aload_0
      //   27: ldc 103
      //   29: putfield 105	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringOperation	Ljava/lang/String;
      //   32: aload_0
      //   33: ldc 103
      //   35: putfield 107	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_ringUserdata	Ljava/lang/String;
      //   38: aload_0
      //   39: iconst_1
      //   40: newarray boolean
      //   42: dup
      //   43: iconst_0
      //   44: iconst_0
      //   45: bastore
      //   46: putfield 109	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   49: aload_0
      //   50: iconst_0
      //   51: putfield 111	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_enabled	Z
      //   54: aload_0
      //   55: aconst_null
      //   56: putfield 113	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   59: aload_0
      //   60: ldc 103
      //   62: putfield 115	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_lastCfg	Ljava/lang/String;
      //   65: aload_0
      //   66: iconst_0
      //   67: putfield 117	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preServiceMode	I
      //   70: aload_0
      //   71: iconst_0
      //   72: putfield 119	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_preRingMode	I
      //   75: aload_0
      //   76: ldc2_w 98
      //   79: putfield 121	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallSessionID	J
      //   82: aload_0
      //   83: ldc 103
      //   85: putfield 123	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_voiceCallOperation	Ljava/lang/String;
      //   88: aload_0
      //   89: aconst_null
      //   90: putfield 125	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:mAudioFocusChangeListener	Landroid/media/AudioManager$OnAudioFocusChangeListener;
      //   93: aload_0
      //   94: iconst_0
      //   95: putfield 127	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_focusSteamType	I
      //   98: aload_0
      //   99: aload_2
      //   100: putfield 113	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_parent	Lcom/tencent/sharp/jni/TraeAudioManager;
      //   103: invokestatic 133	android/os/SystemClock:elapsedRealtime	()J
      //   106: lstore_3
      //   107: invokestatic 139	com/tencent/qav/log/QLog:isColorLevel	()Z
      //   110: ifeq +11 -> 121
      //   113: ldc 141
      //   115: iconst_2
      //   116: ldc 143
      //   118: invokestatic 147	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   121: aload_0
      //   122: invokevirtual 150	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:start	()V
      //   125: aload_0
      //   126: getfield 109	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   129: astore_1
      //   130: aload_1
      //   131: monitorenter
      //   132: aload_0
      //   133: getfield 109	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   136: iconst_0
      //   137: baload
      //   138: istore 5
      //   140: iload 5
      //   142: ifne +10 -> 152
      //   145: aload_0
      //   146: getfield 109	com/tencent/sharp/jni/TraeAudioManager$TraeAudioManagerLooper:_started	[Z
      //   149: invokevirtual 155	java/lang/Object:wait	()V
      //   152: aload_1
      //   153: monitorexit
      //   154: invokestatic 139	com/tencent/qav/log/QLog:isColorLevel	()Z
      //   157: ifeq +37 -> 194
      //   160: ldc 141
      //   162: iconst_2
      //   163: new 157	java/lang/StringBuilder
      //   166: dup
      //   167: invokespecial 158	java/lang/StringBuilder:<init>	()V
      //   170: ldc 160
      //   172: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   175: invokestatic 133	android/os/SystemClock:elapsedRealtime	()J
      //   178: lload_3
      //   179: lsub
      //   180: invokevirtual 167	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   183: ldc 169
      //   185: invokevirtual 164	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   188: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   191: invokestatic 147	com/tencent/qav/log/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
      //   194: return
      //   195: astore_2
      //   196: aload_1
      //   197: monitorexit
      //   198: aload_2
      //   199: athrow
      //   200: astore_2
      //   201: goto -49 -> 152
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	204	0	this	TraeAudioManagerLooper
      //   0	204	1	this$1	TraeAudioManager
      //   0	204	2	paramTraeAudioManager	TraeAudioManager
      //   106	73	3	l	long
      //   138	3	5	i	int
      // Exception table:
      //   from	to	target	type
      //   132	140	195	finally
      //   145	152	195	finally
      //   152	154	195	finally
      //   196	198	195	finally
      //   145	152	200	java/lang/InterruptedException
    }
    
    int InternalGetStreamType(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + this._preRingMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {}
      for (int i = this._ringPlayer.getStreamType();; i = TraeAudioManager.this._streamType)
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
    }
    
    int InternalNotifyStreamTypeUpdate(int paramInt)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
      try
      {
        TraeAudioManager.this._context.sendBroadcast(localIntent);
        return 0;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalNotifyStreamTypeUpdate e = " + localException);
          }
        }
      }
    }
    
    int InternalSessionGetDeviceList(HashMap<String, Object> paramHashMap)
    {
      Intent localIntent = new Intent();
      Object localObject = TraeAudioManager.this._deviceConfigManager.getSnapParams();
      ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
      String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
      localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
      localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
      localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
      localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
      localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", TraeAudioManager.this._deviceConfigManager.getBluetoothName());
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      return 0;
    }
    
    int InternalStartRing(HashMap<String, Object> paramHashMap)
    {
      long l = TraeAudioManager.getSeq(paramHashMap);
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("InternalStartRing begin, _activeMode[").append(TraeAudioManager.this._activeMode).append("], _am[");
        if (TraeAudioManager.this._am == null) {
          break label101;
        }
      }
      label101:
      for (boolean bool1 = true;; bool1 = false)
      {
        QLog.w("TraeAudioManager", 1, bool1 + "], seq[" + l + "]");
        if (TraeAudioManager.this._am != null) {
          break;
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 2) {
        interruptRing(l);
      }
      for (;;)
      {
        try
        {
          this._ringSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
          this._ringOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
          this._ringUserdata = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
          int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
          int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
          localObject = (Uri)paramHashMap.get("PARAM_RING_URI");
          String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
          boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
          int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
          boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
          if (TraeAudioManager.this._activeMode != 1) {
            TraeAudioManager.this._activeMode = 2;
          }
          Intent localIntent = new Intent();
          localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
          TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
          this._preRingMode = TraeAudioManager.this._am.getMode();
          paramHashMap = this._ringPlayer;
          if (TraeAudioManager.this._activeMode == 1)
          {
            bool1 = true;
            bool1 = paramHashMap.playRing(l, i, j, (Uri)localObject, str, bool2, k, bool3, bool1, TraeAudioManager.this._streamType);
            if (!this._ringPlayer.hasCall()) {
              requestAudioFocus(this._ringPlayer.getStreamType());
            }
            InternalNotifyStreamTypeUpdate(this._ringPlayer.getStreamType());
            if (QLog.isColorLevel()) {
              QLog.w("TraeAudioManager", 1, "InternalStartRing end, Userdata[" + this._ringUserdata + "], dataSource[" + i + "], DurationMS[" + this._ringPlayer.getDuration() + "], ret[" + bool1 + "], seq[" + l + "]");
            }
            return 0;
          }
        }
        catch (Exception paramHashMap)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "InternalStartRing Exception, seq[" + l + "]", paramHashMap);
          }
          return -1;
        }
        bool1 = false;
      }
    }
    
    int InternalStopRing(HashMap<String, Object> paramHashMap)
    {
      int i = 0;
      long l = TraeAudioManager.getSeq(paramHashMap);
      QLog.w("TraeAudioManager", 1, "InternalStopRing begin, _activeMode[" + TraeAudioManager.this._activeMode + "], _preRingMode[" + this._preRingMode + "], seq[" + l + "]");
      if ((TraeAudioManager.this._am == null) || (this._ringPlayer == null))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
        }
        i = -1;
      }
      do
      {
        return i;
        this._ringPlayer.stopRing(l);
        if ((!this._ringPlayer.hasCall()) && (TraeAudioManager.this._activeMode == 2))
        {
          abandonAudioFocus();
          TraeAudioManager.this._activeMode = 0;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "InternalStopRing end, _activeMode[" + TraeAudioManager.this._activeMode + "], _preRingMode[" + this._preRingMode + "], seq[" + l + "]");
      return 0;
    }
    
    int InternalVoicecallPostprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalVoicecallPostprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode != 1)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " not ACTIVE_VOICECALL!!");
        }
        localIntent = new Intent();
        TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 3);
        return -1;
      }
      TraeAudioManager.this._activeMode = 0;
      abandonAudioFocus();
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    int InternalVoicecallPreprocess(HashMap<String, Object> paramHashMap)
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (paramHashMap == null) {
        return -1;
      }
      if (TraeAudioManager.this._am == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " InternalVoicecallPreprocess am==null!!");
        }
        return -1;
      }
      if (TraeAudioManager.this._activeMode == 1)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 2);
        return -1;
      }
      this._voiceCallSessionID = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
      this._voiceCallOperation = ((String)paramHashMap.get("PARAM_OPERATION"));
      TraeAudioManager.this._activeMode = 1;
      TraeAudioManager.this.sessionConnectedDev = "DEVICE_NONE";
      TraeAudioManager.this._prevMode = TraeAudioManager.this._am.getMode();
      Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
      if (localObject == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " params.get(PARAM_MODEPOLICY)==null!!");
        }
        TraeAudioManager.this._modePolicy = -1;
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "  _modePolicy:" + TraeAudioManager.this._modePolicy);
        }
        localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
        if (localObject != null) {
          break label376;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " params.get(PARAM_STREAMTYPE)==null!!");
        }
        TraeAudioManager.this._streamType = 0;
        label272:
        if ((!TraeAudioManager.isCloseSystemAPM(TraeAudioManager.this._modePolicy)) || (TraeAudioManager.this._activeMode == 2) || (TraeAudioManager.this._deviceConfigManager == null)) {
          break label406;
        }
        if (!TraeAudioManager.this._deviceConfigManager.getConnectedDevice().equals("DEVICE_SPEAKERPHONE")) {
          break label390;
        }
        TraeAudioManager.this.InternalSetMode(0);
        requestAudioFocus(3);
      }
      for (;;)
      {
        localObject = new Intent();
        TraeAudioManager.this.sendResBroadcast((Intent)localObject, paramHashMap, 0);
        AudioDeviceInterface.LogTraceExit();
        return 0;
        TraeAudioManager.this._modePolicy = ((Integer)localObject).intValue();
        break;
        label376:
        TraeAudioManager.this._streamType = ((Integer)localObject).intValue();
        break label272;
        label390:
        TraeAudioManager.this.InternalSetMode(3);
        requestAudioFocus(0);
        continue;
        label406:
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.getCallAudioMode(TraeAudioManager.this._modePolicy));
        requestAudioFocus(TraeAudioManager.this._streamType);
      }
    }
    
    void _init()
    {
      AudioDeviceInterface.LogTraceEntry("");
      try
      {
        TraeAudioManager.this._audioSessionHost = new TraeAudioSessionHost();
        TraeAudioManager.this._deviceConfigManager = new TraeAudioManager.DeviceConfigManager(TraeAudioManager.this);
        TraeAudioManager._gHostProcessId = Process.myPid();
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        AudioDeviceInterface.LogTraceExit();
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, "======7");
          }
        }
      }
    }
    
    void _post_stopService()
    {
      try
      {
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          IntentFilter localIntentFilter = new IntentFilter();
          localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
          TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    void _prev_startService()
    {
      try
      {
        TraeAudioManager.this._am = ((AudioManager)TraeAudioManager.this._context.getSystemService("audio"));
        if (TraeAudioManager.this._bluetoothCheck == null) {
          TraeAudioManager.this._bluetoothCheck = TraeAudioManager.this.CreateBluetoothCheck(TraeAudioManager.this._context, TraeAudioManager.this._deviceConfigManager);
        }
        TraeAudioManager.this._context.unregisterReceiver(this._parent);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
        localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
        TraeAudioManager.this._bluetoothCheck.addAction(localIntentFilter);
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        TraeAudioManager.this._context.registerReceiver(this._parent, localIntentFilter);
        return;
      }
      catch (Exception localException) {}
    }
    
    void _uninit(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "_uninit begin, seq[" + paramLong + "]");
      }
      try
      {
        stopService(paramLong);
        if (TraeAudioManager.this._bluetoothCheck != null) {
          TraeAudioManager.this._bluetoothCheck.release();
        }
        TraeAudioManager.this._bluetoothCheck = null;
        if (TraeAudioManager.this._context != null)
        {
          TraeAudioManager.this._context.unregisterReceiver(this._parent);
          TraeAudioManager.this._context = null;
        }
        if (TraeAudioManager.this._deviceConfigManager != null) {
          TraeAudioManager.this._deviceConfigManager.clearConfig();
        }
        TraeAudioManager.this._deviceConfigManager = null;
      }
      catch (Exception localException)
      {
        label131:
        break label131;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "_uninit end, seq[" + paramLong + "]");
      }
    }
    
    @TargetApi(8)
    void abandonAudioFocus()
    {
      if (Build.VERSION.SDK_INT <= 8) {}
      while ((TraeAudioManager.this._am == null) || (this.mAudioFocusChangeListener == null)) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "-------abandonAudioFocus _focusSteamType:" + this._focusSteamType);
      }
      TraeAudioManager.this._am.abandonAudioFocus(this.mAudioFocusChangeListener);
      this.mAudioFocusChangeListener = null;
    }
    
    public void doHandleMessage(Message paramMessage)
    {
      Object localObject1 = null;
      try
      {
        localObject2 = (HashMap)paramMessage.obj;
        localObject1 = localObject2;
      }
      catch (Exception localException)
      {
        Object localObject2;
        label16:
        long l;
        break label16;
      }
      l = TraeAudioManager.getSeq((HashMap)localObject1);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "doHandleMessage, msg[" + paramMessage.what + "], _enabled[" + this._enabled + "], seq[" + l + "]");
      }
      if (paramMessage.what == 32772) {
        startService((HashMap)localObject1);
      }
      label328:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!this._enabled)
              {
                paramMessage = new Intent();
                TraeAudioManager.this.sendResBroadcast(paramMessage, (HashMap)localObject1, 1);
                return;
              }
              switch (paramMessage.what)
              {
              default: 
                return;
              case 32773: 
                stopService(l);
                return;
              case 32774: 
                InternalSessionGetDeviceList((HashMap)localObject1);
                return;
              case 32777: 
                TraeAudioManager.this.InternalSessionIsDeviceChangabled((HashMap)localObject1);
                return;
              case 32778: 
                TraeAudioManager.this.InternalSessionGetConnectedDevice((HashMap)localObject1);
                return;
              case 32779: 
                TraeAudioManager.this.InternalSessionGetConnectingDevice((HashMap)localObject1);
                return;
              case 32780: 
                InternalVoicecallPreprocess((HashMap)localObject1);
                return;
              case 32781: 
                InternalVoicecallPostprocess((HashMap)localObject1);
                return;
              case 32788: 
                paramMessage = (Integer)((HashMap)localObject1).get("PARAM_STREAMTYPE");
                if (paramMessage != null) {
                  break label328;
                }
              }
            } while (!QLog.isColorLevel());
            QLog.e("TraeAudioManager", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
            return;
            TraeAudioManager.this._streamType = paramMessage.intValue();
            InternalNotifyStreamTypeUpdate(paramMessage.intValue());
            return;
            InternalStartRing((HashMap)localObject1);
            return;
            InternalStopRing((HashMap)localObject1);
            return;
            abandonAudioFocus();
            return;
            requestAudioFocus(TraeAudioManager.this._streamType);
            return;
            InternalGetStreamType((HashMap)localObject1);
            return;
            TraeAudioManager.this.InternalNotifyDeviceListUpdate();
            return;
            TraeAudioManager.this.InternalSessionConnectDevice((HashMap)localObject1);
            return;
            TraeAudioManager.this.InternalSessionEarAction((HashMap)localObject1);
            return;
            localObject2 = TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice();
            String str = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
            localObject1 = (String)((HashMap)localObject1).get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
            if (QLog.isColorLevel()) {
              QLog.w("TraeAudioManager", 2, "MESSAGE_AUTO_DEVICELIST_UPDATE connectedDev = " + str + ", highestDev = " + (String)localObject2 + ", connectDeviceNameWhenServiceOn = " + (String)localObject1);
            }
            paramMessage = (Message)localObject2;
            if (localObject1 != null)
            {
              paramMessage = (Message)localObject2;
              if (TraeAudioManager.this._deviceConfigManager.getVisible((String)localObject1)) {
                paramMessage = (Message)localObject1;
              }
            }
            if (!paramMessage.equals(str))
            {
              TraeAudioManager.this.InternalConnectDevice(paramMessage, null);
              return;
            }
            TraeAudioManager.this.InternalNotifyDeviceListUpdate();
            return;
            paramMessage = (String)((HashMap)localObject1).get("PARAM_DEVICE");
          } while (TraeAudioManager.this.InternalConnectDevice(paramMessage, null) == 0);
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, " plugin dev:" + paramMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
          }
          TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null);
          return;
        } while (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.sessionConnectedDev, null) == 0);
        paramMessage = (String)((HashMap)localObject1).get("PARAM_DEVICE");
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, " plugout dev:" + paramMessage + " sessionConnectedDev:" + TraeAudioManager.this.sessionConnectedDev + " connected fail,auto switch!");
        }
        TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice(), null);
        return;
        paramMessage = (String)((HashMap)localObject1).get("PARAM_DEVICE");
        if (TraeAudioManager.this.BTDisConnectSessionConnectedDev.equals("DEVICE_BLUETOOTHHEADSET"))
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + TraeAudioManager.this.BTDisConnectSessionConnectedDev + " MESSAGE_BLUETOOTH_SCO_DISCONNECTED");
          }
          TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null);
          return;
        }
      } while (TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this.BTDisConnectSessionConnectedDev, null) == 0);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " plugout dev:" + paramMessage + " BTDisConnectSessionConnectedDev:" + TraeAudioManager.this.BTDisConnectSessionConnectedDev + " connected fail,auto switch!");
      }
      TraeAudioManager.this.InternalConnectDevice(TraeAudioManager.this._deviceConfigManager.getAvailabledHighestPriorityDevice("DEVICE_BLUETOOTHHEADSET"), null);
    }
    
    int interruptRing(long paramLong)
    {
      int i = 0;
      Object localObject;
      boolean bool;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("interruptRing begin, _activeMode[").append(TraeAudioManager.this._activeMode).append("], _preRingMode[").append(this._preRingMode).append("], _am[");
        if (TraeAudioManager.this._am != null)
        {
          bool = true;
          QLog.w("TraeAudioManager", 1, bool + "], seq[" + paramLong + "]");
        }
      }
      else
      {
        if (TraeAudioManager.this._am != null) {
          break label117;
        }
        i = -1;
      }
      label117:
      do
      {
        return i;
        bool = false;
        break;
        if (TraeAudioManager.this._activeMode != 2) {
          return -1;
        }
        this._ringPlayer.stopRing(paramLong);
        abandonAudioFocus();
        TraeAudioManager.this._activeMode = 0;
        localObject = new HashMap();
        ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
        ((HashMap)localObject).put("PARAM_OPERATION", this._ringOperation);
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
        localIntent.putExtra("PARAM_seq", paramLong);
        TraeAudioManager.this.sendResBroadcast(localIntent, (HashMap)localObject, 4);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "interruptRing end, _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + paramLong + "]");
      return 0;
    }
    
    int interruptVoicecallPostprocess()
    {
      AudioDeviceInterface.LogTraceEntry(" activeMode:" + TraeAudioManager.this._activeMode);
      if (TraeAudioManager.this._am == null) {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, " am==null!!");
        }
      }
      do
      {
        return -1;
        if (TraeAudioManager.this._activeMode == 1) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " not ACTIVE_RING!!");
      return -1;
      TraeAudioManager.this._activeMode = 0;
      if (TraeAudioManager.this._prevMode != -1) {
        TraeAudioManager.this.InternalSetMode(TraeAudioManager.this._prevMode);
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._voiceCallSessionID));
      localHashMap.put("PARAM_OPERATION", this._voiceCallOperation);
      Intent localIntent = new Intent();
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 6);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    
    void notifyRingCompletion()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_SESSIONID", Long.valueOf(this._ringSessionID));
      localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this._ringUserdata);
      TraeAudioManager.this.sendResBroadcast(localIntent, localHashMap, 0);
    }
    
    int notifyServiceState(boolean paramBoolean)
    {
      if (TraeAudioManager.this._context == null) {
        return -1;
      }
      Intent localIntent = new Intent();
      localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
      localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
      localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
      TraeAudioManager.this._context.sendBroadcast(localIntent);
      return 0;
    }
    
    public void quit()
    {
      AudioDeviceInterface.LogTraceEntry("");
      if (this.mMsgHandler == null) {
        return;
      }
      long l = SystemClock.elapsedRealtime();
      this.mMsgHandler.getLooper().quit();
      synchronized (this._started)
      {
        int i = this._started[0];
        if (i != 1) {}
      }
      try
      {
        this._started.wait(10000L);
        label58:
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
        }
        this.mMsgHandler = null;
        AudioDeviceInterface.LogTraceExit();
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label58;
      }
    }
    
    @TargetApi(8)
    void requestAudioFocus(int paramInt)
    {
      if (Build.VERSION.SDK_INT <= 8) {}
      do
      {
        do
        {
          do
          {
            return;
          } while (this.mAudioFocusChangeListener != null);
          this.mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener()
          {
            @TargetApi(8)
            public void onAudioFocusChange(int paramAnonymousInt)
            {
              if (QLog.isColorLevel()) {
                QLog.w("TraeAudioManager", 2, "focusChange:" + paramAnonymousInt + " _focusSteamType:" + TraeAudioManager.TraeAudioManagerLooper.this._focusSteamType + " currMode:" + TraeAudioManager.this._am.getMode() + " _activeMode:" + TraeAudioManager.this._activeMode);
              }
              if (paramAnonymousInt == -1) {}
              while ((paramAnonymousInt == -2) || (paramAnonymousInt == -3) || (paramAnonymousInt != 1)) {
                return;
              }
            }
          };
        } while (TraeAudioManager.this._am == null);
        int i = TraeAudioManager.this._am.requestAudioFocus(this.mAudioFocusChangeListener, paramInt, 2);
        if ((i != 1) && (QLog.isColorLevel())) {
          QLog.e("TraeAudioManager", 2, "request audio focus fail. " + i + " mode:" + TraeAudioManager.this._am.getMode());
        }
        this._focusSteamType = paramInt;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "-------requestAudioFocus _focusSteamType:" + this._focusSteamType);
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run begin, seq[" + 0L + "]");
      }
      Looper.prepare();
      this.mMsgHandler = new Handler()
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          TraeAudioManager.TraeAudioManagerLooper.this.doHandleMessage(paramAnonymousMessage);
        }
      };
      _init();
      synchronized (this._started)
      {
        this._started[0] = true;
        this._started.notify();
        Looper.loop();
        _uninit(0L);
      }
      synchronized (this._started)
      {
        this._started[0] = false;
        this._started.notify();
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run end, seq[" + 0L + "]");
        }
        return;
        localObject1 = finally;
        throw localObject1;
      }
    }
    
    public int sendMessage(int paramInt, HashMap<String, Object> paramHashMap)
    {
      if (this.mMsgHandler == null)
      {
        StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
        if (this._enabled) {}
        for (paramHashMap = "Y";; paramHashMap = "N")
        {
          AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + TraeAudioManager.this._activeMode + " msg:" + paramInt);
          return -1;
        }
      }
      paramHashMap = Message.obtain(this.mMsgHandler, paramInt, paramHashMap);
      if (this.mMsgHandler.sendMessage(paramHashMap)) {}
      for (paramInt = 0;; paramInt = -1) {
        return paramInt;
      }
    }
    
    void startService(HashMap<String, Object> paramHashMap)
    {
      final long l = TraeAudioManager.getSeq(paramHashMap);
      String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "startService begin, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + l + "], cfg[" + str + "]");
      }
      if ((str == null) || (TraeAudioManager.this._context == null)) {}
      do
      {
        do
        {
          return;
        } while ((str.length() <= 0) || ((this._enabled) && (this._lastCfg.equals(str))) || (TraeAudioManager.this._activeMode != 0));
        if (this._enabled) {
          stopService(l);
        }
        _prev_startService();
        TraeAudioManager.this._deviceConfigManager.clearConfig();
        TraeAudioManager.this._deviceConfigManager.init(str);
        this._lastCfg = str;
        if (TraeAudioManager.this._am != null) {
          this._preServiceMode = TraeAudioManager.this._am.getMode();
        }
        this._enabled = true;
        if (this._ringPlayer == null) {
          this._ringPlayer = new TraeMediaPlayer(TraeAudioManager.this._context, new TraeMediaPlayer.OnCompletionListener()
          {
            public void onCompletion()
            {
              if (QLog.isColorLevel()) {
                QLog.w("TraeAudioManager", 2, "_ringPlayer onCompletion _activeMode:" + TraeAudioManager.this._activeMode + " _preRingMode:" + TraeAudioManager.TraeAudioManagerLooper.this._preRingMode);
              }
              TraeAudioManager.stopRing(l, null, -1L, true);
              TraeAudioManager.TraeAudioManagerLooper.this.notifyRingCompletion();
            }
          });
        }
        paramHashMap = (String)paramHashMap.get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
        TraeAudioManager.this.updateDeviceStatus(paramHashMap);
        notifyServiceState(this._enabled);
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 1, "startService end, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], seq[" + l + "]");
    }
    
    void stopService(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "stopService, _enabled[" + this._enabled + "], _activeMode[" + TraeAudioManager.this._activeMode + "], _switchThread[" + TraeAudioManager.this._switchThread + "], seq[" + paramLong + "]");
      }
      if (!this._enabled) {
        return;
      }
      if (TraeAudioManager.this._activeMode == 1) {
        interruptVoicecallPostprocess();
      }
      for (;;)
      {
        if (TraeAudioManager.this._switchThread != null)
        {
          TraeAudioManager.this._switchThread.quit(paramLong);
          TraeAudioManager.this._switchThread = null;
        }
        if (this._ringPlayer != null) {
          this._ringPlayer.stopRing(paramLong);
        }
        this._ringPlayer = null;
        this._enabled = false;
        notifyServiceState(this._enabled);
        if ((TraeAudioManager.this._am != null) && (TraeAudioManager.this._context != null)) {}
        try
        {
          TraeAudioManager.this.InternalSetMode(0);
          QLog.w("TraeAudioManager", 2, "NeedForceVolumeType: -1");
          TraeAudioManager.forceVolumeControlStream(TraeAudioManager.this._am, -1);
          label218:
          _post_stopService();
          AudioDeviceInterface.LogTraceExit();
          return;
          if (TraeAudioManager.this._activeMode != 2) {
            continue;
          }
          interruptRing(paramLong);
        }
        catch (Exception localException)
        {
          break label218;
        }
      }
    }
  }
  
  class bluetoothHeadsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    bluetoothHeadsetSwitchThread()
    {
      super();
    }
    
    public void _quit()
    {
      if (TraeAudioManager.this._am == null) {
        return;
      }
      _stopBluetoothSco();
    }
    
    public void _run()
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, "bluetoothHeadsetSwitchThread start connect,sBluetoothDelayTime: " + TraeAudioManager.sBluetoothDelayTime);
        }
        Thread.sleep(TraeAudioManager.sBluetoothDelayTime);
      }
      catch (InterruptedException localInterruptedException2)
      {
        label275:
        for (;;)
        {
          int i;
        }
      }
      if ((0 == 0) && (this._running == true)) {
        _startBluetoothSco();
      }
      i = 0;
      for (;;)
      {
        int j;
        StringBuilder localStringBuilder;
        if (this._running == true)
        {
          j = i + 1;
          if ((i >= 10) || (0 != 0)) {
            break;
          }
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("bluetoothHeadsetSwitchThread ");
            localStringBuilder.append("i:");
            localStringBuilder.append(j);
            localStringBuilder.append(" sco:");
            if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
              break label275;
            }
          }
        }
        for (String str = "Y";; str = "N")
        {
          localStringBuilder.append(str);
          localStringBuilder.append(" :");
          localStringBuilder.append(TraeAudioManager.this._deviceConfigManager.getBluetoothName());
          localStringBuilder.append("\n");
          QLog.w(this.TAG, 2, localStringBuilder.toString());
          if (!TraeAudioManager.this._am.isBluetoothScoOn()) {
            break;
          }
          updateStatus();
          if (!TraeAudioManager.this._am.isBluetoothScoOn())
          {
            if ((QLog.isColorLevel()) && (0 == 0)) {
              QLog.e(this.TAG, 2, "bluetoothHeadsetSwitchThread sco fail,remove btheadset");
            }
            TraeAudioManager.this._deviceConfigManager.setVisible(getDeviceName(), false);
            processDeviceConnectRes(10);
            TraeAudioManager.this.checkAutoDeviceListUpdate();
          }
          return;
        }
        try
        {
          Thread.sleep(1000L);
          i = j;
        }
        catch (InterruptedException localInterruptedException1)
        {
          i = j;
        }
      }
    }
    
    void _startBluetoothSco()
    {
      try
      {
        TraeAudioManager.this._am.setBluetoothScoOn(true);
        if (Build.VERSION.SDK_INT > 8) {
          TraeAudioManager.this._am.startBluetoothSco();
        }
        return;
      }
      catch (Exception localException) {}
    }
    
    void _stopBluetoothSco()
    {
      if (Build.VERSION.SDK_INT > 8) {
        TraeAudioManager.this._am.stopBluetoothSco();
      }
      TraeAudioManager.this._am.setBluetoothScoOn(false);
    }
    
    public String getDeviceName()
    {
      return "DEVICE_BLUETOOTHHEADSET";
    }
  }
  
  class earphoneSwitchThread
    extends TraeAudioManager.switchThread
  {
    earphoneSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      int i = 0;
      TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, false);
      updateStatus();
      for (;;)
      {
        if (this._running == true)
        {
          if (TraeAudioManager.this.getSysSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              label77:
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            break label77;
          }
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_EARPHONE";
    }
  }
  
  class headsetSwitchThread
    extends TraeAudioManager.switchThread
  {
    headsetSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      int i = 0;
      TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, false);
      TraeAudioManager.this._am.setWiredHeadsetOn(true);
      updateStatus();
      for (;;)
      {
        if (this._running == true)
        {
          if (TraeAudioManager.this.getSysSpeakerphoneOn()) {
            TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, false);
          }
          long l;
          if (i < 5) {
            l = 1000L;
          }
          try
          {
            for (;;)
            {
              Thread.sleep(l);
              i += 1;
              break;
              l = 4000L;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            for (;;)
            {
              AVLog.e(this.TAG, localInterruptedException.getMessage());
            }
          }
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_WIREDHEADSET";
    }
  }
  
  class speakerSwitchThread
    extends TraeAudioManager.switchThread
  {
    speakerSwitchThread()
    {
      super();
    }
    
    public void _quit() {}
    
    public void _run()
    {
      int i = 0;
      TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, true);
      updateStatus();
      for (;;)
      {
        if (this._running)
        {
          if (TraeAudioManager.this.getSysSpeakerphoneOn() == true) {
            break label129;
          }
          if ((this.mQAVProcess) && (i > 4))
          {
            SessionInfo localSessionInfo = QavSDK.getInstance().getSessionMgr().getMainSession();
            if (!localSessionInfo.mSpeakerOn) {
              QLog.w(this.TAG, 1, "_run, 不需要打开扬声器, sessionInfo[" + localSessionInfo + "]");
            }
          }
        }
        else
        {
          return;
        }
        TraeAudioManager.this.InternalSetSpeaker(this.mSeq, TraeAudioManager.this._context, true);
        label129:
        long l;
        if (i < 5) {
          l = 1000L;
        }
        try
        {
          for (;;)
          {
            Thread.sleep(l);
            label142:
            i += 1;
            break;
            l = 4000L;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          break label142;
        }
      }
    }
    
    public String getDeviceName()
    {
      return "DEVICE_SPEAKERPHONE";
    }
  }
  
  abstract class switchThread
    extends Thread
  {
    final String TAG = getClass().getSimpleName();
    boolean[] _exited = { false };
    HashMap<String, Object> _params = null;
    boolean _running = true;
    boolean mQAVProcess = false;
    long mSeq = 0L;
    
    switchThread()
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 2, "switchThread");
      }
    }
    
    public abstract void _quit();
    
    public abstract void _run();
    
    public abstract String getDeviceName();
    
    void processDeviceConnectRes(int paramInt)
    {
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      AudioDeviceInterface.LogTraceEntry(getDeviceName() + " err:" + paramInt + " ConnectedDevice: " + TraeAudioManager.this._deviceConfigManager.getConnectedDevice());
      if (this._params == null) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      do
      {
        return;
        TraeAudioManager.this.sessionConnectedDev = TraeAudioManager.this._deviceConfigManager.getConnectedDevice();
        localObject = (Long)this._params.get("PARAM_SESSIONID");
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 2, " sessonID:" + localObject + "sessionConnectedDev: " + TraeAudioManager.this.sessionConnectedDev);
        }
        if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L)) {
          break;
        }
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      } while (!QLog.isColorLevel());
      QLog.w(this.TAG, 2, "processDeviceConnectRes sid null,don't send res");
      return;
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)this._params.get("PARAM_DEVICE"));
      if (TraeAudioManager.this.sendResBroadcast((Intent)localObject, this._params, paramInt) == 0) {
        TraeAudioManager.this.InternalNotifyDeviceListUpdate();
      }
      AudioDeviceInterface.LogTraceExit();
    }
    
    public void quit(long paramLong)
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "quit begin, _running[" + this._running + "], seq[" + this.mSeq + "|" + paramLong + "]");
      }
      this._running = false;
      interrupt();
      _quit();
      synchronized (this._exited)
      {
        int i = this._exited[0];
        if (i != 0) {}
      }
      try
      {
        this._exited.wait();
        label102:
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 1, "quit end, seq[" + this.mSeq + "->" + paramLong + "]");
        }
        return;
        localObject = finally;
        throw localObject;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label102;
      }
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.w(this.TAG, 1, "run begin, seq[" + this.mSeq + "], _running[" + this._running + "]");
      }
      TraeAudioManager.this.InternalNotifyDeviceChangableUpdate();
      _run();
      synchronized (this._exited)
      {
        this._exited[0] = true;
        this._exited.notify();
        if (QLog.isColorLevel()) {
          QLog.w(this.TAG, 1, "run end, seq[" + this.mSeq + "]");
        }
        return;
      }
    }
    
    public void setDeviceConnectParam(HashMap<String, Object> paramHashMap)
    {
      this._params = paramHashMap;
    }
    
    public void start(long paramLong)
    {
      try
      {
        this.mSeq = paramLong;
        super.start();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public String toString()
    {
      return this.TAG + "_" + this.mSeq;
    }
    
    void updateStatus()
    {
      TraeAudioManager.this._deviceConfigManager.setConnected(getDeviceName());
      processDeviceConnectRes(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */