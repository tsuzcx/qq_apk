package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.hd;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.plugin.card.mgr.d;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class ShareCardInfo
  extends hd
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String wsB;
  public ws wtH;
  public vr wtI;
  public fbs wtJ;
  public wl wtK;
  public boolean wtL;
  
  static
  {
    AppMethodBeat.i(113011);
    info = hd.aJm();
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.wtL = true;
    this.wsB = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.wtL = true;
    this.wsB = "";
    this.field_card_id = paramParcel.readString();
    this.field_card_tp_id = paramParcel.readString();
    this.field_from_username = paramParcel.readString();
    this.field_status = paramParcel.readInt();
    this.field_share_time = paramParcel.readLong();
    this.field_local_updateTime = paramParcel.readLong();
    this.field_updateTime = paramParcel.readLong();
    this.field_updateSeq = paramParcel.readLong();
    this.field_block_mask = paramParcel.readLong();
    this.field_end_time = paramParcel.readLong();
    this.field_categoryType = paramParcel.readInt();
    this.field_itemIndex = paramParcel.readInt();
    int k = paramParcel.readInt();
    int i;
    if (k > 0)
    {
      this.field_dataInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_dataInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_cardTpInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_cardTpInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_shareInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_shareInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_shopInfoData = new byte[k];
      i = j;
      while (i < k)
      {
        this.field_shopInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    AppMethodBeat.o(113004);
  }
  
  public final String Ig(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.dkO().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.dlr())
      {
        str = MMApplicationContext.getResources().getString(a.g.wpQ);
        AppMethodBeat.o(113008);
        return str;
      }
      AppMethodBeat.o(113008);
      return "";
    }
    AppMethodBeat.o(113008);
    return "";
  }
  
  public final void a(fbs paramfbs)
  {
    AppMethodBeat.i(113001);
    this.wtJ = paramfbs;
    try
    {
      this.field_shareInfoData = paramfbs.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramfbs)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramfbs.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramfbs, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(vr paramvr)
  {
    AppMethodBeat.i(112999);
    this.wtI = paramvr;
    if (this.wtI != null) {
      try
      {
        this.field_dataInfoData = paramvr.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramvr)
      {
        Log.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramvr.getMessage() });
        Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramvr, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(wl paramwl)
  {
    AppMethodBeat.i(113003);
    this.wtK = paramwl;
    try
    {
      this.field_shopInfoData = paramwl.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramwl)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramwl.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramwl, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(ws paramws)
  {
    AppMethodBeat.i(112997);
    this.wtH = paramws;
    try
    {
      this.field_cardTpInfoData = paramws.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramws)
    {
      Log.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramws.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final void akq(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean djA()
  {
    AppMethodBeat.i(112990);
    if ((djK().ZdT & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean djB()
  {
    return false;
  }
  
  public final boolean djC()
  {
    AppMethodBeat.i(112991);
    if ((djK().ZdT & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean djD()
  {
    AppMethodBeat.i(112992);
    if ((djK().ZdT & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean djE()
  {
    AppMethodBeat.i(113010);
    if ((djK() != null) && (djK().Zef == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean djF()
  {
    return (this.wtI != null) && (this.wtI.status == 0);
  }
  
  public final boolean djG()
  {
    AppMethodBeat.i(112993);
    if (!djF())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.wtH != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.wtH.Zeg);
    }
    Log.i("MicroMsg.ShareCardInfo", "stock_num:" + this.wtI.ZbA + " limit_num:" + this.wtI.ZbB);
    if ((this.wtH != null) && (this.wtH.Zeg == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.wtH != null) && (this.wtH.Zeg == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.wtI.ZbA == 0L) || (this.wtI.ZbB == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    AppMethodBeat.o(112993);
    return false;
  }
  
  public final boolean djH()
  {
    AppMethodBeat.i(112994);
    if (!djF())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.wtH != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.wtH.Zeg);
    }
    Log.i("MicroMsg.ShareCardInfo", "avail_num:" + this.wtI.Zbx);
    if ((this.wtH != null) && (this.wtH.Zeg == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.wtI.Zbx > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.wtH != null) && (this.wtH.Zeg == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.wtI.Zbx == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean djI()
  {
    AppMethodBeat.i(112995);
    if ((this.wtH == null) || (this.wtH.ZdX == null) || (TextUtils.isEmpty(this.wtH.ZdX.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    wh localwh = this.wtH.ZdX;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localwh.PzZ;
    if ((localwh.PzZ > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean djJ()
  {
    return (this.wtH != null) && (this.wtH.Zek == 1);
  }
  
  public final ws djK()
  {
    AppMethodBeat.i(112996);
    ws localws1;
    if (this.wtH != null)
    {
      localws1 = this.wtH;
      AppMethodBeat.o(112996);
      return localws1;
    }
    try
    {
      this.wtH = ((ws)new ws().parseFrom(this.field_cardTpInfoData));
      localws1 = this.wtH;
      AppMethodBeat.o(112996);
      return localws1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ws localws2 = new ws();
      AppMethodBeat.o(112996);
      return localws2;
    }
  }
  
  public final vr djL()
  {
    AppMethodBeat.i(112998);
    vr localvr1;
    if (this.wtI != null)
    {
      localvr1 = this.wtI;
      AppMethodBeat.o(112998);
      return localvr1;
    }
    try
    {
      this.wtI = ((vr)new vr().parseFrom(this.field_dataInfoData));
      localvr1 = this.wtI;
      AppMethodBeat.o(112998);
      return localvr1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      vr localvr2 = new vr();
      AppMethodBeat.o(112998);
      return localvr2;
    }
  }
  
  public final fbs djM()
  {
    AppMethodBeat.i(113000);
    fbs localfbs1;
    if (this.wtJ != null)
    {
      localfbs1 = this.wtJ;
      AppMethodBeat.o(113000);
      return localfbs1;
    }
    try
    {
      this.wtJ = ((fbs)new fbs().parseFrom(this.field_shareInfoData));
      localfbs1 = this.wtJ;
      AppMethodBeat.o(113000);
      return localfbs1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      fbs localfbs2 = new fbs();
      AppMethodBeat.o(113000);
      return localfbs2;
    }
  }
  
  public final wl djN()
  {
    AppMethodBeat.i(113002);
    wl localwl;
    if (this.wtK != null)
    {
      localwl = this.wtK;
      AppMethodBeat.o(113002);
      return localwl;
    }
    try
    {
      this.wtK = ((wl)new wl().parseFrom(this.field_shopInfoData));
      localwl = this.wtK;
      AppMethodBeat.o(113002);
      return localwl;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
    }
    return null;
  }
  
  public final String djO()
  {
    return this.field_card_id;
  }
  
  public final String djP()
  {
    return this.field_card_tp_id;
  }
  
  public final String djQ()
  {
    return this.field_from_username;
  }
  
  public final long djR()
  {
    return this.field_local_updateTime;
  }
  
  public final String djS()
  {
    return "";
  }
  
  public final String djT()
  {
    AppMethodBeat.i(113009);
    Log.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.wsB);
    String str = this.wsB;
    AppMethodBeat.o(113009);
    return str;
  }
  
  public final boolean djo()
  {
    AppMethodBeat.i(113006);
    if ((djK() != null) && (djK().Zea == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean djp()
  {
    AppMethodBeat.i(113007);
    if ((djK() != null) && (djK().Zea == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean djq()
  {
    AppMethodBeat.i(112980);
    if ((djK() != null) && (djK().tNW == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean djr()
  {
    AppMethodBeat.i(112981);
    if ((djK() != null) && (djK().tNW == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean djs()
  {
    AppMethodBeat.i(112982);
    if ((djK() != null) && (djK().tNW == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean djt()
  {
    AppMethodBeat.i(112983);
    if ((djK() != null) && (djK().tNW == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean dju()
  {
    AppMethodBeat.i(112984);
    if ((djK() != null) && (djK().tNW == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean djv()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.Ii(djK().tNW);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean djw()
  {
    AppMethodBeat.i(112986);
    if ((djK().ZdQ & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean djx()
  {
    AppMethodBeat.i(112987);
    if ((djK().ZdQ & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean djy()
  {
    AppMethodBeat.i(112988);
    if ((djK().ZdT & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean djz()
  {
    AppMethodBeat.i(112989);
    if ((djK().ZdT & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final int getCategoryType()
  {
    return this.field_categoryType;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final long getEndTime()
  {
    return this.field_end_time;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(113005);
    paramParcel.writeString(this.field_card_id);
    paramParcel.writeString(this.field_card_tp_id);
    paramParcel.writeString(this.field_from_username);
    paramParcel.writeInt(this.field_status);
    paramParcel.writeLong(this.field_share_time);
    paramParcel.writeLong(this.field_local_updateTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeLong(this.field_updateSeq);
    paramParcel.writeLong(this.field_block_mask);
    paramParcel.writeLong(this.field_end_time);
    paramParcel.writeInt(this.field_categoryType);
    paramParcel.writeInt(this.field_itemIndex);
    if (this.field_dataInfoData != null)
    {
      paramParcel.writeInt(this.field_dataInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_dataInfoData.length)
      {
        paramParcel.writeByte(this.field_dataInfoData[paramInt]);
        paramInt += 1;
      }
    }
    if (this.field_cardTpInfoData != null)
    {
      paramParcel.writeInt(this.field_cardTpInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_cardTpInfoData.length)
      {
        paramParcel.writeByte(this.field_cardTpInfoData[paramInt]);
        paramInt += 1;
      }
    }
    if (this.field_shareInfoData != null)
    {
      paramParcel.writeInt(this.field_shareInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_shareInfoData.length)
      {
        paramParcel.writeByte(this.field_shareInfoData[paramInt]);
        paramInt += 1;
      }
    }
    if (this.field_shopInfoData != null)
    {
      paramParcel.writeInt(this.field_shopInfoData.length);
      paramInt = i;
      while (paramInt < this.field_shopInfoData.length)
      {
        paramParcel.writeByte(this.field_shopInfoData[paramInt]);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(113005);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */