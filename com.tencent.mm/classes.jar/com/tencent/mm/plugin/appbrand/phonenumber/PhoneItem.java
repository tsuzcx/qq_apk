package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.l;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mobile", "", "showMobile", "encryptedData", "iv", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getEncryptedData", "()Ljava/lang/String;", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "dest", "flags", "Companion", "plugin-appbrand-integration_release"})
public final class PhoneItem
  implements Parcelable
{
  public static final Parcelable.Creator<PhoneItem> CREATOR;
  public static final PhoneItem.a iDu;
  public final String aRj;
  final String czF;
  final String iDo;
  public final String iDp;
  public final boolean iDq;
  final boolean iDr;
  public boolean iDs;
  boolean iDt;
  
  static
  {
    AppMethodBeat.i(134804);
    iDu = new PhoneItem.a((byte)0);
    CREATOR = (Parcelable.Creator)new PhoneItem.b();
    AppMethodBeat.o(134804);
  }
  
  public PhoneItem(Parcel paramParcel) {}
  
  public PhoneItem(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(134802);
    this.czF = paramString1;
    this.iDo = paramString2;
    this.iDp = paramString3;
    this.aRj = paramString4;
    this.iDq = paramBoolean1;
    this.iDr = paramBoolean2;
    this.iDs = paramBoolean3;
    this.iDt = paramBoolean4;
    AppMethodBeat.o(134802);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(134800);
    if ((paramObject instanceof PhoneItem))
    {
      if ((j.e(((PhoneItem)paramObject).czF, this.czF)) && (((PhoneItem)paramObject).iDs == this.iDs))
      {
        AppMethodBeat.o(134800);
        return true;
      }
      AppMethodBeat.o(134800);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(134800);
    return bool;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(134805);
    String str = "PhoneItem(mobile=" + this.czF + ", showMobile=" + this.iDo + ", encryptedData=" + this.iDp + ", iv=" + this.aRj + ", needAuth=" + this.iDq + ", allowSendSms=" + this.iDr + ", isWechat=" + this.iDs + ", isCheck=" + this.iDt + ")";
    AppMethodBeat.o(134805);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(134801);
    j.q(paramParcel, "dest");
    paramParcel.writeString(this.czF);
    paramParcel.writeString(this.iDo);
    paramParcel.writeString(this.iDp);
    paramParcel.writeString(this.aRj);
    if (this.iDq)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.iDr) {
        break label112;
      }
      paramInt = 1;
      label68:
      paramParcel.writeInt(paramInt);
      if (!this.iDs) {
        break label117;
      }
      paramInt = 1;
      label82:
      paramParcel.writeInt(paramInt);
      if (!this.iDt) {
        break label122;
      }
    }
    label112:
    label117:
    label122:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(134801);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label68;
      paramInt = 0;
      break label82;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem
 * JD-Core Version:    0.7.0.1
 */