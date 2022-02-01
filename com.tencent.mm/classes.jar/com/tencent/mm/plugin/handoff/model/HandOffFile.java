package com.tencent.mm.plugin.handoff.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.afz;
import com.tencent.mm.protocal.protobuf.aga;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bl;
import d.g.b.k;
import d.l;
import d.n.n;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "fullPath", "", "fileType", "title", "md5", "size", "", "source", "", "svrId", "extId", "cdnURL", "aesKey", "authKey", "fileStatus", "appId", "sdkVersion", "mediaId", "uploadedSize", "handOffType", "from", "to", "key", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;JILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAesKey", "()Ljava/lang/String;", "setAesKey", "(Ljava/lang/String;)V", "getAppId", "setAppId", "getAuthKey", "setAuthKey", "getCdnURL", "setCdnURL", "getExtId", "setExtId", "getFileStatus", "()I", "setFileStatus", "(I)V", "getFileType", "setFileType", "getFullPath", "setFullPath", "getMd5", "setMd5", "getMediaId", "setMediaId", "getSdkVersion", "setSdkVersion", "getSize", "()J", "setSize", "(J)V", "getSource", "setSource", "getSvrId", "setSvrId", "getTitle", "setTitle", "getUploadedSize", "setUploadedSize", "body", "copy", "describeContents", "getDataType", "toBallInfo", "", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "toString", "update", "newHandOff", "writeToParcel", "dest", "flags", "Companion", "api-handoff_release"})
public final class HandOffFile
  extends HandOff
{
  public static final Parcelable.Creator<HandOffFile> CREATOR;
  public static final a sts;
  public String appId;
  public int dep;
  private String fLQ;
  private String fMw;
  public String gjt;
  public int mKl;
  public String md5;
  public String mediaId;
  public long size;
  private String stm;
  public String stn;
  private String sto;
  private String stp;
  public int stq;
  private long str;
  private String title;
  
  static
  {
    AppMethodBeat.i(121708);
    sts = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(121708);
  }
  
  public HandOffFile(Parcel paramParcel)
  {
    super(paramParcel);
    AppMethodBeat.i(121707);
    String str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.gjt = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.stm = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.title = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.md5 = str1;
    this.size = paramParcel.readLong();
    this.dep = paramParcel.readInt();
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.stn = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.sto = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.stp = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.fMw = str1;
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.fLQ = str1;
    this.stq = paramParcel.readInt();
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.appId = str1;
    this.mKl = paramParcel.readInt();
    str1 = paramParcel.readString();
    if (str1 == null) {
      k.fvU();
    }
    this.mediaId = str1;
    this.str = paramParcel.readLong();
    AppMethodBeat.o(121707);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong1, int paramInt1, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, int paramInt2, String paramString10, int paramInt3, String paramString11, long paramLong2, int paramInt4, String paramString12, String paramString13, String paramString14)
  {
    super(paramInt4, paramString12, paramString13, paramString14);
    AppMethodBeat.i(121705);
    this.gjt = paramString1;
    this.stm = paramString2;
    this.title = paramString3;
    this.md5 = paramString4;
    this.size = paramLong1;
    this.dep = paramInt1;
    this.stn = paramString5;
    this.sto = paramString6;
    this.stp = paramString7;
    this.fMw = paramString8;
    this.fLQ = paramString9;
    this.stq = paramInt2;
    this.appId = paramString10;
    this.mKl = paramInt3;
    this.mediaId = paramString11;
    this.str = paramLong2;
    AppMethodBeat.o(121705);
  }
  
  public HandOffFile(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13)
  {
    this(paramString1, paramString2, paramString3, paramString4, paramLong, 1, paramString5, paramString6, paramString7, paramString8, paramString9, paramString10, paramString11, paramString12, paramString13);
  }
  
  public static final HandOffFile L(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121711);
    paramBallInfo = a.L(paramBallInfo);
    AppMethodBeat.o(121711);
    return paramBallInfo;
  }
  
  public static final HandOffFile a(afy paramafy, g paramg, bl parambl)
  {
    AppMethodBeat.i(121709);
    paramafy = a.a(paramafy, paramg, parambl);
    AppMethodBeat.o(121709);
    return paramafy;
  }
  
  public static final HandOffFile b(afy paramafy, g paramg)
  {
    AppMethodBeat.i(121710);
    paramafy = a.a(paramafy, paramg, null);
    AppMethodBeat.o(121710);
    return paramafy;
  }
  
  public final void K(BallInfo paramBallInfo)
  {
    AppMethodBeat.i(121702);
    k.h(paramBallInfo, "ballInfo");
    try
    {
      paramBallInfo.ed("handoff#fullPath", this.gjt);
      paramBallInfo.ed("handoff#fileType", this.stm);
      paramBallInfo.ed("handoff#title", this.title);
      paramBallInfo.ed("handoff#md5", this.md5);
      paramBallInfo.Q("handoff#size", this.size);
      paramBallInfo.cf("handoff#source", this.dep);
      paramBallInfo.ed("handoff#svrId", this.stn);
      paramBallInfo.ed("handoff#extId", this.sto);
      paramBallInfo.ed("handoff#cdnURL", this.stp);
      paramBallInfo.ed("handoff#aesKey", this.fMw);
      paramBallInfo.ed("handoff#authKey", this.fLQ);
      paramBallInfo.cf("handoff#fileStatus", this.stq);
      paramBallInfo.ed("handoff#appId", this.appId);
      paramBallInfo.cf("handoff#sdkVersion", this.mKl);
      paramBallInfo.ed("handoff#KmediaId", this.mediaId);
      paramBallInfo.Q("handoff#KUploadedSize", this.str);
      paramBallInfo.ed("handoff#from", this.dvh);
      paramBallInfo.ed("handoff#to", this.gLJ);
      paramBallInfo.ed("handoff#key", this.key);
      AppMethodBeat.o(121702);
      return;
    }
    catch (Exception paramBallInfo)
    {
      AppMethodBeat.o(121702);
    }
  }
  
  public final void adA(String paramString)
  {
    AppMethodBeat.i(121697);
    k.h(paramString, "<set-?>");
    this.stp = paramString;
    AppMethodBeat.o(121697);
  }
  
  public final void adB(String paramString)
  {
    AppMethodBeat.i(121698);
    k.h(paramString, "<set-?>");
    this.fMw = paramString;
    AppMethodBeat.o(121698);
  }
  
  public final void adz(String paramString)
  {
    AppMethodBeat.i(121696);
    k.h(paramString, "<set-?>");
    this.gjt = paramString;
    AppMethodBeat.o(121696);
  }
  
  protected final String cFv()
  {
    AppMethodBeat.i(121700);
    String str1 = n.aRa("\n        <filetype>" + a.dg(this.stm) + "</filetype>\n        <title>" + a.dg(this.title) + "</title>\n        <md5>" + a.dg(this.md5) + "</md5>\n        <uploadedsize>" + a.dg(Long.valueOf(this.str)) + "</uploadedsize>\n        <size>" + a.dg(Long.valueOf(this.size)) + "</size>\n        <source>" + a.dg(Integer.valueOf(this.dep)) + "</source>\n        <id>" + a.dg(this.stn) + "</id>\n        <extid>" + a.dg(this.sto) + "</extid>\n        <cdnurl>" + a.dg(this.stp) + "</cdnurl>\n        <aeskey>" + a.dg(this.fMw) + "</aeskey>\n        <authkey>" + a.dg(this.fLQ) + "</authkey>\n        <filestatus>" + a.dg(Integer.valueOf(this.stq)) + "</filestatus>\n        <appid>" + a.dg(this.appId) + "</appid>\n        <sdkversion>" + a.dg(Integer.valueOf(this.mKl)) + "</sdkversion>\n        <mediaid>" + a.dg(this.mediaId) + "</mediaid>\n    ");
    AppMethodBeat.o(121700);
    return str1;
  }
  
  public final HandOff cFw()
  {
    AppMethodBeat.i(121703);
    Object localObject = new HandOffFile(this.gjt, this.stm, this.title, this.md5, this.size, this.dep, this.stn, this.sto, this.stp, this.fMw, this.fLQ, this.stq, this.appId, this.mKl, this.mediaId, this.str, this.stk, this.dvh, this.gLJ, this.key);
    ((HandOffFile)localObject).Zm(this.id);
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
    k.h(paramHandOff, "newHandOff");
    super.j(paramHandOff);
    if ((paramHandOff instanceof HandOffFile))
    {
      this.gjt = ((HandOffFile)paramHandOff).gjt;
      this.stm = ((HandOffFile)paramHandOff).stm;
      this.title = ((HandOffFile)paramHandOff).title;
      this.md5 = ((HandOffFile)paramHandOff).md5;
      this.size = ((HandOffFile)paramHandOff).size;
      this.dep = ((HandOffFile)paramHandOff).dep;
      this.stn = ((HandOffFile)paramHandOff).stn;
      this.sto = ((HandOffFile)paramHandOff).sto;
      this.stp = ((HandOffFile)paramHandOff).stp;
      this.fMw = ((HandOffFile)paramHandOff).fMw;
      this.fLQ = ((HandOffFile)paramHandOff).fLQ;
      this.stq = ((HandOffFile)paramHandOff).stq;
      this.appId = ((HandOffFile)paramHandOff).appId;
      this.mKl = ((HandOffFile)paramHandOff).mKl;
      this.mediaId = ((HandOffFile)paramHandOff).mediaId;
      this.str = ((HandOffFile)paramHandOff).str;
    }
    AppMethodBeat.o(121699);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(121704);
    String str1 = "HandOffFile(key='" + this.key + "', id='" + this.id + "', createTime='" + this.createTime + ", fullPath='" + this.gjt + "', fileType='" + this.stm + "', title='" + this.title + "', md5='" + this.md5 + "', size=" + this.size + ", source=" + this.dep + ", svrId='" + this.stn + "', extId='" + this.sto + "', cdnURL='" + this.stp + "', aesKey='" + this.fMw + "', authKey='" + this.fLQ + "', fileStatus=" + this.stq + ", appId='" + this.appId + "', sdkVersion=" + this.mKl + ", mediaId='" + this.mediaId + "', uploadedSize=" + this.str + ')';
    AppMethodBeat.o(121704);
    return str1;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(121701);
    k.h(paramParcel, "dest");
    super.writeToParcel(paramParcel, paramInt);
    paramParcel.writeString(this.gjt);
    paramParcel.writeString(this.stm);
    paramParcel.writeString(this.title);
    paramParcel.writeString(this.md5);
    paramParcel.writeLong(this.size);
    paramParcel.writeInt(this.dep);
    paramParcel.writeString(this.stn);
    paramParcel.writeString(this.sto);
    paramParcel.writeString(this.stp);
    paramParcel.writeString(this.fMw);
    paramParcel.writeString(this.fLQ);
    paramParcel.writeInt(this.stq);
    paramParcel.writeString(this.appId);
    paramParcel.writeInt(this.mKl);
    paramParcel.writeString(this.mediaId);
    paramParcel.writeLong(this.str);
    AppMethodBeat.o(121701);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/handoff/model/HandOffFile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "KAesKey", "", "KAppId", "KAuthKey", "KCdnURL", "KExtId", "KFileStatus", "KFileType", "KFrom", "KFullPath", "KKey", "KMd5", "KMediaId", "KSdkVersion", "KSize", "KSource", "KSvrId", "KTitle", "KTo", "KUploadedSize", "fromBallInfo", "ballInfo", "Lcom/tencent/mm/plugin/ball/model/BallInfo;", "fromFavItem", "dataItem", "Lcom/tencent/mm/protocal/protobuf/FavDataItem;", "itemInfo", "Lcom/tencent/mm/plugin/fav/api/FavItemInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "api-handoff_release"})
  public static final class a
  {
    public static HandOffFile L(BallInfo paramBallInfo)
    {
      AppMethodBeat.i(121695);
      k.h(paramBallInfo, "ballInfo");
      String str1 = paramBallInfo.ee("handoff#fullPath", "");
      String str2 = paramBallInfo.ee("handoff#fileType", "");
      String str3 = paramBallInfo.ee("handoff#title", "");
      String str4 = paramBallInfo.ee("handoff#md5", "");
      long l1 = paramBallInfo.OB("handoff#size");
      int i = paramBallInfo.getIntExtra("handoff#source", 0);
      String str5 = paramBallInfo.ee("handoff#svrId", "");
      String str6 = paramBallInfo.ee("handoff#extId", "");
      String str7 = paramBallInfo.ee("handoff#cdnURL", "");
      String str8 = paramBallInfo.ee("handoff#aesKey", "");
      String str9 = paramBallInfo.ee("handoff#authKey", "");
      int j = paramBallInfo.getIntExtra("handoff#fileStatus", 0);
      String str10 = paramBallInfo.ee("handoff#appId", "");
      int k = paramBallInfo.getIntExtra("handoff#sdkVersion", 0);
      String str11 = paramBallInfo.ee("handoff#KmediaId", "");
      long l2 = paramBallInfo.OB("handoff#KUploadedSize");
      String str12 = paramBallInfo.ee("handoff#from", "");
      String str13 = paramBallInfo.ee("handoff#to", "");
      paramBallInfo = paramBallInfo.ee("handoff#key", "");
      k.g(str1, "fullPath");
      k.g(str2, "fileType");
      k.g(str3, "title");
      k.g(str4, "md5");
      k.g(str5, "svrId");
      k.g(str6, "extId");
      k.g(str7, "cdnURL");
      k.g(str8, "aesKey");
      k.g(str9, "authKey");
      k.g(str10, "appId");
      k.g(str11, "mediaId");
      k.g(str12, "from");
      k.g(str13, "to");
      k.g(paramBallInfo, "key");
      paramBallInfo = new HandOffFile(str1, str2, str3, str4, l1, i, str5, str6, str7, str8, str9, j, str10, k, str11, l2, 2, str12, str13, paramBallInfo);
      AppMethodBeat.o(121695);
      return paramBallInfo;
    }
    
    public static HandOffFile a(afy paramafy, g paramg, bl parambl)
    {
      AppMethodBeat.i(121694);
      k.h(paramafy, "dataItem");
      String str7 = bt.nullAsNil(b.d(paramafy));
      String str8 = bt.nullAsNil(paramafy.eCf());
      String str9 = bt.nullAsNil(paramafy.getTitle());
      String str10 = bt.nullAsNil(paramafy.eCg());
      long l = bt.f(Long.valueOf(paramafy.eCh()));
      String str4 = bt.nullAsNil(paramafy.eCd());
      String str11 = bt.nullAsNil(paramafy.eCe());
      String str12 = bt.nullAsNil(paramafy.eCk());
      String str5 = bt.nullAsNil(paramafy.eCl());
      String str13 = bt.nullAsNil(paramafy.eCi());
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
        k.g(str7, "fullPath");
        k.g(str8, "fileExt");
        k.g(str9, "fileName");
        k.g(str10, "fileMd5");
        k.g(str13, "extId");
        k.g(str4, "cdnURL");
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
      for (paramafy = str4;; paramafy = str5)
      {
        for (;;)
        {
          k.g(paramafy, "if (cdnURL.isNotEmpty()) cdnURL else tpURL");
          k.g(str11, "aesKey");
          k.g(str12, "authKey");
          paramafy = new HandOffFile(str7, str8, str9, str10, l, i, paramg, str13, paramafy, str11, str12, "", "", (String)localObject, str2);
          AppMethodBeat.o(121694);
          return paramafy;
          paramg = str3;
          localObject = str1;
          str2 = str6;
          if (parambl == null) {
            break;
          }
          i = 1;
          localObject = str3;
          try
          {
            paramg = String.valueOf(parambl.SG());
            localObject = paramg;
            paramafy = paramafy.eCj();
            localObject = paramg;
            k.g(paramafy, "dataItem.dataProtoItem");
            localObject = paramg;
            paramafy = paramafy.eCm();
            localObject = paramg;
            k.g(paramafy, "dataItem.dataProtoItem.dataSourceItem");
            localObject = paramg;
            paramafy = paramafy.eCn();
            localObject = paramg;
            k.g(paramafy, "dataItem.dataProtoItem.dataSourceItem.fromUser");
          }
          catch (Exception paramafy)
          {
            try
            {
              str2 = parambl.SI();
              k.g(str2, "msg.talker");
              localObject = paramafy;
            }
            catch (Exception parambl)
            {
              break label378;
            }
            paramafy = paramafy;
            paramafy = str1;
            paramg = (g)localObject;
          }
        }
        label378:
        ad.w("HandOffService", "Get null from record msg, use default value");
        localObject = paramafy;
        str2 = str6;
        break;
        j = 0;
        break label198;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/handoff/model/HandOffFile$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/handoff/model/HandOffFile;", "api-handoff_release"})
  public static final class b
    implements Parcelable.Creator<HandOffFile>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.model.HandOffFile
 * JD-Core Version:    0.7.0.1
 */