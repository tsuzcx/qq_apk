package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "mobile", "", "showMobile", "encryptedData", "iv", "cloud_id", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "data", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "getAllowSendSms", "()Z", "getCloud_id", "()Ljava/lang/String;", "getData", "setData", "(Ljava/lang/String;)V", "getEncryptedData", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PhoneItem
  implements Parcelable
{
  public static final Parcelable.Creator<PhoneItem> CREATOR;
  public static final a tGI;
  public String data;
  public final String dbg;
  public final String hRk;
  final String tGJ;
  public final String tGK;
  public final String tGL;
  public final boolean tGM;
  final boolean tGN;
  public boolean tGO;
  public boolean tGP;
  
  static
  {
    AppMethodBeat.i(148075);
    tGI = new a((byte)0);
    CREATOR = (Parcelable.Creator)new b();
    AppMethodBeat.o(148075);
  }
  
  public PhoneItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString6)
  {
    AppMethodBeat.i(318927);
    this.hRk = paramString1;
    this.tGJ = paramString2;
    this.tGK = paramString3;
    this.dbg = paramString4;
    this.tGL = paramString5;
    this.tGM = paramBoolean1;
    this.tGN = paramBoolean2;
    this.tGO = paramBoolean3;
    this.tGP = paramBoolean4;
    this.data = paramString6;
    AppMethodBeat.o(318927);
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
      if ((s.p(((PhoneItem)paramObject).hRk, this.hRk)) && (((PhoneItem)paramObject).tGO == this.tGO))
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
    String str = "PhoneItem(mobile=" + this.hRk + ", showMobile=" + this.tGJ + ", encryptedData=" + this.tGK + ", iv=" + this.dbg + ", cloud_id=" + this.tGL + ", needAuth=" + this.tGM + ", allowSendSms=" + this.tGN + ", isWechat=" + this.tGO + ", isCheck=" + this.tGP + ", data=" + this.data + ')';
    AppMethodBeat.o(148076);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(148072);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.hRk);
    paramParcel.writeString(this.tGJ);
    paramParcel.writeString(this.tGK);
    paramParcel.writeString(this.dbg);
    paramParcel.writeString(this.tGL);
    if (this.tGM)
    {
      paramInt = 1;
      paramParcel.writeInt(paramInt);
      if (!this.tGN) {
        break label128;
      }
      paramInt = 1;
      label76:
      paramParcel.writeInt(paramInt);
      if (!this.tGO) {
        break label133;
      }
      paramInt = 1;
      label90:
      paramParcel.writeInt(paramInt);
      if (!this.tGP) {
        break label138;
      }
    }
    label128:
    label133:
    label138:
    for (paramInt = i;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeString(this.data);
      AppMethodBeat.o(148072);
      return;
      paramInt = 0;
      break;
      paramInt = 0;
      break label76;
      paramInt = 0;
      break label90;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "TAG", "", "parseFromJson", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "jsonStr", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static PhoneItem afx(String paramString)
    {
      AppMethodBeat.i(148070);
      s.u(paramString, "jsonStr");
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
        String str4 = ((JSONObject)localObject2).optString("cloud_id", "");
        localObject2 = ((JSONObject)localObject2).optString("data", "");
        s.s(localObject1, "mobile");
        s.s(str1, "showMobile");
        s.s(str2, "encryptedData");
        s.s(str3, "iv");
        s.s(str4, "cloud_id");
        s.s(localObject2, "data");
        localObject1 = new PhoneItem((String)localObject1, str1, str2, str3, str4, bool1, bool2, bool3, bool4, (String)localObject2);
        AppMethodBeat.o(148070);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.PhoneItem", "jsonStr:%s", new Object[] { paramString });
        AppMethodBeat.o(148070);
      }
      return null;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Parcelable.Creator<PhoneItem>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem
 * JD-Core Version:    0.7.0.1
 */