package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.ajo;
import com.tencent.mm.protocal.protobuf.ajp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bu;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "getDataType", "toBallInfo", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffFile
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFile> CREATOR;
  public static final a uDR;
  public String appId;
  public int dnh;
  private String gjI;
  private String gjc;
  public String hdP;
  public String md5;
  public String mediaId;
  public int nNb;
  public long size;
  private String title;
  private String uDL;
  public String uDM;
  private String uDN;
  private String uDO;
  public int uDP;
  private long uDQ;
  
  static
  {
    AppMethodBeat.i(121708);
    uDR = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121708);
  }
  
  public HandOffFile(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121707);
    String str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.hdP = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.uDL = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.md5 = str;
    this.size = paramParcel.readLong();
    this.dnh = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.uDM = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.uDN = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.uDO = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.gjI = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.gjc = str;
    this.uDP = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.appId = str;
    this.nNb = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gfZ();
    }
    this.mediaId = str;
    this.uDQ = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13, String paramString14)
  {
    super(paramInt4, paramString12, paramString13, paramString14);
    AppMethodBeat.i(121705);
    this.hdP = paramString1;
    this.uDL = paramString2;
    this.title = paramString3;
    this.md5 = paramString4;
    this.size = paramLong1;
    this.dnh = paramInt1;
    this.uDM = paramString5;
    this.uDN = paramString6;
    this.uDO = paramString7;
    this.gjI = paramString8;
    this.gjc = paramString9;
    this.uDP = paramInt2;
    this.appId = paramString10;
    this.nNb = paramInt3;
    this.mediaId = paramString11;
    this.uDQ = paramLong2;
    AppMethodBeat.o(121705);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, 1, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public static final HandOffFile M(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121711);
    paramBallInfo = a.M(paramBallInfo);
    AppMethodBeat.o(121711);
    return paramBallInfo;
  }
  
  public static final HandOffFile a(ajn paramajn, g paramg, bu parambu)
  {
    AppMethodBeat.i(121709);
    paramajn = a.a(paramajn, paramg, parambu);
    AppMethodBeat.o(121709);
    return paramajn;
  }
  
  public static final HandOffFile b(ajn paramajn, g paramg)
  {
    AppMethodBeat.i(121710);
    paramajn = a.a(paramajn, paramg, null);
    AppMethodBeat.o(121710);
    return paramajn;
  }
  
  public final void L(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121702);
    p.h(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.ey("handoff#fullPath", this.hdP);
      paramBallInfo.ey("handoff#fileType", this.uDL);
      paramBallInfo.ey("handoff#title", this.title);
      paramBallInfo.ey("handoff#md5", this.md5);
      paramBallInfo.Y("handoff#size", this.size);
      paramBallInfo.cn("handoff#source", this.dnh);
      paramBallInfo.ey("handoff#svrId", this.uDM);
      paramBallInfo.ey("handoff#extId", this.uDN);
      paramBallInfo.ey("handoff#cdnURL", this.uDO);
      paramBallInfo.ey("handoff#aesKey", this.gjI);
      paramBallInfo.ey("handoff#authKey", this.gjc);
      paramBallInfo.cn("handoff#fileStatus", this.uDP);
      paramBallInfo.ey("handoff#appId", this.appId);
      paramBallInfo.cn("handoff#sdkVersion", this.nNb);
      paramBallInfo.ey("handoff#KmediaId", this.mediaId);
      paramBallInfo.Y("handoff#KUploadedSize", this.uDQ);
      paramBallInfo.ey("handoff#from", this.dET);
      paramBallInfo.ey("handoff#to", this.hEw);
      paramBallInfo.ey("handoff#key", this.key);
      AppMethodBeat.o(121702);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(121702);
    }
  }
  
  public final void ane(String paramString)
  {
    AppMethodBeat.i(121696);
    p.h(paramString, "<set-?>");
    this.hdP = paramString;
    AppMethodBeat.o(121696);
  }
  
  public final void anf(String paramString)
  {
    AppMethodBeat.i(121697);
    p.h(paramString, "<set-?>");
    this.uDO = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void ang(String paramString)
  {
    AppMethodBeat.i(121698);
    p.h(paramString, "<set-?>");
    this.gjI = paramString;
    AppMethodBeat.o(121698);
  }
  
  protected final String dbM()
  {
    AppMethodBeat.i(121700);
    String str = n.bdc("\n        <filetype>" + a.dl(this.uDL) + "</filetype>\n        <title>" + a.dl(this.title) + "</title>\n        <md5>" + a.dl(this.md5) + "</md5>\n        <uploadedsize>" + a.dl(Long.valueOf(this.uDQ)) + "</uploadedsize>\n        <size>" + a.dl(Long.valueOf(this.size)) + "</size>\n        <source>" + a.dl(Integer.valueOf(this.dnh)) + "</source>\n        <id>" + a.dl(this.uDM) + "</id>\n        <extid>" + a.dl(this.uDN) + "</extid>\n        <cdnurl>" + a.dl(this.uDO) + "</cdnurl>\n        <aeskey>" + a.dl(this.gjI) + "</aeskey>\n        <authkey>" + a.dl(this.gjc) + "</authkey>\n        <filestatus>" + a.dl(Integer.valueOf(this.uDP)) + "</filestatus>\n        <appid>" + a.dl(this.appId) + "</appid>\n        <sdkversion>" + a.dl(Integer.valueOf(this.nNb)) + "</sdkversion>\n        <mediaid>" + a.dl(this.mediaId) + "</mediaid>\n    ");
    AppMethodBeat.o(121700);
    return str;
  }
  
  public final HandOff dbN()
  {
    AppMethodBeat.i(121703);
    Object localObject = new HandOffFile(this.hdP, this.uDL, this.title, this.md5, this.size, this.dnh, this.uDM, this.uDN, this.uDO, this.gjI, this.gjc, this.uDP, this.appId, this.nNb, this.mediaId, this.uDQ, this.uDJ, this.dET, this.hEw, this.key);
    ((HandOffFile)localObject).setId(this.id);
    localObject = (HandOff)localObject;
    AppMethodBeat.o(121703);
    return localObject;
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final int getDataType()
  {
    return 1;
  }
  
  public final void j(HandOff paramHandOff)
  {
    AppMethodBeat.i(121699);
    p.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffFile))
    {
      this.hdP = ((HandOffFile)paramHandOff).hdP;
      this.uDL = ((HandOffFile)paramHandOff).uDL;
      this.title = ((HandOffFile)paramHandOff).title;
      this.md5 = ((HandOffFile)paramHandOff).md5;
      this.size = ((HandOffFile)paramHandOff).size;
      this.dnh = ((HandOffFile)paramHandOff).dnh;
      this.uDM = ((HandOffFile)paramHandOff).uDM;
      this.uDN = ((HandOffFile)paramHandOff).uDN;
      this.uDO = ((HandOffFile)paramHandOff).uDO;
      this.gjI = ((HandOffFile)paramHandOff).gjI;
      this.gjc = ((HandOffFile)paramHandOff).gjc;
      this.uDP = ((HandOffFile)paramHandOff).uDP;
      this.appId = ((HandOffFile)paramHandOff).appId;
      this.nNb = ((HandOffFile)paramHandOff).nNb;
      this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      this.uDQ = ((HandOffFile)paramHandOff).uDQ;
    }
    AppMethodBeat.o(121699);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    String str = "HandOffFile(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", fullPath='" + this.hdP + "', fileType='" + this.uDL + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.dnh + ", svrId='" + this.uDM + "', extId='" + this.uDN + "', cdnURL='" + this.uDO + "', aesKey='" + this.gjI + "', authKey='" + this.gjc + "', fileStatus=" + this.uDP + ", appId='" + this.appId + "', sdkVersion=" + this.nNb + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.uDQ + ')';
    AppMethodBeat.o(121704);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hdP);
    paramParcel.writeString(this.uDL);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.dnh);
    paramParcel.writeString(this.uDM);
    paramParcel.writeString(this.uDN);
    paramParcel.writeString(this.uDO);
    paramParcel.writeString(this.gjI);
    paramParcel.writeString(this.gjc);
    paramParcel.writeInt(this.uDP);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.nNb);
    paramParcel.writeString(this.mediaId);
    paramParcel.writeLong(this.uDQ);
    AppMethodBeat.o(121701);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "api-handoff_release"})
  public static final class a
  {
    public static HandOffFile M(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      p.h(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.ez("handoff#fullPath", "");
      String str2 = paramBallInfo.ez("handoff#fileType", "");
      String str3 = paramBallInfo.ez("handoff#title", "");
      String str4 = paramBallInfo.ez("handoff#md5", "");
      long l1 = paramBallInfo.Wj("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.ez("handoff#svrId", "");
      String str6 = paramBallInfo.ez("handoff#extId", "");
      String str7 = paramBallInfo.ez("handoff#cdnURL", "");
      String str8 = paramBallInfo.ez("handoff#aesKey", "");
      String str9 = paramBallInfo.ez("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.ez("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.ez("handoff#KmediaId", "");
      long l2 = paramBallInfo.Wj("handoff#KUploadedSize");
      String str12 = paramBallInfo.ez("handoff#from", "");
      String str13 = paramBallInfo.ez("handoff#to", "");
      paramBallInfo = paramBallInfo.ez("handoff#key", "");
      p.g(str1, "fullPath");
      p.g(str2, "fileType");
      p.g(str3, "title");
      p.g(str4, "md5");
      p.g(str5, "svrId");
      p.g(str6, "extId");
      p.g(str7, "cdnURL");
      p.g(str8, "aesKey");
      p.g(str9, "authKey");
      p.g(str10, "appId");
      p.g(str11, "mediaId");
      p.g(str12, "from");
      p.g(str13, "to");
      p.g(paramBallInfo, "key");
      paramBallInfo = new HandOffFile(str1, str2, str3, str4, l1, i, str5, str6, str7, str8, str9, j, str10, k, str11, l2, 2, str12, str13, paramBallInfo);
      AppMethodBeat.o(121695);
      return paramBallInfo;
    }
    
    public static HandOffFile a(ajn paramajn, g paramg, bu parambu)
    {
      AppMethodBeat.i(121694);
      p.h(paramajn, "dataItem");
      String str7 = bt.nullAsNil(b.d(paramajn));
      String str8 = bt.nullAsNil(paramajn.fgE());
      String str9 = bt.nullAsNil(paramajn.getTitle());
      String str10 = bt.nullAsNil(paramajn.fgF());
      long l = bt.g(Long.valueOf(paramajn.fgG()));
      String str4 = bt.nullAsNil(paramajn.fgC());
      String str11 = bt.nullAsNil(paramajn.fgD());
      String str12 = bt.nullAsNil(paramajn.fgJ());
      String str5 = bt.nullAsNil(paramajn.fgK());
      String str13 = bt.nullAsNil(paramajn.fgH());
      String str3 = "";
      int i = 3;
      String str1 = "";
      String str6 = "";
      String str2;
      Object localObject;
      int j;
      if (paramg != null)
      {
        i = 2;
        paramg = String.valueOf(paramg.field_id);
        str2 = str6;
        localObject = str1;
        p.g(str7, "fullPath");
        p.g(str8, "fileExt");
        p.g(str9, "fileName");
        p.g(str10, "fileMd5");
        p.g(str13, "extId");
        p.g(str4, "cdnURL");
        if (((CharSequence)str4).length() <= 0) {
          break label397;
        }
        j = 1;
        label198:
        if (j == 0) {
          break label403;
        }
      }
      label397:
      label403:
      for (paramajn = str4;; paramajn = str5)
      {
        for (;;)
        {
          p.g(paramajn, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          p.g(str11, "aesKey");
          p.g(str12, "authKey");
          paramajn = new HandOffFile(str7, str8, str9, str10, l, i, paramg, str13, paramajn, str11, str12, "", "", (String)localObject, str2);
          AppMethodBeat.o(121694);
          return paramajn;
          paramg = str3;
          localObject = str1;
          str2 = str6;
          if (parambu == null) {
            break;
          }
          i = 1;
          localObject = str3;
          try
          {
            paramg = String.valueOf(parambu.VQ());
            localObject = paramg;
            paramajn = paramajn.fgI();
            localObject = paramg;
            p.g(paramajn, "dataItem.dataProtoItem");
            localObject = paramg;
            paramajn = paramajn.fgL();
            localObject = paramg;
            p.g(paramajn, "dataItem.dataProtoItem.dataSourceItem");
            localObject = paramg;
            paramajn = paramajn.fgM();
            localObject = paramg;
            p.g(paramajn, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramajn)
          {
            try
            {
              str2 = parambu.VS();
              p.g(str2, "msg.talker");
              localObject = paramajn;
            }
            catch (Exception parambu)
            {
              break label378;
            }
            paramajn = paramajn;
            paramajn = str1;
            paramg = (g)localObject;
          }
        }
        label378:
        ad.w("HandOffService", "Get null from record msg, use default value");
        localObject = paramajn;
        str2 = str6;
        break;
        j = 0;
        break label198;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffFile>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */