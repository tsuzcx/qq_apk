package android.support.v4.media;

import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.os.Messenger;
import android.support.v4.f.a;
import android.support.v4.media.session.MediaSessionCompat.Token;

final class MediaBrowserCompat$h
  implements MediaBrowserCompat.d, MediaBrowserCompat.i
{
  final Bundle AK;
  final MediaBrowserCompat.a AL = new MediaBrowserCompat.a(this);
  private final a<String, MediaBrowserCompat.k> AM = new a();
  MediaBrowserCompat.j AO;
  Messenger AP;
  private MediaSessionCompat.Token AQ;
  final ComponentName AR;
  final MediaBrowserCompat.b AS;
  MediaBrowserCompat.h.a AT;
  private String AU;
  final Context mContext;
  private Bundle mExtras;
  int mState = 1;
  
  public MediaBrowserCompat$h(Context paramContext, ComponentName paramComponentName, MediaBrowserCompat.b paramb)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("context must not be null");
    }
    if (paramComponentName == null) {
      throw new IllegalArgumentException("service component must not be null");
    }
    if (paramb == null) {
      throw new IllegalArgumentException("connection callback must not be null");
    }
    this.mContext = paramContext;
    this.AR = paramComponentName;
    this.AS = paramb;
    this.AK = null;
  }
  
  private boolean a(Messenger paramMessenger, String paramString)
  {
    boolean bool = true;
    if ((this.AP != paramMessenger) || (this.mState == 0) || (this.mState == 1))
    {
      if ((this.mState != 0) && (this.mState != 1)) {
        new StringBuilder().append(paramString).append(" for ").append(this.AR).append(" with mCallbacksMessenger=").append(this.AP).append(" this=").append(this);
      }
      bool = false;
    }
    return bool;
  }
  
  private static String aj(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "UNKNOWN/" + paramInt;
    case 0: 
      return "CONNECT_STATE_DISCONNECTING";
    case 1: 
      return "CONNECT_STATE_DISCONNECTED";
    case 2: 
      return "CONNECT_STATE_CONNECTING";
    case 3: 
      return "CONNECT_STATE_CONNECTED";
    }
    return "CONNECT_STATE_SUSPENDED";
  }
  
  public final void a(Messenger paramMessenger, String paramString, Bundle paramBundle)
  {
    if (!a(paramMessenger, "onLoadChildren")) {
      return;
    }
    if (MediaBrowserCompat.DEBUG) {
      new StringBuilder("onLoadChildren for ").append(this.AR).append(" id=").append(paramString);
    }
    paramMessenger = (MediaBrowserCompat.k)this.AM.get(paramString);
    if (paramMessenger == null)
    {
      boolean bool = MediaBrowserCompat.DEBUG;
      return;
    }
    paramMessenger.c(this.mContext, paramBundle);
  }
  
  /* Error */
  public final void a(Messenger paramMessenger, String paramString, MediaSessionCompat.Token paramToken, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: ldc 154
    //   4: invokespecial 125	android/support/v4/media/MediaBrowserCompat$h:a	(Landroid/os/Messenger;Ljava/lang/String;)Z
    //   7: ifne +4 -> 11
    //   10: return
    //   11: aload_0
    //   12: getfield 58	android/support/v4/media/MediaBrowserCompat$h:mState	I
    //   15: iconst_2
    //   16: if_icmpeq +29 -> 45
    //   19: new 84	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 156
    //   25: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 58	android/support/v4/media/MediaBrowserCompat$h:mState	I
    //   32: invokestatic 158	android/support/v4/media/MediaBrowserCompat$h:aj	(I)Ljava/lang/String;
    //   35: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 160
    //   40: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: return
    //   45: aload_0
    //   46: aload_2
    //   47: putfield 162	android/support/v4/media/MediaBrowserCompat$h:AU	Ljava/lang/String;
    //   50: aload_0
    //   51: aload_3
    //   52: putfield 164	android/support/v4/media/MediaBrowserCompat$h:AQ	Landroid/support/v4/media/session/MediaSessionCompat$Token;
    //   55: aload_0
    //   56: aload 4
    //   58: putfield 166	android/support/v4/media/MediaBrowserCompat$h:mExtras	Landroid/os/Bundle;
    //   61: aload_0
    //   62: iconst_3
    //   63: putfield 58	android/support/v4/media/MediaBrowserCompat$h:mState	I
    //   66: getstatic 129	android/support/v4/media/MediaBrowserCompat:DEBUG	Z
    //   69: ifeq +7 -> 76
    //   72: aload_0
    //   73: invokevirtual 169	android/support/v4/media/MediaBrowserCompat$h:dump	()V
    //   76: aload_0
    //   77: getfield 75	android/support/v4/media/MediaBrowserCompat$h:AS	Landroid/support/v4/media/MediaBrowserCompat$b;
    //   80: invokevirtual 174	android/support/v4/media/MediaBrowserCompat$b:onConnected	()V
    //   83: aload_0
    //   84: getfield 56	android/support/v4/media/MediaBrowserCompat$h:AM	Landroid/support/v4/f/a;
    //   87: invokevirtual 178	android/support/v4/f/a:entrySet	()Ljava/util/Set;
    //   90: invokeinterface 184 1 0
    //   95: astore_1
    //   96: aload_1
    //   97: invokeinterface 190 1 0
    //   102: ifeq -92 -> 10
    //   105: aload_1
    //   106: invokeinterface 194 1 0
    //   111: checkcast 196	java/util/Map$Entry
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 199 1 0
    //   121: checkcast 201	java/lang/String
    //   124: astore_2
    //   125: aload_3
    //   126: invokeinterface 204 1 0
    //   131: checkcast 139	android/support/v4/media/MediaBrowserCompat$k
    //   134: astore 4
    //   136: aload 4
    //   138: getfield 208	android/support/v4/media/MediaBrowserCompat$k:eU	Ljava/util/List;
    //   141: astore_3
    //   142: aload 4
    //   144: getfield 211	android/support/v4/media/MediaBrowserCompat$k:Ba	Ljava/util/List;
    //   147: astore 4
    //   149: iconst_0
    //   150: istore 5
    //   152: iload 5
    //   154: aload_3
    //   155: invokeinterface 217 1 0
    //   160: if_icmpge -64 -> 96
    //   163: aload_0
    //   164: getfield 219	android/support/v4/media/MediaBrowserCompat$h:AO	Landroid/support/v4/media/MediaBrowserCompat$j;
    //   167: astore 7
    //   169: aload_3
    //   170: iload 5
    //   172: invokeinterface 222 2 0
    //   177: checkcast 224	android/support/v4/media/MediaBrowserCompat$l
    //   180: getfield 228	android/support/v4/media/MediaBrowserCompat$l:tZ	Landroid/os/IBinder;
    //   183: astore 11
    //   185: aload 4
    //   187: iload 5
    //   189: invokeinterface 222 2 0
    //   194: checkcast 230	android/os/Bundle
    //   197: astore 8
    //   199: aload_0
    //   200: getfield 82	android/support/v4/media/MediaBrowserCompat$h:AP	Landroid/os/Messenger;
    //   203: astore 9
    //   205: new 230	android/os/Bundle
    //   208: dup
    //   209: invokespecial 231	android/os/Bundle:<init>	()V
    //   212: astore 10
    //   214: aload 10
    //   216: ldc 233
    //   218: aload_2
    //   219: invokevirtual 237	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   222: getstatic 242	android/os/Build$VERSION:SDK_INT	I
    //   225: bipush 18
    //   227: if_icmplt +40 -> 267
    //   230: aload 10
    //   232: ldc 244
    //   234: aload 11
    //   236: invokevirtual 248	android/os/Bundle:putBinder	(Ljava/lang/String;Landroid/os/IBinder;)V
    //   239: aload 10
    //   241: ldc 250
    //   243: aload 8
    //   245: invokevirtual 254	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   248: aload 7
    //   250: iconst_3
    //   251: aload 10
    //   253: aload 9
    //   255: invokevirtual 259	android/support/v4/media/MediaBrowserCompat$j:a	(ILandroid/os/Bundle;Landroid/os/Messenger;)V
    //   258: iload 5
    //   260: iconst_1
    //   261: iadd
    //   262: istore 5
    //   264: goto -112 -> 152
    //   267: getstatic 264	android/support/v4/app/e$a:uM	Z
    //   270: istore 6
    //   272: iload 6
    //   274: ifne +43 -> 317
    //   277: ldc 230
    //   279: ldc_w 266
    //   282: iconst_2
    //   283: anewarray 268	java/lang/Class
    //   286: dup
    //   287: iconst_0
    //   288: ldc 201
    //   290: aastore
    //   291: dup
    //   292: iconst_1
    //   293: ldc_w 270
    //   296: aastore
    //   297: invokevirtual 274	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   300: astore 12
    //   302: aload 12
    //   304: putstatic 278	android/support/v4/app/e$a:uL	Ljava/lang/reflect/Method;
    //   307: aload 12
    //   309: iconst_1
    //   310: invokevirtual 284	java/lang/reflect/Method:setAccessible	(Z)V
    //   313: iconst_1
    //   314: putstatic 264	android/support/v4/app/e$a:uM	Z
    //   317: getstatic 278	android/support/v4/app/e$a:uL	Ljava/lang/reflect/Method;
    //   320: astore 12
    //   322: aload 12
    //   324: ifnull -85 -> 239
    //   327: getstatic 278	android/support/v4/app/e$a:uL	Ljava/lang/reflect/Method;
    //   330: aload 10
    //   332: iconst_2
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: ldc 244
    //   340: aastore
    //   341: dup
    //   342: iconst_1
    //   343: aload 11
    //   345: aastore
    //   346: invokevirtual 288	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   349: pop
    //   350: goto -111 -> 239
    //   353: astore 11
    //   355: aconst_null
    //   356: putstatic 278	android/support/v4/app/e$a:uL	Ljava/lang/reflect/Method;
    //   359: goto -120 -> 239
    //   362: astore_1
    //   363: return
    //   364: astore 11
    //   366: goto -11 -> 355
    //   369: astore 11
    //   371: goto -16 -> 355
    //   374: astore 12
    //   376: goto -63 -> 313
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	h
    //   0	379	1	paramMessenger	Messenger
    //   0	379	2	paramString	String
    //   0	379	3	paramToken	MediaSessionCompat.Token
    //   0	379	4	paramBundle	Bundle
    //   150	113	5	i	int
    //   270	3	6	bool	boolean
    //   167	82	7	localj	MediaBrowserCompat.j
    //   197	47	8	localBundle1	Bundle
    //   203	51	9	localMessenger	Messenger
    //   212	119	10	localBundle2	Bundle
    //   183	161	11	localIBinder	android.os.IBinder
    //   353	1	11	localInvocationTargetException	java.lang.reflect.InvocationTargetException
    //   364	1	11	localIllegalAccessException	java.lang.IllegalAccessException
    //   369	1	11	localIllegalArgumentException	IllegalArgumentException
    //   300	23	12	localMethod	java.lang.reflect.Method
    //   374	1	12	localNoSuchMethodException	java.lang.NoSuchMethodException
    // Exception table:
    //   from	to	target	type
    //   327	350	353	java/lang/reflect/InvocationTargetException
    //   83	96	362	android/os/RemoteException
    //   96	149	362	android/os/RemoteException
    //   152	239	362	android/os/RemoteException
    //   239	258	362	android/os/RemoteException
    //   267	272	362	android/os/RemoteException
    //   277	313	362	android/os/RemoteException
    //   313	317	362	android/os/RemoteException
    //   317	322	362	android/os/RemoteException
    //   327	350	362	android/os/RemoteException
    //   355	359	362	android/os/RemoteException
    //   327	350	364	java/lang/IllegalAccessException
    //   327	350	369	java/lang/IllegalArgumentException
    //   277	313	374	java/lang/NoSuchMethodException
  }
  
  public final void b(Messenger paramMessenger)
  {
    new StringBuilder("onConnectFailed for ").append(this.AR);
    if (!a(paramMessenger, "onConnectFailed")) {
      return;
    }
    if (this.mState != 2)
    {
      new StringBuilder("onConnect from service while mState=").append(aj(this.mState)).append("... ignoring");
      return;
    }
    cx();
    this.AS.onConnectionFailed();
  }
  
  public final void connect()
  {
    if ((this.mState != 0) && (this.mState != 1)) {
      throw new IllegalStateException("connect() called while neigther disconnecting nor disconnected (state=" + aj(this.mState) + ")");
    }
    this.mState = 2;
    this.AL.post(new MediaBrowserCompat.h.1(this));
  }
  
  public final MediaSessionCompat.Token cw()
  {
    if (this.mState == 3) {}
    for (int i = 1; i == 0; i = 0) {
      throw new IllegalStateException("getSessionToken() called while not connected(state=" + this.mState + ")");
    }
    return this.AQ;
  }
  
  final void cx()
  {
    if (this.AT != null) {
      this.mContext.unbindService(this.AT);
    }
    this.mState = 1;
    this.AT = null;
    this.AO = null;
    this.AP = null;
    this.AL.a(null);
    this.AU = null;
    this.AQ = null;
  }
  
  public final void disconnect()
  {
    this.mState = 0;
    this.AL.post(new MediaBrowserCompat.h.2(this));
  }
  
  final void dump()
  {
    new StringBuilder("  mServiceComponent=").append(this.AR);
    new StringBuilder("  mCallback=").append(this.AS);
    new StringBuilder("  mRootHints=").append(this.AK);
    new StringBuilder("  mState=").append(aj(this.mState));
    new StringBuilder("  mServiceConnection=").append(this.AT);
    new StringBuilder("  mServiceBinderWrapper=").append(this.AO);
    new StringBuilder("  mCallbacksMessenger=").append(this.AP);
    new StringBuilder("  mRootId=").append(this.AU);
    new StringBuilder("  mMediaSessionToken=").append(this.AQ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.v4.media.MediaBrowserCompat.h
 * JD-Core Version:    0.7.0.1
 */