package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fs;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends fs
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static c.a info;
  public String oxP;
  public ts oyX;
  public sr oyY;
  public ddt oyZ;
  public tl oza;
  public boolean ozb;
  
  static
  {
    AppMethodBeat.i(113011);
    c.a locala = new c.a();
    locala.IhA = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.IhC.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.IhC.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.IhC.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "consumer";
    locala.IhC.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.IhC.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.IhC.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.IhC.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.IhC.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.IhC.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.IhC.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.IhC.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.IhC.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.IhC.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.IhC.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.IhC.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.IhC.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.IhC.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.ozb = true;
    this.oxP = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.ozb = true;
    this.oxP = "";
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
  
  public final String An(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.bUS().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.bVs())
      {
        str = aj.getResources().getString(2131756965);
        AppMethodBeat.o(113008);
        return str;
      }
      AppMethodBeat.o(113008);
      return "";
    }
    AppMethodBeat.o(113008);
    return "";
  }
  
  public final void Yc(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(ddt paramddt)
  {
    AppMethodBeat.i(113001);
    this.oyZ = paramddt;
    try
    {
      this.field_shareInfoData = paramddt.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramddt)
    {
      ad.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramddt.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramddt, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(sr paramsr)
  {
    AppMethodBeat.i(112999);
    this.oyY = paramsr;
    if (this.oyY != null) {
      try
      {
        this.field_dataInfoData = paramsr.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramsr)
      {
        ad.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramsr.getMessage() });
        ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramsr, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(tl paramtl)
  {
    AppMethodBeat.i(113003);
    this.oza = paramtl;
    try
    {
      this.field_shopInfoData = paramtl.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramtl)
    {
      ad.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramtl.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramtl, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(ts paramts)
  {
    AppMethodBeat.i(112997);
    this.oyX = paramts;
    try
    {
      this.field_cardTpInfoData = paramts.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramts)
    {
      ad.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramts.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final boolean bTA()
  {
    AppMethodBeat.i(112986);
    if ((bTN().FRF & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean bTB()
  {
    AppMethodBeat.i(112987);
    if ((bTN().FRF & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean bTC()
  {
    AppMethodBeat.i(112988);
    if ((bTN().FRI & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean bTD()
  {
    AppMethodBeat.i(112989);
    if ((bTN().FRI & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean bTE()
  {
    AppMethodBeat.i(112990);
    if ((bTN().FRI & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean bTF()
  {
    return false;
  }
  
  public final boolean bTG()
  {
    AppMethodBeat.i(112991);
    if ((bTN().FRI & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean bTH()
  {
    AppMethodBeat.i(112992);
    if ((bTN().FRI & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean bTI()
  {
    AppMethodBeat.i(113010);
    if ((bTN() != null) && (bTN().FRU == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean bTJ()
  {
    return (this.oyY != null) && (this.oyY.status == 0);
  }
  
  public final boolean bTK()
  {
    AppMethodBeat.i(112994);
    if (!bTJ())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.oyX != null) {
      ad.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.oyX.FRV);
    }
    ad.i("MicroMsg.ShareCardInfo", "avail_num:" + this.oyY.FPo);
    if ((this.oyX != null) && (this.oyX.FRV == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.oyY.FPo > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.oyX != null) && (this.oyX.FRV == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.oyY.FPo == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean bTL()
  {
    AppMethodBeat.i(112995);
    if ((this.oyX == null) || (this.oyX.FRM == null) || (TextUtils.isEmpty(this.oyX.FRM.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    th localth = this.oyX.FRM;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localth.yMB;
    if ((localth.yMB > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean bTM()
  {
    return (this.oyX != null) && (this.oyX.FRZ == 1);
  }
  
  public final ts bTN()
  {
    AppMethodBeat.i(112996);
    ts localts1;
    if (this.oyX != null)
    {
      localts1 = this.oyX;
      AppMethodBeat.o(112996);
      return localts1;
    }
    try
    {
      this.oyX = ((ts)new ts().parseFrom(this.field_cardTpInfoData));
      localts1 = this.oyX;
      AppMethodBeat.o(112996);
      return localts1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ts localts2 = new ts();
      AppMethodBeat.o(112996);
      return localts2;
    }
  }
  
  public final sr bTO()
  {
    AppMethodBeat.i(112998);
    sr localsr1;
    if (this.oyY != null)
    {
      localsr1 = this.oyY;
      AppMethodBeat.o(112998);
      return localsr1;
    }
    try
    {
      this.oyY = ((sr)new sr().parseFrom(this.field_dataInfoData));
      localsr1 = this.oyY;
      AppMethodBeat.o(112998);
      return localsr1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      sr localsr2 = new sr();
      AppMethodBeat.o(112998);
      return localsr2;
    }
  }
  
  public final ddt bTP()
  {
    AppMethodBeat.i(113000);
    ddt localddt1;
    if (this.oyZ != null)
    {
      localddt1 = this.oyZ;
      AppMethodBeat.o(113000);
      return localddt1;
    }
    try
    {
      this.oyZ = ((ddt)new ddt().parseFrom(this.field_shareInfoData));
      localddt1 = this.oyZ;
      AppMethodBeat.o(113000);
      return localddt1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ddt localddt2 = new ddt();
      AppMethodBeat.o(113000);
      return localddt2;
    }
  }
  
  public final tl bTQ()
  {
    AppMethodBeat.i(113002);
    tl localtl;
    if (this.oza != null)
    {
      localtl = this.oza;
      AppMethodBeat.o(113002);
      return localtl;
    }
    try
    {
      this.oza = ((tl)new tl().parseFrom(this.field_shopInfoData));
      localtl = this.oza;
      AppMethodBeat.o(113002);
      return localtl;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
    }
    return null;
  }
  
  public final String bTR()
  {
    return this.field_card_id;
  }
  
  public final String bTS()
  {
    return this.field_card_tp_id;
  }
  
  public final String bTT()
  {
    return this.field_from_username;
  }
  
  public final long bTU()
  {
    return this.field_local_updateTime;
  }
  
  public final String bTV()
  {
    return "";
  }
  
  public final int bTW()
  {
    return this.field_categoryType;
  }
  
  public final String bTX()
  {
    AppMethodBeat.i(113009);
    ad.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.oxP);
    String str = this.oxP;
    AppMethodBeat.o(113009);
    return str;
  }
  
  public final boolean bTs()
  {
    AppMethodBeat.i(113006);
    if ((bTN() != null) && (bTN().FRP == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean bTt()
  {
    AppMethodBeat.i(113007);
    if ((bTN() != null) && (bTN().FRP == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean bTu()
  {
    AppMethodBeat.i(112980);
    if ((bTN() != null) && (bTN().mrl == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean bTv()
  {
    AppMethodBeat.i(112981);
    if ((bTN() != null) && (bTN().mrl == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean bTw()
  {
    AppMethodBeat.i(112982);
    if ((bTN() != null) && (bTN().mrl == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean bTx()
  {
    AppMethodBeat.i(112983);
    if ((bTN() != null) && (bTN().mrl == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean bTy()
  {
    AppMethodBeat.i(112984);
    if ((bTN() != null) && (bTN().mrl == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean bTz()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.Ap(bTN().mrl);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final long getEndTime()
  {
    return this.field_end_time;
  }
  
  public final boolean isAcceptable()
  {
    AppMethodBeat.i(112993);
    if (!bTJ())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.oyX != null) {
      ad.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.oyX.FRV);
    }
    ad.i("MicroMsg.ShareCardInfo", "stock_num:" + this.oyY.FPr + " limit_num:" + this.oyY.FPs);
    if ((this.oyX != null) && (this.oyX.FRV == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.oyX != null) && (this.oyX.FRV == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.oyY.FPr == 0L) || (this.oyY.FPs == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    AppMethodBeat.o(112993);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */