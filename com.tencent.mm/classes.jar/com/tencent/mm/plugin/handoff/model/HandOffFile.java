package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.compose.a.q.a..ExternalSyntheticBackport0;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.multitask.model.MultiTaskInfo;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arh;
import com.tencent.mm.protocal.protobuf.asy;
import com.tencent.mm.protocal.protobuf.drz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "doCreateBallInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "doCreateMultiTaskInfo", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/MultiTaskShowData;", "", "equals", "", "other", "", "getDataType", "hashCode", "saveToBallInfo", "", "ballInfo", "saveToMultiTaskInfo", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
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
    CREATOR = (Parcelable.Creator)new b();
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
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.fullPath = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.fileType = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.title = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.md5 = str;
    this.size = paramParcel.readLong();
    this.source = paramParcel.readInt();
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.svrId = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.extId = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.cdnURL = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.aesKey = str;
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.authKey = str;
    this.fileStatus = paramParcel.readInt();
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.appId = str;
    this.sdkVersion = paramParcel.readInt();
    str = paramParcel.readString();
    s.checkNotNull(str);
    s.s(str, "source.readString()!!");
    this.mediaId = str;
    this.uploadedSize = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, 0L, 0, null, null, null, 1015808, null);
    AppMethodBeat.i(266084);
    AppMethodBeat.o(266084);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, 0, null, null, null, 983040, null);
    AppMethodBeat.i(266078);
    AppMethodBeat.o(266078);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, null, null, null, 917504, null);
    AppMethodBeat.i(266070);
    AppMethodBeat.o(266070);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, paramString12, null, null, 786432, null);
    AppMethodBeat.i(266063);
    AppMethodBeat.o(266063);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong1, paramInt1, paramString5, paramString6, paramString7, paramString8, paramString9, paramInt2, paramString10, paramInt3, paramString11, paramLong2, paramInt4, paramString12, paramString13, null, 524288, null);
    AppMethodBeat.i(266054);
    AppMethodBeat.o(266054);
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
  
  public static final HandOffFile fromFavItem(arf paramarf, String paramString)
  {
    AppMethodBeat.i(266128);
    s.u(paramarf, "dataItem");
    paramarf = a.a(paramarf, null, paramString, 6);
    AppMethodBeat.o(266128);
    return paramarf;
  }
  
  public static final HandOffFile fromFavItem(arf paramarf, String paramString1, cc paramcc, String paramString2)
  {
    AppMethodBeat.i(266091);
    paramarf = a.fromFavItem(paramarf, paramString1, paramcc, paramString2);
    AppMethodBeat.o(266091);
    return paramarf;
  }
  
  public static final HandOffFile fromFavItem(arf paramarf, String paramString1, String paramString2)
  {
    AppMethodBeat.i(266120);
    s.u(paramarf, "dataItem");
    paramarf = a.a(paramarf, paramString1, paramString2, 4);
    AppMethodBeat.o(266120);
    return paramarf;
  }
  
  public static final HandOffFile fromMultiTask(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266104);
    paramMultiTaskInfo = a.fromMultiTask(paramMultiTaskInfo);
    AppMethodBeat.o(266104);
    return paramMultiTaskInfo;
  }
  
  public static final boolean isSupportOpenFile(String paramString)
  {
    AppMethodBeat.i(266113);
    boolean bool = a.isSupportOpenFile(paramString);
    AppMethodBeat.o(266113);
    return bool;
  }
  
  protected final String body()
  {
    AppMethodBeat.i(121700);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("\n        <filetype>").append(a.fP(this.fileType)).append("</filetype>\n        <title>").append(a.fP(this.title)).append("</title>\n        <md5>").append(a.fP(this.md5)).append("</md5>\n        <uploadedsize>").append(a.fP(Long.valueOf(this.uploadedSize))).append("</uploadedsize>\n        <size>").append(a.fP(Long.valueOf(this.size))).append("</size>\n        <source>").append(a.fP(Integer.valueOf(this.source))).append("</source>\n        <id>").append(a.fP(this.svrId)).append("</id>\n        <extid>").append(a.fP(this.extId)).append("</extid>\n        <cdnurl>").append(a.fP(this.cdnURL)).append("</cdnurl>\n        <aeskey>").append(a.fP(this.aesKey)).append("</aeskey>\n        <authkey>").append(a.fP(this.authKey)).append("</authkey>\n        <filestatus>");
    ((StringBuilder)localObject).append(a.fP(Integer.valueOf(this.fileStatus))).append("</filestatus>\n        <appid>").append(a.fP(this.appId)).append("</appid>\n        <sdkversion>").append(a.fP(Integer.valueOf(this.sdkVersion))).append("</sdkversion>\n        <mediaid>").append(a.fP(this.mediaId)).append("</mediaid>\n    ");
    localObject = n.bJB(((StringBuilder)localObject).toString());
    AppMethodBeat.o(121700);
    return localObject;
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
  
  protected final r<drz, byte[]> doCreateMultiTaskInfo()
  {
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(266310);
    if (this == paramObject)
    {
      AppMethodBeat.o(266310);
      return true;
    }
    if (!(paramObject instanceof HandOffFile))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!super.equals(paramObject))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.fullPath, ((HandOffFile)paramObject).fullPath))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.fileType, ((HandOffFile)paramObject).fileType))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.title, ((HandOffFile)paramObject).title))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.md5, ((HandOffFile)paramObject).md5))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (this.size != ((HandOffFile)paramObject).size)
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (this.source != ((HandOffFile)paramObject).source)
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.svrId, ((HandOffFile)paramObject).svrId))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.extId, ((HandOffFile)paramObject).extId))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.cdnURL, ((HandOffFile)paramObject).cdnURL))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.aesKey, ((HandOffFile)paramObject).aesKey))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.authKey, ((HandOffFile)paramObject).authKey))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (this.fileStatus != ((HandOffFile)paramObject).fileStatus)
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.appId, ((HandOffFile)paramObject).appId))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (this.sdkVersion != ((HandOffFile)paramObject).sdkVersion)
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (!s.p(this.mediaId, ((HandOffFile)paramObject).mediaId))
    {
      AppMethodBeat.o(266310);
      return false;
    }
    if (this.uploadedSize != ((HandOffFile)paramObject).uploadedSize)
    {
      AppMethodBeat.o(266310);
      return false;
    }
    AppMethodBeat.o(266310);
    return true;
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
  
  public final int hashCode()
  {
    AppMethodBeat.i(266314);
    int i = super.hashCode();
    int j = this.fullPath.hashCode();
    int k = this.fileType.hashCode();
    int m = this.title.hashCode();
    int n = this.md5.hashCode();
    int i1 = q.a..ExternalSyntheticBackport0.m(this.size);
    int i2 = this.source;
    int i3 = this.svrId.hashCode();
    int i4 = this.extId.hashCode();
    int i5 = this.cdnURL.hashCode();
    int i6 = this.aesKey.hashCode();
    int i7 = this.authKey.hashCode();
    int i8 = this.fileStatus;
    int i9 = this.appId.hashCode();
    int i10 = this.sdkVersion;
    int i11 = this.mediaId.hashCode();
    int i12 = q.a..ExternalSyntheticBackport0.m(this.uploadedSize);
    AppMethodBeat.o(266314);
    return (((((((((((((((i * 31 + j) * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + i10) * 31 + i11) * 31 + i12;
  }
  
  public final void saveToBallInfo(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(266296);
    s.u(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.fx("handoff#fullPath", this.fullPath);
      paramBallInfo.fx("handoff#fileType", this.fileType);
      paramBallInfo.fx("handoff#title", this.title);
      paramBallInfo.fx("handoff#md5", this.md5);
      paramBallInfo.ac("handoff#size", this.size);
      paramBallInfo.dv("handoff#source", this.source);
      paramBallInfo.fx("handoff#svrId", this.svrId);
      paramBallInfo.fx("handoff#extId", this.extId);
      paramBallInfo.fx("handoff#cdnURL", this.cdnURL);
      paramBallInfo.fx("handoff#aesKey", this.aesKey);
      paramBallInfo.fx("handoff#authKey", this.authKey);
      paramBallInfo.dv("handoff#fileStatus", this.fileStatus);
      paramBallInfo.fx("handoff#appId", this.appId);
      paramBallInfo.dv("handoff#sdkVersion", this.sdkVersion);
      paramBallInfo.fx("handoff#KmediaId", this.mediaId);
      paramBallInfo.ac("handoff#KUploadedSize", this.uploadedSize);
      paramBallInfo.fx("handoff#from", getFrom());
      paramBallInfo.fx("handoff#to", getTo());
      paramBallInfo.fx("handoff#key", getKey());
      AppMethodBeat.o(266296);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(266296);
    }
  }
  
  public final void saveToMultiTaskInfo(MultiTaskInfo paramMultiTaskInfo)
  {
    AppMethodBeat.i(266298);
    if (paramMultiTaskInfo == null)
    {
      AppMethodBeat.o(266298);
      return;
    }
    asy localasy = new asy();
    localasy.parseFrom(paramMultiTaskInfo.field_data);
    localasy.ZDy = this.size;
    localasy.ZDk = this.md5;
    localasy.ZDl = this.source;
    localasy.ZDm = this.svrId;
    localasy.ZDn = this.extId;
    localasy.ZDo = this.cdnURL;
    localasy.ZDp = this.aesKey;
    localasy.ZDq = this.authKey;
    localasy.ZDr = this.fileStatus;
    localasy.ZDs = this.appId;
    localasy.ZDt = this.sdkVersion;
    localasy.ZDu = this.mediaId;
    localasy.ZDv = this.uploadedSize;
    localasy.ZDw = getFrom();
    localasy.ZDx = getTo();
    paramMultiTaskInfo.field_data = localasy.toByteArray();
    AppMethodBeat.o(266298);
  }
  
  public final void setAesKey(String paramString)
  {
    AppMethodBeat.i(121698);
    s.u(paramString, "<set-?>");
    this.aesKey = paramString;
    AppMethodBeat.o(121698);
  }
  
  public final void setAppId(String paramString)
  {
    AppMethodBeat.i(266259);
    s.u(paramString, "<set-?>");
    this.appId = paramString;
    AppMethodBeat.o(266259);
  }
  
  public final void setAuthKey(String paramString)
  {
    AppMethodBeat.i(266241);
    s.u(paramString, "<set-?>");
    this.authKey = paramString;
    AppMethodBeat.o(266241);
  }
  
  public final void setCdnURL(String paramString)
  {
    AppMethodBeat.i(121697);
    s.u(paramString, "<set-?>");
    this.cdnURL = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void setExtId(String paramString)
  {
    AppMethodBeat.i(266209);
    s.u(paramString, "<set-?>");
    this.extId = paramString;
    AppMethodBeat.o(266209);
  }
  
  public final void setFileStatus(int paramInt)
  {
    this.fileStatus = paramInt;
  }
  
  public final void setFileType(String paramString)
  {
    AppMethodBeat.i(266161);
    s.u(paramString, "<set-?>");
    this.fileType = paramString;
    AppMethodBeat.o(266161);
  }
  
  public final void setFullPath(String paramString)
  {
    AppMethodBeat.i(121696);
    s.u(paramString, "<set-?>");
    this.fullPath = paramString;
    AppMethodBeat.o(121696);
  }
  
  public final void setMd5(String paramString)
  {
    AppMethodBeat.i(266183);
    s.u(paramString, "<set-?>");
    this.md5 = paramString;
    AppMethodBeat.o(266183);
  }
  
  public final void setMediaId(String paramString)
  {
    AppMethodBeat.i(266268);
    s.u(paramString, "<set-?>");
    this.mediaId = paramString;
    AppMethodBeat.o(266268);
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
    AppMethodBeat.i(266200);
    s.u(paramString, "<set-?>");
    this.svrId = paramString;
    AppMethodBeat.o(266200);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(266173);
    s.u(paramString, "<set-?>");
    this.title = paramString;
    AppMethodBeat.o(266173);
  }
  
  public final void setUploadedSize(long paramLong)
  {
    this.uploadedSize = paramLong;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("HandOffFile(key='").append(getKey()).append("', id='").append(getId()).append("', createTime='").append(getCreateTime()).append(", fullPath='").append(this.fullPath).append("', fileType='").append(this.fileType).append("', title='").append(this.title).append("', md5='").append(this.md5).append("', size=").append(this.size).append(", source=").append(this.source).append(", svrId='").append(this.svrId).append("', extId='").append(this.extId).append("', cdnURL='");
    ((StringBuilder)localObject).append(this.cdnURL).append("', aesKey='").append(this.aesKey).append("', authKey='").append(this.authKey).append("', fileStatus=").append(this.fileStatus).append(", appId='").append(this.appId).append("', sdkVersion=").append(this.sdkVersion).append(", mediaId='").append(this.mediaId).append("', uploadedSize=").append(this.uploadedSize).append(')');
    localObject = ((StringBuilder)localObject).toString();
    AppMethodBeat.o(121704);
    return localObject;
  }
  
  public final boolean update(HandOff paramHandOff)
  {
    AppMethodBeat.i(266283);
    s.u(paramHandOff, "newHandOff");
    boolean bool2 = super.update(paramHandOff);
    boolean bool1 = bool2;
    if ((paramHandOff instanceof HandOffFile))
    {
      bool1 = bool2;
      if (!s.p(paramHandOff, this))
      {
        if (((CharSequence)((HandOffFile)paramHandOff).fullPath).length() <= 0) {
          break label545;
        }
        i = 1;
        if (i != 0) {
          this.fullPath = ((HandOffFile)paramHandOff).fullPath;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).fileType).length() <= 0) {
          break label550;
        }
        i = 1;
        label96:
        if (i != 0) {
          this.fileType = ((HandOffFile)paramHandOff).fileType;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).title).length() <= 0) {
          break label555;
        }
        i = 1;
        label131:
        if (i != 0) {
          this.title = ((HandOffFile)paramHandOff).title;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).md5).length() <= 0) {
          break label560;
        }
        i = 1;
        label166:
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
          break label565;
        }
        i = 1;
        label245:
        if (i != 0) {
          this.svrId = ((HandOffFile)paramHandOff).svrId;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).extId).length() <= 0) {
          break label570;
        }
        i = 1;
        label280:
        if (i != 0) {
          this.extId = ((HandOffFile)paramHandOff).extId;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).cdnURL).length() <= 0) {
          break label575;
        }
        i = 1;
        label315:
        if (i != 0) {
          this.cdnURL = ((HandOffFile)paramHandOff).cdnURL;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).aesKey).length() <= 0) {
          break label580;
        }
        i = 1;
        label350:
        if (i != 0) {
          this.aesKey = ((HandOffFile)paramHandOff).aesKey;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).authKey).length() <= 0) {
          break label585;
        }
        i = 1;
        label385:
        if (i != 0) {
          this.authKey = ((HandOffFile)paramHandOff).authKey;
        }
        if (((HandOffFile)paramHandOff).fileStatus != 0) {
          this.fileStatus = ((HandOffFile)paramHandOff).fileStatus;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).appId).length() <= 0) {
          break label590;
        }
        i = 1;
        label441:
        if (i != 0) {
          this.appId = ((HandOffFile)paramHandOff).appId;
        }
        if (((HandOffFile)paramHandOff).sdkVersion != 0) {
          this.sdkVersion = ((HandOffFile)paramHandOff).sdkVersion;
        }
        if (((CharSequence)((HandOffFile)paramHandOff).mediaId).length() <= 0) {
          break label595;
        }
      }
    }
    label545:
    label550:
    label555:
    label560:
    label565:
    label570:
    label575:
    label580:
    label585:
    label590:
    label595:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      }
      if (((HandOffFile)paramHandOff).uploadedSize != 0L) {
        this.uploadedSize = ((HandOffFile)paramHandOff).uploadedSize;
      }
      bool1 = true;
      AppMethodBeat.o(266283);
      return bool1;
      i = 0;
      break;
      i = 0;
      break label96;
      i = 0;
      break label131;
      i = 0;
      break label166;
      i = 0;
      break label245;
      i = 0;
      break label280;
      i = 0;
      break label315;
      i = 0;
      break label350;
      i = 0;
      break label385;
      i = 0;
      break label441;
    }
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    s.u(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(getFullPath());
    paramParcel.writeString(getFileType());
    paramParcel.writeString(getTitle());
    paramParcel.writeString(getMd5());
    paramParcel.writeLong(getSize());
    paramParcel.writeInt(getSource());
    paramParcel.writeString(getSvrId());
    paramParcel.writeString(getExtId());
    paramParcel.writeString(getCdnURL());
    paramParcel.writeString(getAesKey());
    paramParcel.writeString(getAuthKey());
    paramParcel.writeInt(getFileStatus());
    paramParcel.writeString(getAppId());
    paramParcel.writeInt(getSdkVersion());
    paramParcel.writeString(getMediaId());
    paramParcel.writeLong(getUploadedSize());
    AppMethodBeat.o(121701);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "favId", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "fullpath", "fromMultiTask", "multiTaskInfo", "Lcom/tencent/mm/plugin/multitask/model/MultiTaskInfo;", "isSupportOpenFile", "", "fileExt", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static HandOffFile fromBallInfo(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      s.u(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.fy("handoff#fullPath", "");
      String str2 = paramBallInfo.fy("handoff#fileType", "");
      String str3 = paramBallInfo.fy("handoff#title", "");
      String str4 = paramBallInfo.fy("handoff#md5", "");
      long l1 = paramBallInfo.ahR("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.fy("handoff#svrId", "");
      String str6 = paramBallInfo.fy("handoff#extId", "");
      String str7 = paramBallInfo.fy("handoff#cdnURL", "");
      String str8 = paramBallInfo.fy("handoff#aesKey", "");
      String str9 = paramBallInfo.fy("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.fy("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.fy("handoff#KmediaId", "");
      long l2 = paramBallInfo.ahR("handoff#KUploadedSize");
      String str12 = paramBallInfo.fy("handoff#from", "");
      String str13 = paramBallInfo.fy("handoff#to", "");
      paramBallInfo = paramBallInfo.fy("handoff#key", "");
      s.s(str1, "fullPath");
      s.s(str2, "fileType");
      s.s(str3, "title");
      s.s(str4, "md5");
      s.s(str5, "svrId");
      s.s(str6, "extId");
      s.s(str7, "cdnURL");
      s.s(str8, "aesKey");
      s.s(str9, "authKey");
      s.s(str10, "appId");
      s.s(str11, "mediaId");
      s.s(str12, "from");
      s.s(str13, "to");
      s.s(paramBallInfo, "key");
      paramBallInfo = new HandOffFile(str1, str2, str3, str4, l1, i, str5, str6, str7, str8, str9, j, str10, k, str11, l2, 2, str12, str13, paramBallInfo);
      AppMethodBeat.o(121695);
      return paramBallInfo;
    }
    
    public static HandOffFile fromFavItem(arf paramarf, String paramString1, cc paramcc, String paramString2)
    {
      AppMethodBeat.i(266043);
      s.u(paramarf, "dataItem");
      String str7 = Util.nullAsNil(paramString2);
      String str8 = Util.nullAsNil(paramarf.ZyU);
      String str9 = Util.nullAsNil(paramarf.title);
      String str10 = Util.nullAsNil(paramarf.ZyW);
      long l = Util.nullAsNil(Long.valueOf(paramarf.Zza));
      String str4 = Util.nullAsNil(paramarf.Ysw);
      String str11 = Util.nullAsNil(paramarf.ZyH);
      String str12 = Util.nullAsNil(paramarf.nRn);
      String str5 = Util.nullAsNil(paramarf.ZzW);
      String str13 = Util.nullAsNil(paramarf.hIQ);
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
        s.s(str7, "fullPath");
        s.s(str8, "fileExt");
        s.s(str9, "fileName");
        s.s(str10, "fileMd5");
        s.s(str13, "extId");
        s.s(str4, "cdnURL");
        if (((CharSequence)str4).length() <= 0) {
          break label359;
        }
        j = 1;
        label188:
        if (j == 0) {
          break label365;
        }
      }
      label341:
      label359:
      label365:
      for (paramarf = str4;; paramarf = str5)
      {
        for (;;)
        {
          s.s(paramarf, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          s.s(str11, "aesKey");
          s.s(str12, "authKey");
          paramarf = new HandOffFile(str7, str8, str9, str10, l, i, paramString1, str13, paramarf, str11, str12, 1, "", 0, "", 0L, 1, paramString2, str2, null, 524288, null);
          AppMethodBeat.o(266043);
          return paramarf;
          paramString1 = str3;
          paramString2 = str1;
          str2 = str6;
          if (paramcc == null) {
            break;
          }
          i = 1;
          paramString2 = str3;
          try
          {
            paramString1 = String.valueOf(paramcc.field_msgSvrId);
            paramString2 = paramString1;
            paramarf = paramarf.Zzy.ZAf.hQQ;
            paramString2 = paramString1;
            s.s(paramarf, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramarf)
          {
            try
            {
              str2 = paramcc.field_talker;
              s.s(str2, "msg.talker");
              paramString2 = paramarf;
            }
            catch (Exception paramcc)
            {
              break label341;
            }
            paramarf = paramarf;
            paramarf = str1;
            paramString1 = paramString2;
          }
        }
        Log.w("HandOffService", "Get null from record msg, use default value");
        paramString2 = paramarf;
        str2 = str6;
        break;
        j = 0;
        break label188;
      }
    }
    
    public static HandOffFile fromMultiTask(MultiTaskInfo paramMultiTaskInfo)
    {
      AppMethodBeat.i(266066);
      if (paramMultiTaskInfo == null)
      {
        AppMethodBeat.o(266066);
        return null;
      }
      Object localObject1 = paramMultiTaskInfo.gkh();
      Object localObject2 = new asy();
      ((asy)localObject2).parseFrom(paramMultiTaskInfo.field_data);
      String str1 = Util.nullAsNil(((asy)localObject2).filePath);
      String str2 = Util.nullAsNil(((asy)localObject2).lPJ);
      localObject1 = Util.nullAsNil(((drz)localObject1).title);
      String str3 = Util.nullAsNil(((asy)localObject2).ZDk);
      long l1 = ((asy)localObject2).ZDy;
      int i = ((asy)localObject2).ZDl;
      String str4 = Util.nullAsNil(((asy)localObject2).ZDm);
      String str5 = Util.nullAsNil(((asy)localObject2).ZDn);
      String str6 = Util.nullAsNil(((asy)localObject2).ZDo);
      String str7 = Util.nullAsNil(((asy)localObject2).ZDp);
      String str8 = Util.nullAsNil(((asy)localObject2).ZDq);
      int j = ((asy)localObject2).ZDr;
      String str9 = Util.nullAsNil(((asy)localObject2).ZDs);
      int k = ((asy)localObject2).ZDt;
      String str10 = Util.nullAsNil(((asy)localObject2).ZDu);
      long l2 = ((asy)localObject2).ZDv;
      String str11 = Util.nullAsNil(((asy)localObject2).ZDw);
      localObject2 = Util.nullAsNil(((asy)localObject2).ZDx);
      paramMultiTaskInfo = Util.nullAsNil(paramMultiTaskInfo.field_id);
      s.s(str1, "fullPath");
      s.s(str2, "fileType");
      s.s(localObject1, "title");
      s.s(str3, "md5");
      s.s(str4, "svrId");
      s.s(str5, "extId");
      s.s(str6, "cdnURL");
      s.s(str7, "aesKey");
      s.s(str8, "authKey");
      s.s(str9, "appId");
      s.s(str10, "mediaId");
      s.s(str11, "from");
      s.s(localObject2, "to");
      s.s(paramMultiTaskInfo, "key");
      paramMultiTaskInfo = new HandOffFile(str1, str2, (String)localObject1, str3, l1, i, str4, str5, str6, str7, str8, j, str9, k, str10, l2, 2, str11, (String)localObject2, paramMultiTaskInfo);
      AppMethodBeat.o(266066);
      return paramMultiTaskInfo;
    }
    
    public static boolean isSupportOpenFile(String paramString)
    {
      AppMethodBeat.i(266074);
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(266074);
        return false;
      }
      if (n.U(paramString, ".", false)) {}
      while ((FileExplorerUI.brE(paramString)) || (FileExplorerUI.brD(paramString)) || (FileExplorerUI.brF(paramString)) || (FileExplorerUI.brG(paramString)))
      {
        AppMethodBeat.o(266074);
        return true;
        paramString = s.X(".", paramString);
      }
      AppMethodBeat.o(266074);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<HandOffFile>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */