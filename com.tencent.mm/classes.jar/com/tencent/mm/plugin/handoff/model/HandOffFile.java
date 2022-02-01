package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.protocal.protobuf.ajy;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bv;
import d.g.b.p;
import d.l;
import d.n.n;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "getDataType", "toBallInfo", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffFile
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFile> CREATOR;
  public static final a uPw;
  public String appId;
  public int doj;
  private String glu;
  private String gmb;
  public String hgD;
  public String md5;
  public String mediaId;
  public int nSG;
  public long size;
  private String title;
  private String uPq;
  public String uPr;
  private String uPs;
  private String uPt;
  public int uPu;
  private long uPv;
  
  static
  {
    AppMethodBeat.i(121708);
    uPw = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121708);
  }
  
  public HandOffFile(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121707);
    String str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.hgD = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.uPq = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.title = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.md5 = str;
    this.size = paramParcel.readLong();
    this.doj = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.uPr = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.uPs = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.uPt = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.gmb = str;
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.glu = str;
    this.uPu = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.appId = str;
    this.nSG = paramParcel.readInt();
    str = paramParcel.readString();
    if (str == null) {
      p.gkB();
    }
    this.mediaId = str;
    this.uPv = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13, String paramString14)
  {
    super(paramInt4, paramString12, paramString13, paramString14);
    AppMethodBeat.i(121705);
    this.hgD = paramString1;
    this.uPq = paramString2;
    this.title = paramString3;
    this.md5 = paramString4;
    this.size = paramLong1;
    this.doj = paramInt1;
    this.uPr = paramString5;
    this.uPs = paramString6;
    this.uPt = paramString7;
    this.gmb = paramString8;
    this.glu = paramString9;
    this.uPu = paramInt2;
    this.appId = paramString10;
    this.nSG = paramInt3;
    this.mediaId = paramString11;
    this.uPv = paramLong2;
    AppMethodBeat.o(121705);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, 1, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public static final HandOffFile O(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121711);
    paramBallInfo = a.O(paramBallInfo);
    AppMethodBeat.o(121711);
    return paramBallInfo;
  }
  
  public static final HandOffFile a(ajx paramajx, g paramg, bv parambv)
  {
    AppMethodBeat.i(121709);
    paramajx = a.a(paramajx, paramg, parambv);
    AppMethodBeat.o(121709);
    return paramajx;
  }
  
  public static final HandOffFile b(ajx paramajx, g paramg)
  {
    AppMethodBeat.i(121710);
    paramajx = a.a(paramajx, paramg, null);
    AppMethodBeat.o(121710);
    return paramajx;
  }
  
  public final void N(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121702);
    p.h(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.eB("handoff#fullPath", this.hgD);
      paramBallInfo.eB("handoff#fileType", this.uPq);
      paramBallInfo.eB("handoff#title", this.title);
      paramBallInfo.eB("handoff#md5", this.md5);
      paramBallInfo.Y("handoff#size", this.size);
      paramBallInfo.cr("handoff#source", this.doj);
      paramBallInfo.eB("handoff#svrId", this.uPr);
      paramBallInfo.eB("handoff#extId", this.uPs);
      paramBallInfo.eB("handoff#cdnURL", this.uPt);
      paramBallInfo.eB("handoff#aesKey", this.gmb);
      paramBallInfo.eB("handoff#authKey", this.glu);
      paramBallInfo.cr("handoff#fileStatus", this.uPu);
      paramBallInfo.eB("handoff#appId", this.appId);
      paramBallInfo.cr("handoff#sdkVersion", this.nSG);
      paramBallInfo.eB("handoff#KmediaId", this.mediaId);
      paramBallInfo.Y("handoff#KUploadedSize", this.uPv);
      paramBallInfo.eB("handoff#from", this.dFY);
      paramBallInfo.eB("handoff#to", this.hHo);
      paramBallInfo.eB("handoff#key", this.key);
      AppMethodBeat.o(121702);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(121702);
    }
  }
  
  public final void aof(String paramString)
  {
    AppMethodBeat.i(121696);
    p.h(paramString, "<set-?>");
    this.hgD = paramString;
    AppMethodBeat.o(121696);
  }
  
  public final void aog(String paramString)
  {
    AppMethodBeat.i(121697);
    p.h(paramString, "<set-?>");
    this.uPt = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void aoh(String paramString)
  {
    AppMethodBeat.i(121698);
    p.h(paramString, "<set-?>");
    this.gmb = paramString;
    AppMethodBeat.o(121698);
  }
  
  protected final String deD()
  {
    AppMethodBeat.i(121700);
    String str = n.beG("\n        <filetype>" + a.dm(this.uPq) + "</filetype>\n        <title>" + a.dm(this.title) + "</title>\n        <md5>" + a.dm(this.md5) + "</md5>\n        <uploadedsize>" + a.dm(Long.valueOf(this.uPv)) + "</uploadedsize>\n        <size>" + a.dm(Long.valueOf(this.size)) + "</size>\n        <source>" + a.dm(Integer.valueOf(this.doj)) + "</source>\n        <id>" + a.dm(this.uPr) + "</id>\n        <extid>" + a.dm(this.uPs) + "</extid>\n        <cdnurl>" + a.dm(this.uPt) + "</cdnurl>\n        <aeskey>" + a.dm(this.gmb) + "</aeskey>\n        <authkey>" + a.dm(this.glu) + "</authkey>\n        <filestatus>" + a.dm(Integer.valueOf(this.uPu)) + "</filestatus>\n        <appid>" + a.dm(this.appId) + "</appid>\n        <sdkversion>" + a.dm(Integer.valueOf(this.nSG)) + "</sdkversion>\n        <mediaid>" + a.dm(this.mediaId) + "</mediaid>\n    ");
    AppMethodBeat.o(121700);
    return str;
  }
  
  public final HandOff deE()
  {
    AppMethodBeat.i(121703);
    Object localObject = new HandOffFile(this.hgD, this.uPq, this.title, this.md5, this.size, this.doj, this.uPr, this.uPs, this.uPt, this.gmb, this.glu, this.uPu, this.appId, this.nSG, this.mediaId, this.uPv, this.uPo, this.dFY, this.hHo, this.key);
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
  
  public final void k(HandOff paramHandOff)
  {
    AppMethodBeat.i(121699);
    p.h(paramHandOff, "newHandOff");
    super.k(paramHandOff);
    if ((paramHandOff instanceof HandOffFile))
    {
      this.hgD = ((HandOffFile)paramHandOff).hgD;
      this.uPq = ((HandOffFile)paramHandOff).uPq;
      this.title = ((HandOffFile)paramHandOff).title;
      this.md5 = ((HandOffFile)paramHandOff).md5;
      this.size = ((HandOffFile)paramHandOff).size;
      this.doj = ((HandOffFile)paramHandOff).doj;
      this.uPr = ((HandOffFile)paramHandOff).uPr;
      this.uPs = ((HandOffFile)paramHandOff).uPs;
      this.uPt = ((HandOffFile)paramHandOff).uPt;
      this.gmb = ((HandOffFile)paramHandOff).gmb;
      this.glu = ((HandOffFile)paramHandOff).glu;
      this.uPu = ((HandOffFile)paramHandOff).uPu;
      this.appId = ((HandOffFile)paramHandOff).appId;
      this.nSG = ((HandOffFile)paramHandOff).nSG;
      this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      this.uPv = ((HandOffFile)paramHandOff).uPv;
    }
    AppMethodBeat.o(121699);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    String str = "HandOffFile(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", fullPath='" + this.hgD + "', fileType='" + this.uPq + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.doj + ", svrId='" + this.uPr + "', extId='" + this.uPs + "', cdnURL='" + this.uPt + "', aesKey='" + this.gmb + "', authKey='" + this.glu + "', fileStatus=" + this.uPu + ", appId='" + this.appId + "', sdkVersion=" + this.nSG + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.uPv + ')';
    AppMethodBeat.o(121704);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    p.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.hgD);
    paramParcel.writeString(this.uPq);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.doj);
    paramParcel.writeString(this.uPr);
    paramParcel.writeString(this.uPs);
    paramParcel.writeString(this.uPt);
    paramParcel.writeString(this.gmb);
    paramParcel.writeString(this.glu);
    paramParcel.writeInt(this.uPu);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.nSG);
    paramParcel.writeString(this.mediaId);
    paramParcel.writeLong(this.uPv);
    AppMethodBeat.o(121701);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "api-handoff_release"})
  public static final class a
  {
    public static HandOffFile O(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      p.h(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.eC("handoff#fullPath", "");
      String str2 = paramBallInfo.eC("handoff#fileType", "");
      String str3 = paramBallInfo.eC("handoff#title", "");
      String str4 = paramBallInfo.eC("handoff#md5", "");
      long l1 = paramBallInfo.WV("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.eC("handoff#svrId", "");
      String str6 = paramBallInfo.eC("handoff#extId", "");
      String str7 = paramBallInfo.eC("handoff#cdnURL", "");
      String str8 = paramBallInfo.eC("handoff#aesKey", "");
      String str9 = paramBallInfo.eC("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.eC("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.eC("handoff#KmediaId", "");
      long l2 = paramBallInfo.WV("handoff#KUploadedSize");
      String str12 = paramBallInfo.eC("handoff#from", "");
      String str13 = paramBallInfo.eC("handoff#to", "");
      paramBallInfo = paramBallInfo.eC("handoff#key", "");
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
    
    public static HandOffFile a(ajx paramajx, g paramg, bv parambv)
    {
      AppMethodBeat.i(121694);
      p.h(paramajx, "dataItem");
      String str7 = bu.nullAsNil(b.d(paramajx));
      String str8 = bu.nullAsNil(paramajx.fku());
      String str9 = bu.nullAsNil(paramajx.getTitle());
      String str10 = bu.nullAsNil(paramajx.fkv());
      long l = bu.i(Long.valueOf(paramajx.fkw()));
      String str4 = bu.nullAsNil(paramajx.fks());
      String str11 = bu.nullAsNil(paramajx.fkt());
      String str12 = bu.nullAsNil(paramajx.fkA());
      String str5 = bu.nullAsNil(paramajx.fkB());
      String str13 = bu.nullAsNil(paramajx.fkx());
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
      for (paramajx = str4;; paramajx = str5)
      {
        for (;;)
        {
          p.g(paramajx, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          p.g(str11, "aesKey");
          p.g(str12, "authKey");
          paramajx = new HandOffFile(str7, str8, str9, str10, l, i, paramg, str13, paramajx, str11, str12, "", "", (String)localObject, str2);
          AppMethodBeat.o(121694);
          return paramajx;
          paramg = str3;
          localObject = str1;
          str2 = str6;
          if (parambv == null) {
            break;
          }
          i = 1;
          localObject = str3;
          try
          {
            paramg = String.valueOf(parambv.VY());
            localObject = paramg;
            paramajx = paramajx.fky();
            localObject = paramg;
            p.g(paramajx, "dataItem.dataProtoItem");
            localObject = paramg;
            paramajx = paramajx.fkC();
            localObject = paramg;
            p.g(paramajx, "dataItem.dataProtoItem.dataSourceItem");
            localObject = paramg;
            paramajx = paramajx.fkD();
            localObject = paramg;
            p.g(paramajx, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramajx)
          {
            try
            {
              str2 = parambv.Wa();
              p.g(str2, "msg.talker");
              localObject = paramajx;
            }
            catch (Exception parambv)
            {
              break label378;
            }
            paramajx = paramajx;
            paramajx = str1;
            paramg = (g)localObject;
          }
        }
        label378:
        ae.w("HandOffService", "Get null from record msg, use default value");
        localObject = paramajx;
        str2 = str6;
        break;
        j = 0;
        break label198;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffFile>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */