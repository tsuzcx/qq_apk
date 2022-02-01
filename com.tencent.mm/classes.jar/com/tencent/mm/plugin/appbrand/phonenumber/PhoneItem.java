package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "source", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "mobile", "", "showMobile", "encryptedData", "iv", "cloud_id", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getCloud_id", "()Ljava/lang/String;", "getEncryptedData", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "dest", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneItem
  implements Parcelable
{
  public static final Parcelable.Creator<PhoneItem> CREATOR;
  public static final a lKb;
  public final String bno;
  public final String dnz;
  final String lJU;
  public final String lJV;
  public final String lJW;
  public final boolean lJX;
  final boolean lJY;
  public boolean lJZ;
  public boolean lKa;
  
  static
  {
    AppMethodBeat.i(148075);
    lKb = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(148075);
  }
  
  public PhoneItem(Parcel paramParcel) {}
  
  public PhoneItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(148073);
    this.dnz = paramString1;
    this.lJU = paramString2;
    this.lJV = paramString3;
    this.bno = paramString4;
    this.lJW = paramString5;
    this.lJX = paramBoolean1;
    this.lJY = paramBoolean2;
    this.lJZ = paramBoolean3;
    this.lKa = paramBoolean4;
    AppMethodBeat.o(148073);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(148071);
    if ((paramObject instanceof PhoneItem))
    {
      if ((k.g(((PhoneItem)paramObject).dnz, this.dnz)) && (((PhoneItem)paramObject).lJZ == this.lJZ))
      {
        AppMethodBeat.o(148071);
        return true;
      }
      AppMethodBeat.o(148071);
      return false;
    }
    boolean bool = super.equals(paramObject);
    AppMethodBeat.o(148071);
    return bool;
  }
  
  public final int hashCode()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public final String toString()
  {
    AppMethodBeat.i(148076);
    String str = "PhoneItem(mobile=" + this.dnz + ", showMobile=" + this.lJU + ", encryptedData=" + this.lJV + ", iv=" + this.bno + ", cloud_id=" + this.lJW + ", needAuth=" + this.lJX + ", allowSendSms=" + this.lJY + ", isWechat=" + this.lJZ + ", isCheck=" + this.lKa + ")";
    AppMethodBeat.o(148076);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148072);
    k.h(paramParcel, "dest");
    paramParcel.writeString(this.dnz);
    paramParcel.writeString(this.lJU);
    paramParcel.writeString(this.lJV);
    paramParcel.writeString(this.bno);
    if (this.lJX)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.lJY) {
        break label120;
      }
      paramInt = 1;
      label68:
      paramParcel.writeInt(paramInt);
      if (!this.lJZ) {
        break label125;
      }
      paramInt = 1;
      label82:
      paramParcel.writeInt(paramInt);
      if (!this.lKa) {
        break label130;
      }
    }
    label130:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.lJW);
      AppMethodBeat.o(148072);
      return;
      paramInt = 0;
      break;
      label120:
      paramInt = 0;
      break label68;
      label125:
      paramInt = 0;
      break label82;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "TAG", "", "parseFromJson", "jsonStr", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static PhoneItem Qq(String paramString)
    {
      AppMethodBeat.i(148070);
      k.h(paramString, "jsonStr");
      try
      {
        Object localObject2 = new JSONObject(paramString);
        Object localObject1 = ((JSONObject)localObject2).optString("mobile");
        String str1 = ((JSONObject)localObject2).optString("show_mobile");
        boolean bool1 = ((JSONObject)localObject2).optBoolean("need_auth", true);
        boolean bool2 = ((JSONObject)localObject2).optBoolean("allow_send_sms", true);
        String str2 = ((JSONObject)localObject2).optString("encryptedData");
        String str3 = ((JSONObject)localObject2).optString("iv");
        boolean bool3 = ((JSONObject)localObject2).optBoolean("is_wechat", false);
        boolean bool4 = ((JSONObject)localObject2).optBoolean("is_check", false);
        localObject2 = ((JSONObject)localObject2).optString("cloud_id", "");
        k.g(localObject1, "mobile");
        k.g(str1, "showMobile");
        k.g(str2, "encryptedData");
        k.g(str3, "iv");
        k.g(localObject2, "cloud_id");
        localObject1 = new PhoneItem((String)localObject1, str1, str2, str3, (String)localObject2, bool1, bool2, bool3, bool4);
        AppMethodBeat.o(148070);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.PhoneItem", "jsonStr:%s", new Object[] { paramString });
        AppMethodBeat.o(148070);
      }
      return null;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"})
  public final class b
    implements Parcelable.Creator<PhoneItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem
 * JD-Core Version:    0.7.0.1
 */