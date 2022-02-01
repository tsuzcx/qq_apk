package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "getDataType", "saveToBallInfo", "", "ballInfo", "saveToMultiTaskInfo", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
@Keep
public final class HandOffFile
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFile> CREATOR;
  public static final a Companion;
  private static final String KAesKey = "handoff#aesKey";
  private static final String KAppId = "handoff#appId";
  private static final String KAuthKey = "handoff#authKey";
  private static final String KCdnURL = "handoff#cdnURL";
  private static final String KExtId = "handoff#extId";
  private static final String KFileStatus = "handoff#fileStatus";
  private static final String KFileType = "handoff#fileType";
  private static final String KFrom = "handoff#from";
  private static final String KFullPath = "handoff#fullPath";
  private static final String KKey = "handoff#key";
  private static final String KMd5 = "handoff#md5";
  private static final String KMediaId = "handoff#KmediaId";
  private static final String KSdkVersion = "handoff#sdkVersion";
  private static final String KSize = "handoff#size";
  private static final String KSource = "handoff#source";
  private static final String KSvrId = "handoff#svrId";
  private static final String KTitle = "handoff#title";
  private static final String KTo = "handoff#to";
  private static final String KUploadedSize = "handoff#KUploadedSize";
  private String aesKey;
  private String appId;
  private String authKey;
  private String cdnURL;
  private String extId;
  private int fileStatus;
  private String fileType;
  private String fullPath;
  private String md5;
  private String mediaId;
  private int sdkVersion;
  private long size;
  private int source;
  private String svrId;
  private String title;
  private long uploadedSize;
  
  static
  {
    AppMethodBeat.i(121708);
    Companion = new a((byte)0);
    CREATOR = (Parcelable.Creator)new HandOffFile.b();
    AppMethodBeat.o(121708);
  }
  
  public HandOffFile()
  {
    this("", "", "", "", 0L, 0, "", "", "", "", "", 0, "", 0, "", 0L, 0, null, null, null, 1015808, null);
  }
  
  public HandOffFile(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121707);
    String str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.fullPath = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.fileType = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.md5 = str;
    this.size = paramParcel.readLong();
    this.source = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.svrId = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.extId = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.cdnURL = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.aesKey = str;
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.authKey = str;
    this.fileStatus = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.appId = str;
    this.sdkVersion = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.iCn();
    }
    this.mediaId = str;
    this.uploadedSize = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, 0L, 0, null, null, null, 1015808, null);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, 0, null, null, null, 983040, null);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, null, null, null, 917504, null);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, paramString12, null, null, 786432, null);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, paramString12, paramString13, null, 524288, null);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13, String paramString14)
  {
    super(paramInt4, paramString12, paramString13, paramString14, null, 0L, 48, null);
    AppMethodBeat.i(121705);
    this.fullPath = paramString1;
    this.fileType = paramString2;
    this.title = paramString3;
    this.md5 = paramString4;
    this.size = paramLong1;
    this.source = paramInt1;
    this.svrId = paramString5;
    this.extId = paramString6;
    this.cdnURL = paramString7;
    this.aesKey = paramString8;
    this.authKey = paramString9;
    this.fileStatus = paramInt2;
    this.appId = paramString10;
    this.sdkVersion = paramInt3;
    this.mediaId = paramString11;
    this.uploadedSize = paramLong2;
    AppMethodBeat.o(121705);
  }
  
  public static final HandOffFile fromBallInfo(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121711);
    paramBallInfo = a.fromBallInfo(paramBallInfo);
    AppMethodBeat.o(121711);
    return paramBallInfo;
  }
  
  public static final HandOffFile fromFavItem(anm paramanm, String paramString)
  {
    AppMethodBeat.i(192817);
    paramanm = a.a(paramanm, null, paramString, 6);
    AppMethodBeat.o(192817);
    return paramanm;
  }
  
  public static final HandOffFile fromFavItem(anm paramanm, String paramString1, ca paramca, String paramString2)
  {
    AppMethodBeat.i(192807);
    paramanm = a.fromFavItem(paramanm, paramString1, paramca, paramString2);
    AppMethodBeat.o(192807);
    return paramanm;
  }
  
  public static final HandOffFile fromFavItem(anm paramanm, String paramString1, String paramString2)
  {
    AppMethodBeat.i(192814);
    paramanm = a.a(paramanm, paramString1, paramString2, 4);
    AppMethodBeat.o(192814);
    return paramanm;
  }
  
  public static final HandOffFile fromMultiTask(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(192820);
    paramMultiTaskInfo = a.fromMultiTask(paramMultiTaskInfo);
    AppMethodBeat.o(192820);
    return paramMultiTaskInfo;
  }
  
  public static final boolean isSupportOpenFile(String paramString)
  {
    AppMethodBeat.i(192825);
    boolean bool = a.isSupportOpenFile(paramString);
    AppMethodBeat.o(192825);
    return bool;
  }
  
  protected final String body()
  {
    AppMethodBeat.i(121700);
    String str = n.bHx("\n        <filetype>" + a.dy(this.fileType) + "</filetype>\n        <title>" + a.dy(this.title) + "</title>\n        <md5>" + a.dy(this.md5) + "</md5>\n        <uploadedsize>" + a.dy(Long.valueOf(this.uploadedSize)) + "</uploadedsize>\n        <size>" + a.dy(Long.valueOf(this.size)) + "</size>\n        <source>" + a.dy(Integer.valueOf(this.source)) + "</source>\n        <id>" + a.dy(this.svrId) + "</id>\n        <extid>" + a.dy(this.extId) + "</extid>\n        <cdnurl>" + a.dy(this.cdnURL) + "</cdnurl>\n        <aeskey>" + a.dy(this.aesKey) + "</aeskey>\n        <authkey>" + a.dy(this.authKey) + "</authkey>\n        <filestatus>" + a.dy(Integer.valueOf(this.fileStatus)) + "</filestatus>\n        <appid>" + a.dy(this.appId) + "</appid>\n        <sdkversion>" + a.dy(Integer.valueOf(this.sdkVersion)) + "</sdkversion>\n        <mediaid>" + a.dy(this.mediaId) + "</mediaid>\n    ");
    AppMethodBeat.o(121700);
    return str;
  }
  
  public final HandOff copy()
  {
    AppMethodBeat.i(121703);
    Object localObject = new HandOffFile(this.fullPath, this.fileType, this.title, this.md5, this.size, this.source, this.svrId, this.extId, this.cdnURL, this.aesKey, this.authKey, this.fileStatus, this.appId, this.sdkVersion, this.mediaId, this.uploadedSize, getHandOffType(), getFrom(), getTo(), getKey());
    ((HandOffFile)localObject).setId(getId());
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121703);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  protected final BallInfo doCreateBallInfo()
  {
    return null;
  }
  
  protected final o<dar, byte[]> doCreateMultiTaskInfo()
  {
    return null;
  }
  
  public final String getAesKey()
  {
    return this.aesKey;
  }
  
  public final String getAppId()
  {
    return this.appId;
  }
  
  public final String getAuthKey()
  {
    return this.authKey;
  }
  
  public final String getCdnURL()
  {
    return this.cdnURL;
  }
  
  public final int getDataType()
  {
    return 1;
  }
  
  public final String getExtId()
  {
    return this.extId;
  }
  
  public final int getFileStatus()
  {
    return this.fileStatus;
  }
  
  public final String getFileType()
  {
    return this.fileType;
  }
  
  public final String getFullPath()
  {
    return this.fullPath;
  }
  
  public final String getMd5()
  {
    return this.md5;
  }
  
  public final String getMediaId()
  {
    return this.mediaId;
  }
  
  public final int getSdkVersion()
  {
    return this.sdkVersion;
  }
  
  public final long getSize()
  {
    return this.size;
  }
  
  public final int getSource()
  {
    return this.source;
  }
  
  public final String getSvrId()
  {
    return this.svrId;
  }
  
  public final String getTitle()
  {
    return this.title;
  }
  
  public final long getUploadedSize()
  {
    return this.uploadedSize;
  }
  
  public final void saveToBallInfo(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(192736);
    p.k(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.fg("handoff#fullPath", this.fullPath);
      paramBallInfo.fg("handoff#fileType", this.fileType);
      paramBallInfo.fg("handoff#title", this.title);
      paramBallInfo.fg("handoff#md5", this.md5);
      paramBallInfo.Y("handoff#size", this.size);
      paramBallInfo.cT("handoff#source", this.source);
      paramBallInfo.fg("handoff#svrId", this.svrId);
      paramBallInfo.fg("handoff#extId", this.extId);
      paramBallInfo.fg("handoff#cdnURL", this.cdnURL);
      paramBallInfo.fg("handoff#aesKey", this.aesKey);
      paramBallInfo.fg("handoff#authKey", this.authKey);
      paramBallInfo.cT("handoff#fileStatus", this.fileStatus);
      paramBallInfo.fg("handoff#appId", this.appId);
      paramBallInfo.cT("handoff#sdkVersion", this.sdkVersion);
      paramBallInfo.fg("handoff#KmediaId", this.mediaId);
      paramBallInfo.Y("handoff#KUploadedSize", this.uploadedSize);
      paramBallInfo.fg("handoff#from", getFrom());
      paramBallInfo.fg("handoff#to", getTo());
      paramBallInfo.fg("handoff#key", getKey());
      AppMethodBeat.o(192736);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(192736);
    }
  }
  
  public final void saveToMultiTaskInfo(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(192738);
    if (paramMultiTaskInfo == null)
    {
      AppMethodBeat.o(192738);
      return;
    }
    apf localapf = new apf();
    localapf.parseFrom(paramMultiTaskInfo.field_data);
    localapf.SCG = this.size;
    localapf.SCs = this.md5;
    localapf.SCt = this.source;
    localapf.SCu = this.svrId;
    localapf.SCv = this.extId;
    localapf.SCw = this.cdnURL;
    localapf.SCx = this.aesKey;
    localapf.SCy = this.authKey;
    localapf.SCz = this.fileStatus;
    localapf.SCA = this.appId;
    localapf.SCB = this.sdkVersion;
    localapf.SCC = this.mediaId;
    localapf.SCD = this.uploadedSize;
    localapf.SCE = getFrom();
    localapf.SCF = getTo();
    paramMultiTaskInfo.field_data = localapf.toByteArray();
    AppMethodBeat.o(192738);
  }
  
  public final void setAesKey(String paramString)
  {
    AppMethodBeat.i(121698);
    p.k(paramString, "<set-?>");
    this.aesKey = paramString;
    AppMethodBeat.o(121698);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(192709);
    p.k(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(192709);
  }
  
  public final void setAuthKey(String paramString)
  {
    AppMethodBeat.i(192706);
    p.k(paramString, "<set-?>");
    this.authKey = paramString;
    AppMethodBeat.o(192706);
  }
  
  public final void setCdnURL(String paramString)
  {
    AppMethodBeat.i(121697);
    p.k(paramString, "<set-?>");
    this.cdnURL = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void setExtId(String paramString)
  {
    AppMethodBeat.i(192702);
    p.k(paramString, "<set-?>");
    this.extId = paramString;
    AppMethodBeat.o(192702);
  }
  
  public final void setFileStatus(int paramInt)
  {
    this.fileStatus = paramInt;
  }
  
  public final void setFileType(String paramString)
  {
    AppMethodBeat.i(192684);
    p.k(paramString, "<set-?>");
    this.fileType = paramString;
    AppMethodBeat.o(192684);
  }
  
  public final void setFullPath(String paramString)
  {
    AppMethodBeat.i(121696);
    p.k(paramString, "<set-?>");
    this.fullPath = paramString;
    AppMethodBeat.o(121696);
  }
  
  public final void setMd5(String paramString)
  {
    AppMethodBeat.i(192693);
    p.k(paramString, "<set-?>");
    this.md5 = paramString;
    AppMethodBeat.o(192693);
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(192712);
    p.k(paramString, "<set-?>");
    this.mediaId = paramString;
    AppMethodBeat.o(192712);
  }
  
  public final void setSdkVersion(int paramInt)
  {
    this.sdkVersion = paramInt;
  }
  
  public final void setSize(long paramLong)
  {
    this.size = paramLong;
  }
  
  public final void setSource(int paramInt)
  {
    this.source = paramInt;
  }
  
  public final void setSvrId(String paramString)
  {
    AppMethodBeat.i(192699);
    p.k(paramString, "<set-?>");
    this.svrId = paramString;
    AppMethodBeat.o(192699);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(192689);
    p.k(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(192689);
  }
  
  public final void setUploadedSize(long paramLong)
  {
    this.uploadedSize = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    String str = "HandOffFile(key='" + getKey() + "', id='" + getId() + "', createTime='" + getCreateTime() + ", fullPath='" + this.fullPath + "', fileType='" + this.fileType + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.source + ", svrId='" + this.svrId + "', extId='" + this.extId + "', cdnURL='" + this.cdnURL + "', aesKey='" + this.aesKey + "', authKey='" + this.authKey + "', fileStatus=" + this.fileStatus + ", appId='" + this.appId + "', sdkVersion=" + this.sdkVersion + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.uploadedSize + ')';
    AppMethodBeat.o(121704);
    return str;
  }
  
  public final void update(HandOff paramHandOff)
  {
    AppMethodBeat.i(121699);
    p.k(paramHandOff, "newHandOff");
    super.update(paramHandOff);
    if ((paramHandOff instanceof HandOffFile))
    {
      if (((CharSequence)((HandOffFile)paramHandOff).fullPath).length() <= 0) {
        break label526;
      }
      i = 1;
      if (i != 0) {
        this.fullPath = ((HandOffFile)paramHandOff).fullPath;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).fileType).length() <= 0) {
        break label531;
      }
      i = 1;
      label80:
      if (i != 0) {
        this.fileType = ((HandOffFile)paramHandOff).fileType;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).title).length() <= 0) {
        break label536;
      }
      i = 1;
      label115:
      if (i != 0) {
        this.title = ((HandOffFile)paramHandOff).title;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).md5).length() <= 0) {
        break label541;
      }
      i = 1;
      label150:
      if (i != 0) {
        this.md5 = ((HandOffFile)paramHandOff).md5;
      }
      if (((HandOffFile)paramHandOff).size != 0L) {
        this.size = ((HandOffFile)paramHandOff).size;
      }
      if (((HandOffFile)paramHandOff).source != 0) {
        this.source = ((HandOffFile)paramHandOff).source;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).svrId).length() <= 0) {
        break label546;
      }
      i = 1;
      label229:
      if (i != 0) {
        this.svrId = ((HandOffFile)paramHandOff).svrId;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).extId).length() <= 0) {
        break label551;
      }
      i = 1;
      label264:
      if (i != 0) {
        this.extId = ((HandOffFile)paramHandOff).extId;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).cdnURL).length() <= 0) {
        break label556;
      }
      i = 1;
      label299:
      if (i != 0) {
        this.cdnURL = ((HandOffFile)paramHandOff).cdnURL;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).aesKey).length() <= 0) {
        break label561;
      }
      i = 1;
      label334:
      if (i != 0) {
        this.aesKey = ((HandOffFile)paramHandOff).aesKey;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).authKey).length() <= 0) {
        break label566;
      }
      i = 1;
      label369:
      if (i != 0) {
        this.authKey = ((HandOffFile)paramHandOff).authKey;
      }
      if (((HandOffFile)paramHandOff).fileStatus != 0) {
        this.fileStatus = ((HandOffFile)paramHandOff).fileStatus;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).appId).length() <= 0) {
        break label571;
      }
      i = 1;
      label425:
      if (i != 0) {
        this.appId = ((HandOffFile)paramHandOff).appId;
      }
      if (((HandOffFile)paramHandOff).sdkVersion != 0) {
        this.sdkVersion = ((HandOffFile)paramHandOff).sdkVersion;
      }
      if (((CharSequence)((HandOffFile)paramHandOff).mediaId).length() <= 0) {
        break label576;
      }
    }
    label526:
    label531:
    label536:
    label541:
    label546:
    label551:
    label556:
    label561:
    label566:
    label571:
    label576:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      }
      if (((HandOffFile)paramHandOff).uploadedSize != 0L) {
        this.uploadedSize = ((HandOffFile)paramHandOff).uploadedSize;
      }
      AppMethodBeat.o(121699);
      return;
      i = 0;
      break;
      i = 0;
      break label80;
      i = 0;
      break label115;
      i = 0;
      break label150;
      i = 0;
      break label229;
      i = 0;
      break label264;
      i = 0;
      break label299;
      i = 0;
      break label334;
      i = 0;
      break label369;
      i = 0;
      break label425;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    p.k(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.fullPath);
    paramParcel.writeString(this.fileType);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.source);
    paramParcel.writeString(this.svrId);
    paramParcel.writeString(this.extId);
    paramParcel.writeString(this.cdnURL);
    paramParcel.writeString(this.aesKey);
    paramParcel.writeString(this.authKey);
    paramParcel.writeInt(this.fileStatus);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.sdkVersion);
    paramParcel.writeString(this.mediaId);
    paramParcel.writeLong(this.uploadedSize);
    AppMethodBeat.o(121701);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "favId", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fullpath", "fromMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "isSupportOpenFile", "", "fileExt", "api-handoff_release"})
  public static final class a
  {
    public static HandOffFile fromBallInfo(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      p.k(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.fh("handoff#fullPath", "");
      String str2 = paramBallInfo.fh("handoff#fileType", "");
      String str3 = paramBallInfo.fh("handoff#title", "");
      String str4 = paramBallInfo.fh("handoff#md5", "");
      long l1 = paramBallInfo.aov("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.fh("handoff#svrId", "");
      String str6 = paramBallInfo.fh("handoff#extId", "");
      String str7 = paramBallInfo.fh("handoff#cdnURL", "");
      String str8 = paramBallInfo.fh("handoff#aesKey", "");
      String str9 = paramBallInfo.fh("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.fh("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.fh("handoff#KmediaId", "");
      long l2 = paramBallInfo.aov("handoff#KUploadedSize");
      String str12 = paramBallInfo.fh("handoff#from", "");
      String str13 = paramBallInfo.fh("handoff#to", "");
      paramBallInfo = paramBallInfo.fh("handoff#key", "");
      p.j(str1, "fullPath");
      p.j(str2, "fileType");
      p.j(str3, "title");
      p.j(str4, "md5");
      p.j(str5, "svrId");
      p.j(str6, "extId");
      p.j(str7, "cdnURL");
      p.j(str8, "aesKey");
      p.j(str9, "authKey");
      p.j(str10, "appId");
      p.j(str11, "mediaId");
      p.j(str12, "from");
      p.j(str13, "to");
      p.j(paramBallInfo, "key");
      paramBallInfo = new HandOffFile(str1, str2, str3, str4, l1, i, str5, str6, str7, str8, str9, j, str10, k, str11, l2, 2, str12, str13, paramBallInfo);
      AppMethodBeat.o(121695);
      return paramBallInfo;
    }
    
    public static HandOffFile fromFavItem(anm paramanm, String paramString1, ca paramca, String paramString2)
    {
      AppMethodBeat.i(193065);
      p.k(paramanm, "dataItem");
      String str7 = Util.nullAsNil(paramString2);
      String str8 = Util.nullAsNil(paramanm.hpq());
      String str9 = Util.nullAsNil(paramanm.getTitle());
      String str10 = Util.nullAsNil(paramanm.hpr());
      long l = Util.nullAsNil(Long.valueOf(paramanm.hps()));
      String str4 = Util.nullAsNil(paramanm.hpn());
      String str11 = Util.nullAsNil(paramanm.hpo());
      String str12 = Util.nullAsNil(paramanm.hpw());
      String str5 = Util.nullAsNil(paramanm.hpx());
      String str13 = Util.nullAsNil(paramanm.hns());
      String str3 = "";
      int i = 3;
      String str1 = "";
      String str6 = "";
      String str2;
      int j;
      if (paramString1 != null)
      {
        i = 2;
        str2 = str6;
        paramString2 = str1;
        p.j(str7, "fullPath");
        p.j(str8, "fileExt");
        p.j(str9, "fileName");
        p.j(str10, "fileMd5");
        p.j(str13, "extId");
        p.j(str4, "cdnURL");
        if (((CharSequence)str4).length() <= 0) {
          break label384;
        }
        j = 1;
        label188:
        if (j == 0) {
          break label390;
        }
      }
      label384:
      label390:
      for (paramanm = str4;; paramanm = str5)
      {
        for (;;)
        {
          p.j(paramanm, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          p.j(str11, "aesKey");
          p.j(str12, "authKey");
          paramanm = new HandOffFile(str7, str8, str9, str10, l, i, paramString1, str13, paramanm, str11, str12, 1, "", 0, "", 0L, 1, paramString2, str2, null, 524288, null);
          AppMethodBeat.o(193065);
          return paramanm;
          paramString1 = str3;
          paramString2 = str1;
          str2 = str6;
          if (paramca == null) {
            break;
          }
          i = 1;
          paramString2 = str3;
          try
          {
            paramString1 = String.valueOf(paramca.apH());
            paramString2 = paramString1;
            paramanm = paramanm.hpt();
            paramString2 = paramString1;
            p.j(paramanm, "dataItem.dataProtoItem");
            paramString2 = paramString1;
            paramanm = paramanm.hpy();
            paramString2 = paramString1;
            p.j(paramanm, "dataItem.dataProtoItem.dataSourceItem");
            paramString2 = paramString1;
            paramanm = paramanm.getFromUser();
            paramString2 = paramString1;
            p.j(paramanm, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramanm)
          {
            try
            {
              str2 = paramca.apJ();
              p.j(str2, "msg.talker");
              paramString2 = paramanm;
            }
            catch (Exception paramca)
            {
              break label366;
            }
            paramanm = paramanm;
            paramanm = str1;
            paramString1 = paramString2;
          }
        }
        label366:
        Log.w("HandOffService", "Get null from record msg, use default value");
        paramString2 = paramanm;
        str2 = str6;
        break;
        j = 0;
        break label188;
      }
    }
    
    public static HandOffFile fromMultiTask(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(193084);
      if (paramMultiTaskInfo == null)
      {
        AppMethodBeat.o(193084);
        return null;
      }
      Object localObject1 = paramMultiTaskInfo.fbc();
      Object localObject2 = new apf();
      ((apf)localObject2).parseFrom(paramMultiTaskInfo.field_data);
      String str1 = Util.nullAsNil(((apf)localObject2).filePath);
      String str2 = Util.nullAsNil(((apf)localObject2).jmx);
      localObject1 = Util.nullAsNil(((dar)localObject1).title);
      String str3 = Util.nullAsNil(((apf)localObject2).SCs);
      long l1 = ((apf)localObject2).SCG;
      int i = ((apf)localObject2).SCt;
      String str4 = Util.nullAsNil(((apf)localObject2).SCu);
      String str5 = Util.nullAsNil(((apf)localObject2).SCv);
      String str6 = Util.nullAsNil(((apf)localObject2).SCw);
      String str7 = Util.nullAsNil(((apf)localObject2).SCx);
      String str8 = Util.nullAsNil(((apf)localObject2).SCy);
      int j = ((apf)localObject2).SCz;
      String str9 = Util.nullAsNil(((apf)localObject2).SCA);
      int k = ((apf)localObject2).SCB;
      String str10 = Util.nullAsNil(((apf)localObject2).SCC);
      long l2 = ((apf)localObject2).SCD;
      String str11 = Util.nullAsNil(((apf)localObject2).SCE);
      localObject2 = Util.nullAsNil(((apf)localObject2).SCF);
      paramMultiTaskInfo = Util.nullAsNil(paramMultiTaskInfo.field_id);
      p.j(str1, "fullPath");
      p.j(str2, "fileType");
      p.j(localObject1, "title");
      p.j(str3, "md5");
      p.j(str4, "svrId");
      p.j(str5, "extId");
      p.j(str6, "cdnURL");
      p.j(str7, "aesKey");
      p.j(str8, "authKey");
      p.j(str9, "appId");
      p.j(str10, "mediaId");
      p.j(str11, "from");
      p.j(localObject2, "to");
      p.j(paramMultiTaskInfo, "key");
      paramMultiTaskInfo = new HandOffFile(str1, str2, (String)localObject1, str3, l1, i, str4, str5, str6, str7, str8, j, str9, k, str10, l2, 2, str11, (String)localObject2, paramMultiTaskInfo);
      AppMethodBeat.o(193084);
      return paramMultiTaskInfo;
    }
    
    public static boolean isSupportOpenFile(String paramString)
    {
      AppMethodBeat.i(193088);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(193088);
        return false;
      }
      if (n.M(paramString, ".", false)) {}
      while ((FileExplorerUI.brP(paramString)) || (FileExplorerUI.brO(paramString)) || (FileExplorerUI.brQ(paramString)) || (FileExplorerUI.brR(paramString)))
      {
        AppMethodBeat.o(193088);
        return true;
        paramString = ".".concat(String.valueOf(paramString));
      }
      AppMethodBeat.o(193088);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */