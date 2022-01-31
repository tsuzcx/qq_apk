package com.tencent.mm.plugin.brandservice.ui.timeline.preload;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/brandservice/ui/timeline/preload/PreloadLogic$PreloadSession;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "url", "", "itemShowType", "tmplType", "openScene", "subScene", "aScene", "uid", "fastOpen", "", "cacheData", "zip", "prefixMP", "prefixHttp", "cacheItemShowType", "webCodeCache", "(ILjava/lang/String;IIIIILjava/lang/String;ZZZZZZZ)V", "getAScene", "()I", "getCacheData", "()Z", "setCacheData", "(Z)V", "getCacheItemShowType", "setCacheItemShowType", "getFastOpen", "setFastOpen", "getId", "getItemShowType", "getOpenScene", "getPrefixHttp", "setPrefixHttp", "getPrefixMP", "setPrefixMP", "getSubScene", "getTmplType", "getUid", "()Ljava/lang/String;", "setUid", "(Ljava/lang/String;)V", "getUrl", "setUrl", "getWebCodeCache", "setWebCodeCache", "getZip", "setZip", "describeContents", "writeToParcel", "", "flags", "CREATOR", "plugin-brandservice_release"})
public final class PreloadLogic$PreloadSession
  implements Parcelable
{
  public static final PreloadLogic.PreloadSession.a CREATOR;
  final int fgh;
  final int id;
  public boolean kaV;
  public final int kbM;
  final int kbN;
  final int kbO;
  String kbP;
  boolean kbQ;
  boolean kbR;
  public boolean kbS;
  public boolean kbT;
  boolean kbU;
  public boolean kbV;
  public final int kbq;
  String url;
  
  static
  {
    AppMethodBeat.i(14876);
    CREATOR = new PreloadLogic.PreloadSession.a((byte)0);
    AppMethodBeat.o(14876);
  }
  
  private PreloadLogic$PreloadSession(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    AppMethodBeat.i(152684);
    this.id = paramInt1;
    this.url = paramString1;
    this.fgh = paramInt2;
    this.kbM = paramInt3;
    this.kbq = paramInt4;
    this.kbN = paramInt5;
    this.kbO = paramInt6;
    this.kbP = paramString2;
    this.kbQ = paramBoolean1;
    this.kbR = paramBoolean2;
    this.kbS = paramBoolean3;
    this.kbT = paramBoolean4;
    this.kbU = paramBoolean5;
    this.kaV = paramBoolean6;
    this.kbV = paramBoolean7;
    AppMethodBeat.o(152684);
  }
  
  public PreloadLogic$PreloadSession(Parcel paramParcel) {}
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    byte b2 = 1;
    AppMethodBeat.i(14872);
    j.q(paramParcel, "parcel");
    paramParcel.writeInt(this.id);
    paramParcel.writeString(this.url);
    paramParcel.writeInt(this.fgh);
    paramParcel.writeInt(this.kbM);
    paramParcel.writeInt(this.kbq);
    paramParcel.writeInt(this.kbN);
    paramParcel.writeInt(this.kbO);
    paramParcel.writeString(this.kbP);
    if (this.kbQ)
    {
      b1 = 1;
      paramParcel.writeByte(b1);
      if (!this.kbR) {
        break label190;
      }
      b1 = 1;
      label102:
      paramParcel.writeByte(b1);
      if (!this.kbS) {
        break label195;
      }
      b1 = 1;
      label116:
      paramParcel.writeByte(b1);
      if (!this.kbT) {
        break label200;
      }
      b1 = 1;
      label130:
      paramParcel.writeByte(b1);
      if (!this.kbU) {
        break label205;
      }
      b1 = 1;
      label144:
      paramParcel.writeByte(b1);
      if (!this.kaV) {
        break label210;
      }
      b1 = 1;
      label158:
      paramParcel.writeByte(b1);
      if (!this.kbV) {
        break label215;
      }
    }
    label190:
    label195:
    label200:
    label205:
    label210:
    label215:
    for (byte b1 = b2;; b1 = 0)
    {
      paramParcel.writeByte(b1);
      AppMethodBeat.o(14872);
      return;
      b1 = 0;
      break;
      b1 = 0;
      break label102;
      b1 = 0;
      break label116;
      b1 = 0;
      break label130;
      b1 = 0;
      break label144;
      b1 = 0;
      break label158;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.preload.PreloadLogic.PreloadSession
 * JD-Core Version:    0.7.0.1
 */