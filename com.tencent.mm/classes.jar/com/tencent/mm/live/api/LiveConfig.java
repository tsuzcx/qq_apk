package com.tencent.mm.live.api;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;

public class LiveConfig
  implements Parcelable
{
  public static final Parcelable.Creator<LiveConfig> CREATOR;
  private static boolean mII;
  public static int mIp;
  public static int mIq;
  public static int mIr;
  public static int mIs;
  public static int mIt;
  public static int mIu;
  public static int mIv;
  public static int mIw;
  public static int mIx;
  public String desc;
  public int fromScene;
  public String hUQ;
  public long liveId;
  public String mIA;
  public HashMap mIB;
  public String mIC;
  public String mIE;
  public int mIF;
  private String mIG;
  public long mIH;
  public int mIJ;
  public String mIK;
  private String mIL;
  private String mIM;
  private String mIN;
  private long mIO;
  private long mIP;
  public String mIQ;
  public boolean mIR;
  public String mIS;
  public int mIT;
  public String mIU;
  public long mIV;
  public byte[] mIW;
  public int mIX;
  public int mIY;
  public int mIZ;
  public int mIy;
  public String mIz;
  public int mJa;
  public int mJb;
  public String nonceId;
  public int scene;
  public String sessionBuffer;
  public String thumbUrl;
  
  static
  {
    AppMethodBeat.i(246198);
    mIp = 0;
    mIq = 1;
    mIr = 2;
    mIs = 0;
    mIt = 1;
    mIu = 2;
    mIv = 1;
    mIw = 2;
    mIx = 0;
    mII = false;
    CREATOR = new LiveConfig.1();
    AppMethodBeat.o(246198);
  }
  
  private LiveConfig()
  {
    AppMethodBeat.i(245961);
    this.mIy = mIs;
    this.liveId = 0L;
    this.mIz = "";
    this.mIA = "";
    this.mIB = new HashMap();
    this.thumbUrl = "";
    this.mIC = "";
    this.scene = mIp;
    this.fromScene = mIx;
    this.mIE = "";
    this.mIF = 0;
    this.mIG = "";
    this.mIH = 0L;
    this.desc = "";
    this.mIJ = 0;
    this.hUQ = "";
    this.mIK = "";
    this.nonceId = "";
    this.mIL = "";
    this.mIM = "";
    this.mIN = "";
    this.mIO = 0L;
    this.mIP = 0L;
    this.sessionBuffer = "";
    this.mIQ = "";
    this.mIR = false;
    this.mIS = "";
    this.mIT = 0;
    this.mIU = "";
    this.mIV = 0L;
    this.mIW = null;
    this.mIX = 0;
    this.mIY = 0;
    this.mIZ = 0;
    this.mJa = 0;
    this.mJb = 0;
    AppMethodBeat.o(245961);
  }
  
  /* Error */
  protected LiveConfig(Parcel paramParcel)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 105	java/lang/Object:<init>	()V
    //   4: ldc 187
    //   6: invokestatic 73	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: getstatic 81	com/tencent/mm/live/api/LiveConfig:mIs	I
    //   13: putfield 108	com/tencent/mm/live/api/LiveConfig:mIy	I
    //   16: aload_0
    //   17: lconst_0
    //   18: putfield 110	com/tencent/mm/live/api/LiveConfig:liveId	J
    //   21: aload_0
    //   22: ldc 112
    //   24: putfield 114	com/tencent/mm/live/api/LiveConfig:mIz	Ljava/lang/String;
    //   27: aload_0
    //   28: ldc 112
    //   30: putfield 116	com/tencent/mm/live/api/LiveConfig:mIA	Ljava/lang/String;
    //   33: aload_0
    //   34: new 118	java/util/HashMap
    //   37: dup
    //   38: invokespecial 119	java/util/HashMap:<init>	()V
    //   41: putfield 121	com/tencent/mm/live/api/LiveConfig:mIB	Ljava/util/HashMap;
    //   44: aload_0
    //   45: ldc 112
    //   47: putfield 123	com/tencent/mm/live/api/LiveConfig:thumbUrl	Ljava/lang/String;
    //   50: aload_0
    //   51: ldc 112
    //   53: putfield 125	com/tencent/mm/live/api/LiveConfig:mIC	Ljava/lang/String;
    //   56: aload_0
    //   57: getstatic 75	com/tencent/mm/live/api/LiveConfig:mIp	I
    //   60: putfield 127	com/tencent/mm/live/api/LiveConfig:scene	I
    //   63: aload_0
    //   64: getstatic 91	com/tencent/mm/live/api/LiveConfig:mIx	I
    //   67: putfield 129	com/tencent/mm/live/api/LiveConfig:fromScene	I
    //   70: aload_0
    //   71: ldc 112
    //   73: putfield 131	com/tencent/mm/live/api/LiveConfig:mIE	Ljava/lang/String;
    //   76: aload_0
    //   77: iconst_0
    //   78: putfield 133	com/tencent/mm/live/api/LiveConfig:mIF	I
    //   81: aload_0
    //   82: ldc 112
    //   84: putfield 135	com/tencent/mm/live/api/LiveConfig:mIG	Ljava/lang/String;
    //   87: aload_0
    //   88: lconst_0
    //   89: putfield 137	com/tencent/mm/live/api/LiveConfig:mIH	J
    //   92: aload_0
    //   93: ldc 112
    //   95: putfield 139	com/tencent/mm/live/api/LiveConfig:desc	Ljava/lang/String;
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 141	com/tencent/mm/live/api/LiveConfig:mIJ	I
    //   103: aload_0
    //   104: ldc 112
    //   106: putfield 143	com/tencent/mm/live/api/LiveConfig:hUQ	Ljava/lang/String;
    //   109: aload_0
    //   110: ldc 112
    //   112: putfield 145	com/tencent/mm/live/api/LiveConfig:mIK	Ljava/lang/String;
    //   115: aload_0
    //   116: ldc 112
    //   118: putfield 147	com/tencent/mm/live/api/LiveConfig:nonceId	Ljava/lang/String;
    //   121: aload_0
    //   122: ldc 112
    //   124: putfield 149	com/tencent/mm/live/api/LiveConfig:mIL	Ljava/lang/String;
    //   127: aload_0
    //   128: ldc 112
    //   130: putfield 151	com/tencent/mm/live/api/LiveConfig:mIM	Ljava/lang/String;
    //   133: aload_0
    //   134: ldc 112
    //   136: putfield 153	com/tencent/mm/live/api/LiveConfig:mIN	Ljava/lang/String;
    //   139: aload_0
    //   140: lconst_0
    //   141: putfield 155	com/tencent/mm/live/api/LiveConfig:mIO	J
    //   144: aload_0
    //   145: lconst_0
    //   146: putfield 157	com/tencent/mm/live/api/LiveConfig:mIP	J
    //   149: aload_0
    //   150: ldc 112
    //   152: putfield 159	com/tencent/mm/live/api/LiveConfig:sessionBuffer	Ljava/lang/String;
    //   155: aload_0
    //   156: ldc 112
    //   158: putfield 161	com/tencent/mm/live/api/LiveConfig:mIQ	Ljava/lang/String;
    //   161: aload_0
    //   162: iconst_0
    //   163: putfield 163	com/tencent/mm/live/api/LiveConfig:mIR	Z
    //   166: aload_0
    //   167: ldc 112
    //   169: putfield 165	com/tencent/mm/live/api/LiveConfig:mIS	Ljava/lang/String;
    //   172: aload_0
    //   173: iconst_0
    //   174: putfield 167	com/tencent/mm/live/api/LiveConfig:mIT	I
    //   177: aload_0
    //   178: ldc 112
    //   180: putfield 169	com/tencent/mm/live/api/LiveConfig:mIU	Ljava/lang/String;
    //   183: aload_0
    //   184: lconst_0
    //   185: putfield 171	com/tencent/mm/live/api/LiveConfig:mIV	J
    //   188: aload_0
    //   189: aconst_null
    //   190: putfield 173	com/tencent/mm/live/api/LiveConfig:mIW	[B
    //   193: aload_0
    //   194: iconst_0
    //   195: putfield 175	com/tencent/mm/live/api/LiveConfig:mIX	I
    //   198: aload_0
    //   199: iconst_0
    //   200: putfield 177	com/tencent/mm/live/api/LiveConfig:mIY	I
    //   203: aload_0
    //   204: iconst_0
    //   205: putfield 179	com/tencent/mm/live/api/LiveConfig:mIZ	I
    //   208: aload_0
    //   209: iconst_0
    //   210: putfield 181	com/tencent/mm/live/api/LiveConfig:mJa	I
    //   213: aload_0
    //   214: iconst_0
    //   215: putfield 183	com/tencent/mm/live/api/LiveConfig:mJb	I
    //   218: aload_0
    //   219: aload_1
    //   220: invokevirtual 193	android/os/Parcel:readInt	()I
    //   223: putfield 108	com/tencent/mm/live/api/LiveConfig:mIy	I
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 197	android/os/Parcel:readSerializable	()Ljava/io/Serializable;
    //   231: checkcast 118	java/util/HashMap
    //   234: putfield 121	com/tencent/mm/live/api/LiveConfig:mIB	Ljava/util/HashMap;
    //   237: aload_0
    //   238: aload_1
    //   239: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   242: putfield 114	com/tencent/mm/live/api/LiveConfig:mIz	Ljava/lang/String;
    //   245: aload_0
    //   246: aload_1
    //   247: invokevirtual 205	android/os/Parcel:readLong	()J
    //   250: putfield 110	com/tencent/mm/live/api/LiveConfig:liveId	J
    //   253: aload_0
    //   254: aload_1
    //   255: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   258: putfield 116	com/tencent/mm/live/api/LiveConfig:mIA	Ljava/lang/String;
    //   261: aload_0
    //   262: aload_1
    //   263: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   266: putfield 123	com/tencent/mm/live/api/LiveConfig:thumbUrl	Ljava/lang/String;
    //   269: aload_0
    //   270: aload_1
    //   271: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   274: putfield 125	com/tencent/mm/live/api/LiveConfig:mIC	Ljava/lang/String;
    //   277: aload_0
    //   278: aload_1
    //   279: invokevirtual 193	android/os/Parcel:readInt	()I
    //   282: putfield 127	com/tencent/mm/live/api/LiveConfig:scene	I
    //   285: aload_0
    //   286: aload_1
    //   287: invokevirtual 193	android/os/Parcel:readInt	()I
    //   290: putfield 129	com/tencent/mm/live/api/LiveConfig:fromScene	I
    //   293: aload_0
    //   294: aload_1
    //   295: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   298: putfield 131	com/tencent/mm/live/api/LiveConfig:mIE	Ljava/lang/String;
    //   301: aload_0
    //   302: aload_1
    //   303: invokevirtual 193	android/os/Parcel:readInt	()I
    //   306: putfield 133	com/tencent/mm/live/api/LiveConfig:mIF	I
    //   309: aload_0
    //   310: aload_1
    //   311: invokevirtual 205	android/os/Parcel:readLong	()J
    //   314: putfield 137	com/tencent/mm/live/api/LiveConfig:mIH	J
    //   317: aload_0
    //   318: aload_1
    //   319: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   322: putfield 147	com/tencent/mm/live/api/LiveConfig:nonceId	Ljava/lang/String;
    //   325: aload_0
    //   326: aload_1
    //   327: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   330: putfield 149	com/tencent/mm/live/api/LiveConfig:mIL	Ljava/lang/String;
    //   333: aload_0
    //   334: aload_1
    //   335: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   338: putfield 151	com/tencent/mm/live/api/LiveConfig:mIM	Ljava/lang/String;
    //   341: aload_0
    //   342: aload_1
    //   343: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   346: putfield 153	com/tencent/mm/live/api/LiveConfig:mIN	Ljava/lang/String;
    //   349: aload_0
    //   350: aload_1
    //   351: invokevirtual 205	android/os/Parcel:readLong	()J
    //   354: putfield 155	com/tencent/mm/live/api/LiveConfig:mIO	J
    //   357: aload_0
    //   358: aload_1
    //   359: invokevirtual 205	android/os/Parcel:readLong	()J
    //   362: putfield 157	com/tencent/mm/live/api/LiveConfig:mIP	J
    //   365: aload_0
    //   366: aload_1
    //   367: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   370: putfield 139	com/tencent/mm/live/api/LiveConfig:desc	Ljava/lang/String;
    //   373: aload_0
    //   374: aload_1
    //   375: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   378: putfield 159	com/tencent/mm/live/api/LiveConfig:sessionBuffer	Ljava/lang/String;
    //   381: aload_0
    //   382: aload_1
    //   383: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   386: putfield 161	com/tencent/mm/live/api/LiveConfig:mIQ	Ljava/lang/String;
    //   389: aload_1
    //   390: invokevirtual 209	android/os/Parcel:readByte	()B
    //   393: iconst_1
    //   394: if_icmpne +128 -> 522
    //   397: iconst_1
    //   398: istore_2
    //   399: aload_0
    //   400: iload_2
    //   401: putfield 163	com/tencent/mm/live/api/LiveConfig:mIR	Z
    //   404: aload_0
    //   405: aload_1
    //   406: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   409: putfield 165	com/tencent/mm/live/api/LiveConfig:mIS	Ljava/lang/String;
    //   412: aload_0
    //   413: aload_1
    //   414: invokevirtual 193	android/os/Parcel:readInt	()I
    //   417: putfield 167	com/tencent/mm/live/api/LiveConfig:mIT	I
    //   420: aload_0
    //   421: aload_1
    //   422: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   425: putfield 135	com/tencent/mm/live/api/LiveConfig:mIG	Ljava/lang/String;
    //   428: aload_0
    //   429: aload_1
    //   430: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   433: putfield 169	com/tencent/mm/live/api/LiveConfig:mIU	Ljava/lang/String;
    //   436: aload_0
    //   437: aload_1
    //   438: invokevirtual 205	android/os/Parcel:readLong	()J
    //   441: putfield 171	com/tencent/mm/live/api/LiveConfig:mIV	J
    //   444: aload_0
    //   445: aload_1
    //   446: invokevirtual 213	android/os/Parcel:createByteArray	()[B
    //   449: putfield 173	com/tencent/mm/live/api/LiveConfig:mIW	[B
    //   452: aload_0
    //   453: aload_1
    //   454: invokevirtual 193	android/os/Parcel:readInt	()I
    //   457: putfield 141	com/tencent/mm/live/api/LiveConfig:mIJ	I
    //   460: aload_0
    //   461: aload_1
    //   462: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   465: putfield 143	com/tencent/mm/live/api/LiveConfig:hUQ	Ljava/lang/String;
    //   468: aload_0
    //   469: aload_1
    //   470: invokevirtual 201	android/os/Parcel:readString	()Ljava/lang/String;
    //   473: putfield 145	com/tencent/mm/live/api/LiveConfig:mIK	Ljava/lang/String;
    //   476: aload_0
    //   477: aload_1
    //   478: invokevirtual 193	android/os/Parcel:readInt	()I
    //   481: putfield 175	com/tencent/mm/live/api/LiveConfig:mIX	I
    //   484: aload_0
    //   485: aload_1
    //   486: invokevirtual 193	android/os/Parcel:readInt	()I
    //   489: putfield 177	com/tencent/mm/live/api/LiveConfig:mIY	I
    //   492: aload_0
    //   493: aload_1
    //   494: invokevirtual 193	android/os/Parcel:readInt	()I
    //   497: putfield 179	com/tencent/mm/live/api/LiveConfig:mIZ	I
    //   500: aload_0
    //   501: aload_1
    //   502: invokevirtual 193	android/os/Parcel:readInt	()I
    //   505: putfield 181	com/tencent/mm/live/api/LiveConfig:mJa	I
    //   508: aload_0
    //   509: aload_1
    //   510: invokevirtual 193	android/os/Parcel:readInt	()I
    //   513: putfield 183	com/tencent/mm/live/api/LiveConfig:mJb	I
    //   516: ldc 187
    //   518: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: return
    //   522: iconst_0
    //   523: istore_2
    //   524: goto -125 -> 399
    //   527: astore_1
    //   528: ldc 215
    //   530: aload_1
    //   531: ldc 217
    //   533: iconst_0
    //   534: anewarray 4	java/lang/Object
    //   537: invokestatic 223	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   540: aload_0
    //   541: iconst_0
    //   542: putfield 177	com/tencent/mm/live/api/LiveConfig:mIY	I
    //   545: ldc 187
    //   547: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   550: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	551	0	this	LiveConfig
    //   0	551	1	paramParcel	Parcel
    //   398	126	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   484	516	527	finally
  }
  
  public static LiveConfig aw(String paramString, int paramInt)
  {
    AppMethodBeat.i(245967);
    a locala = new a();
    locala.mIy = mIs;
    locala.mIz = paramString;
    locala.mIC = z.bAM();
    locala.scene = paramInt;
    paramString = locala.bcd();
    AppMethodBeat.o(245967);
    return paramString;
  }
  
  public static LiveConfig b(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(245971);
    a locala = new a();
    locala.mIy = mIt;
    locala.thumbUrl = paramString2;
    locala.mIz = paramString3;
    locala.liveId = 0L;
    locala.mIA = paramString1;
    locala.mIC = paramString4;
    paramString1 = locala.bcd();
    AppMethodBeat.o(245971);
    return paramString1;
  }
  
  public static boolean bcc()
  {
    if (BuildInfo.DEBUG) {
      return false;
    }
    return mII;
  }
  
  public static void fC(boolean paramBoolean)
  {
    mII = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String info()
  {
    AppMethodBeat.i(246230);
    int i = this.mIy;
    String str3 = this.mIz;
    long l1 = this.liveId;
    String str4 = this.mIA;
    String str5 = this.mIC;
    int j = this.scene;
    int k = this.fromScene;
    long l2 = this.mIH;
    String str6 = this.mIL;
    String str7 = this.mIM;
    long l3 = this.mIO;
    long l4 = this.mIP;
    String str8 = this.desc;
    String str9 = this.mIU;
    String str2 = this.sessionBuffer;
    String str1;
    if (Util.isNullOrNil(str2)) {
      str1 = "";
    }
    for (;;)
    {
      str1 = String.format("toWhere:%s,hostRoomId:%s,liveId:%s,liveName:%s,anchorUsername:%s,scene:%s,fromScene:%s, finderObjectId:%s, linkAnchorUsername:%s, linkAnchorNickname:%s,linkFinderObjectId:%s, linkFinderLiveId:%s, desc:%s, nicknameOption:%s sessionBuffer:%s,bindType:%s,bizUsername:%s,bizNickname:%s, vrLiveType:%s, eventid:%s, partid:%s, eventStatus:%s, streamStatus:%s", new Object[] { Integer.valueOf(i), str3, Long.valueOf(l1), str4, str5, Integer.valueOf(j), Integer.valueOf(k), Long.valueOf(l2), str6, str7, Long.valueOf(l3), Long.valueOf(l4), str8, str9, str1, Integer.valueOf(this.mIJ), this.hUQ, this.mIK, Integer.valueOf(this.mIX), Integer.valueOf(this.mIY), Integer.valueOf(this.mIZ), Integer.valueOf(this.mJa), Integer.valueOf(this.mJb) });
      AppMethodBeat.o(246230);
      return str1;
      str1 = str2;
      if (str2.length() > 0)
      {
        str1 = str2;
        if (8 < str2.length()) {
          str1 = str2.substring(0, 8);
        }
      }
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(246216);
    paramParcel.writeInt(this.mIy);
    paramParcel.writeSerializable(this.mIB);
    paramParcel.writeString(this.mIz);
    paramParcel.writeLong(this.liveId);
    paramParcel.writeString(this.mIA);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.mIC);
    paramParcel.writeInt(this.scene);
    paramParcel.writeInt(this.fromScene);
    paramParcel.writeString(this.mIE);
    paramParcel.writeInt(this.mIF);
    paramParcel.writeLong(this.mIH);
    paramParcel.writeString(this.nonceId);
    paramParcel.writeString(this.mIL);
    paramParcel.writeString(this.mIM);
    paramParcel.writeString(this.mIN);
    paramParcel.writeLong(this.mIO);
    paramParcel.writeLong(this.mIP);
    paramParcel.writeString(this.desc);
    paramParcel.writeString(this.sessionBuffer);
    paramParcel.writeString(this.mIQ);
    if (this.mIR) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeByte((byte)paramInt);
      paramParcel.writeString(this.mIS);
      paramParcel.writeInt(this.mIT);
      paramParcel.writeString(this.mIG);
      paramParcel.writeString(Util.nullAs(this.mIU, ""));
      paramParcel.writeLong(this.mIV);
      paramParcel.writeByteArray(this.mIW);
      paramParcel.writeInt(this.mIJ);
      paramParcel.writeString(Util.nullAs(this.hUQ, ""));
      paramParcel.writeString(Util.nullAs(this.mIK, ""));
      paramParcel.writeInt(this.mIX);
      paramParcel.writeInt(this.mIY);
      paramParcel.writeInt(this.mIZ);
      paramParcel.writeInt(this.mJa);
      paramParcel.writeInt(this.mJb);
      AppMethodBeat.o(246216);
      return;
    }
  }
  
  public static final class a
  {
    public String desc = "";
    public int fromScene = LiveConfig.mIx;
    public String hUQ = "";
    public long liveId = 0L;
    public String mIA = "";
    public String mIC = "";
    public String mIE = "";
    public int mIF = 0;
    public String mIG = "";
    public long mIH = 0L;
    public int mIJ = 0;
    public String mIK = "";
    public String mIL = "";
    public String mIM = "";
    public String mIN = "";
    public long mIO = 0L;
    public long mIP = 0L;
    public boolean mIR = false;
    private String mIS = "";
    private int mIT = 0;
    public long mIV = 0L;
    public byte[] mIW = null;
    public int mIX = 0;
    public int mIY = 0;
    public int mIZ = 0;
    public int mIy = LiveConfig.mIs;
    public String mIz = "";
    public int mJa = 0;
    public int mJb = 0;
    public String mJc = "";
    public String mJd = "";
    public String nonceId = "";
    public int scene = LiveConfig.mIp;
    public String sessionBuffer = "";
    public String thumbUrl = "";
    
    public final LiveConfig bcd()
    {
      AppMethodBeat.i(245964);
      LiveConfig localLiveConfig = new LiveConfig((byte)0);
      LiveConfig.a(localLiveConfig, this.mIy);
      LiveConfig.a(localLiveConfig, this.mIz);
      LiveConfig.a(localLiveConfig, this.liveId);
      LiveConfig.b(localLiveConfig, this.mIA);
      LiveConfig.c(localLiveConfig, this.thumbUrl);
      LiveConfig.d(localLiveConfig, this.mIC);
      LiveConfig.b(localLiveConfig, this.scene);
      LiveConfig.c(localLiveConfig, this.fromScene);
      LiveConfig.e(localLiveConfig, this.mIE);
      LiveConfig.d(localLiveConfig, this.mIF);
      LiveConfig.b(localLiveConfig, this.mIH);
      LiveConfig.f(localLiveConfig, this.desc);
      LiveConfig.e(localLiveConfig, this.mIJ);
      LiveConfig.g(localLiveConfig, this.hUQ);
      LiveConfig.h(localLiveConfig, this.mIK);
      LiveConfig.i(localLiveConfig, this.nonceId);
      LiveConfig.j(localLiveConfig, this.mIL);
      LiveConfig.c(localLiveConfig, this.mIO);
      LiveConfig.d(localLiveConfig, this.mIP);
      LiveConfig.k(localLiveConfig, this.mIM);
      LiveConfig.l(localLiveConfig, this.mIN);
      LiveConfig.m(localLiveConfig, this.sessionBuffer);
      LiveConfig.n(localLiveConfig, this.mJc);
      LiveConfig.a(localLiveConfig, this.mIR);
      LiveConfig.o(localLiveConfig, this.mIS);
      LiveConfig.f(localLiveConfig, this.mIT);
      LiveConfig.p(localLiveConfig, this.mIG);
      LiveConfig.q(localLiveConfig, this.mJd);
      LiveConfig.e(localLiveConfig, this.mIV);
      LiveConfig.a(localLiveConfig, this.mIW);
      LiveConfig.g(localLiveConfig, this.mIX);
      localLiveConfig.mIY = this.mIY;
      localLiveConfig.mIZ = this.mIZ;
      localLiveConfig.mJa = this.mJa;
      localLiveConfig.mJb = this.mJb;
      AppMethodBeat.o(245964);
      return localLiveConfig;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.api.LiveConfig
 * JD-Core Version:    0.7.0.1
 */