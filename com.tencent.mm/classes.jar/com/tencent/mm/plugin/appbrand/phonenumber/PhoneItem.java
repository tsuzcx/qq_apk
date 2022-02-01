package com.tencent.mm.plugin.appbrand.phonenumber;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Landroid/os/Parcelable;", "mobile", "", "showMobile", "encryptedData", "iv", "cloud_id", "needAuth", "", "allowSendSms", "isWechat", "isCheck", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V", "getAllowSendSms", "()Z", "getCloud_id", "()Ljava/lang/String;", "getEncryptedData", "setCheck", "(Z)V", "setWechat", "getIv", "getMobile", "getNeedAuth", "getShowMobile", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toJSONStr", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "luggage-wechat-full-sdk_release"})
public final class PhoneItem
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR;
  public static final a moO;
  public final String bxJ;
  public final String dAs;
  final String moH;
  public final String moI;
  public final String moJ;
  public final boolean moK;
  final boolean moL;
  public boolean moM;
  public boolean moN;
  
  static
  {
    AppMethodBeat.i(148075);
    moO = new a((byte)0);
    CREATOR = new b();
    AppMethodBeat.o(148075);
  }
  
  public PhoneItem(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    AppMethodBeat.i(148073);
    this.dAs = paramString1;
    this.moH = paramString2;
    this.moI = paramString3;
    this.bxJ = paramString4;
    this.moJ = paramString5;
    this.moK = paramBoolean1;
    this.moL = paramBoolean2;
    this.moM = paramBoolean3;
    this.moN = paramBoolean4;
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
      if ((p.i(((PhoneItem)paramObject).dAs, this.dAs)) && (((PhoneItem)paramObject).moM == this.moM))
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
    String str = "PhoneItem(mobile=" + this.dAs + ", showMobile=" + this.moH + ", encryptedData=" + this.moI + ", iv=" + this.bxJ + ", cloud_id=" + this.moJ + ", needAuth=" + this.moK + ", allowSendSms=" + this.moL + ", isWechat=" + this.moM + ", isCheck=" + this.moN + ")";
    AppMethodBeat.o(148076);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem$Companion;", "", "()V", "TAG", "", "parseFromJson", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "jsonStr", "luggage-wechat-full-sdk_release"})
  public static final class a
  {
    public static PhoneItem UF(String paramString)
    {
      AppMethodBeat.i(148070);
      p.h(paramString, "jsonStr");
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
        p.g(localObject1, "mobile");
        p.g(str1, "showMobile");
        p.g(str2, "encryptedData");
        p.g(str3, "iv");
        p.g(localObject2, "cloud_id");
        localObject1 = new PhoneItem((String)localObject1, str1, str2, str3, (String)localObject2, bool1, bool2, bool3, bool4);
        AppMethodBeat.o(148070);
        return localObject1;
      }
      catch (JSONException localJSONException)
      {
        ae.e("MicroMsg.PhoneItem", "jsonStr:%s", new Object[] { paramString });
        AppMethodBeat.o(148070);
      }
      return null;
    }
  }
  
  @l(gjZ={1, 1, 16})
  public static final class b
    implements Parcelable.Creator
  {
    public final Object createFromParcel(Parcel paramParcel)
    {
      boolean bool4 = true;
      AppMethodBeat.i(221006);
      p.h(paramParcel, "in");
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      String str3 = paramParcel.readString();
      String str4 = paramParcel.readString();
      String str5 = paramParcel.readString();
      boolean bool1;
      boolean bool2;
      label62:
      boolean bool3;
      if (paramParcel.readInt() != 0)
      {
        bool1 = true;
        if (paramParcel.readInt() == 0) {
          break label115;
        }
        bool2 = true;
        if (paramParcel.readInt() == 0) {
          break label120;
        }
        bool3 = true;
        label72:
        if (paramParcel.readInt() == 0) {
          break label126;
        }
      }
      for (;;)
      {
        paramParcel = new PhoneItem(str1, str2, str3, str4, str5, bool1, bool2, bool3, bool4);
        AppMethodBeat.o(221006);
        return paramParcel;
        bool1 = false;
        break;
        label115:
        bool2 = false;
        break label62;
        label120:
        bool3 = false;
        break label72;
        label126:
        bool4 = false;
      }
    }
    
    public final Object[] newArray(int paramInt)
    {
      return new PhoneItem[paramInt];
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem
 * JD-Core Version:    0.7.0.1
 */