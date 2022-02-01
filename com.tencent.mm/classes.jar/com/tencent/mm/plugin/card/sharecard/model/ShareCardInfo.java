package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fe;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends fe
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static c.a info;
  public String nru;
  public ro nsC;
  public qo nsD;
  public csx nsE;
  public rh nsF;
  public boolean nsG;
  
  static
  {
    AppMethodBeat.i(113011);
    c.a locala = new c.a();
    locala.EYt = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.EYv.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.EYv.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.EYv.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "consumer";
    locala.EYv.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.EYv.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.EYv.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.EYv.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.EYv.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.EYv.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.EYv.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.EYv.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.EYv.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.EYv.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.EYv.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.EYv.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.EYv.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.EYv.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.nsG = true;
    this.nru = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.nsG = true;
    this.nru = "";
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
  
  public final void Qh(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(csx paramcsx)
  {
    AppMethodBeat.i(113001);
    this.nsE = paramcsx;
    try
    {
      this.field_shareInfoData = paramcsx.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramcsx)
    {
      ad.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramcsx.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramcsx, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(qo paramqo)
  {
    AppMethodBeat.i(112999);
    this.nsD = paramqo;
    if (this.nsD != null) {
      try
      {
        this.field_dataInfoData = paramqo.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramqo)
      {
        ad.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramqo.getMessage() });
        ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramqo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(rh paramrh)
  {
    AppMethodBeat.i(113003);
    this.nsF = paramrh;
    try
    {
      this.field_shopInfoData = paramrh.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramrh)
    {
      ad.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramrh.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", paramrh, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(ro paramro)
  {
    AppMethodBeat.i(112997);
    this.nsC = paramro;
    try
    {
      this.field_cardTpInfoData = paramro.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramro)
    {
      ad.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramro.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final boolean bHA()
  {
    AppMethodBeat.i(113006);
    if ((bHV() != null) && (bHV().CRV == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean bHB()
  {
    AppMethodBeat.i(113007);
    if ((bHV() != null) && (bHV().CRV == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean bHC()
  {
    AppMethodBeat.i(112980);
    if ((bHV() != null) && (bHV().lpz == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean bHD()
  {
    AppMethodBeat.i(112981);
    if ((bHV() != null) && (bHV().lpz == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean bHE()
  {
    AppMethodBeat.i(112982);
    if ((bHV() != null) && (bHV().lpz == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean bHF()
  {
    AppMethodBeat.i(112983);
    if ((bHV() != null) && (bHV().lpz == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean bHG()
  {
    AppMethodBeat.i(112984);
    if ((bHV() != null) && (bHV().lpz == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean bHH()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.yQ(bHV().lpz);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean bHI()
  {
    AppMethodBeat.i(112986);
    if ((bHV().CRL & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean bHJ()
  {
    AppMethodBeat.i(112987);
    if ((bHV().CRL & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean bHK()
  {
    AppMethodBeat.i(112988);
    if ((bHV().CRO & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean bHL()
  {
    AppMethodBeat.i(112989);
    if ((bHV().CRO & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean bHM()
  {
    AppMethodBeat.i(112990);
    if ((bHV().CRO & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean bHN()
  {
    return false;
  }
  
  public final boolean bHO()
  {
    AppMethodBeat.i(112991);
    if ((bHV().CRO & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean bHP()
  {
    AppMethodBeat.i(112992);
    if ((bHV().CRO & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean bHQ()
  {
    AppMethodBeat.i(113010);
    if ((bHV() != null) && (bHV().CSa == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean bHR()
  {
    return (this.nsD != null) && (this.nsD.status == 0);
  }
  
  public final boolean bHS()
  {
    AppMethodBeat.i(112994);
    if (!bHR())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.nsC != null) {
      ad.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.nsC.CSb);
    }
    ad.i("MicroMsg.ShareCardInfo", "avail_num:" + this.nsD.CPt);
    if ((this.nsC != null) && (this.nsC.CSb == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.nsD.CPt > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.nsC != null) && (this.nsC.CSb == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.nsD.CPt == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean bHT()
  {
    AppMethodBeat.i(112995);
    if ((this.nsC == null) || (this.nsC.CRS == null) || (TextUtils.isEmpty(this.nsC.CRS.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    rd localrd = this.nsC.CRS;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localrd.wmA;
    if ((localrd.wmA > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean bHU()
  {
    return (this.nsC != null) && (this.nsC.CSf == 1);
  }
  
  public final ro bHV()
  {
    AppMethodBeat.i(112996);
    ro localro1;
    if (this.nsC != null)
    {
      localro1 = this.nsC;
      AppMethodBeat.o(112996);
      return localro1;
    }
    try
    {
      this.nsC = ((ro)new ro().parseFrom(this.field_cardTpInfoData));
      localro1 = this.nsC;
      AppMethodBeat.o(112996);
      return localro1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ro localro2 = new ro();
      AppMethodBeat.o(112996);
      return localro2;
    }
  }
  
  public final qo bHW()
  {
    AppMethodBeat.i(112998);
    qo localqo1;
    if (this.nsD != null)
    {
      localqo1 = this.nsD;
      AppMethodBeat.o(112998);
      return localqo1;
    }
    try
    {
      this.nsD = ((qo)new qo().parseFrom(this.field_dataInfoData));
      localqo1 = this.nsD;
      AppMethodBeat.o(112998);
      return localqo1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      qo localqo2 = new qo();
      AppMethodBeat.o(112998);
      return localqo2;
    }
  }
  
  public final csx bHX()
  {
    AppMethodBeat.i(113000);
    csx localcsx1;
    if (this.nsE != null)
    {
      localcsx1 = this.nsE;
      AppMethodBeat.o(113000);
      return localcsx1;
    }
    try
    {
      this.nsE = ((csx)new csx().parseFrom(this.field_shareInfoData));
      localcsx1 = this.nsE;
      AppMethodBeat.o(113000);
      return localcsx1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      csx localcsx2 = new csx();
      AppMethodBeat.o(113000);
      return localcsx2;
    }
  }
  
  public final rh bHY()
  {
    AppMethodBeat.i(113002);
    rh localrh;
    if (this.nsF != null)
    {
      localrh = this.nsF;
      AppMethodBeat.o(113002);
      return localrh;
    }
    try
    {
      this.nsF = ((rh)new rh().parseFrom(this.field_shopInfoData));
      localrh = this.nsF;
      AppMethodBeat.o(113002);
      return localrh;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
    }
    return null;
  }
  
  public final String bHZ()
  {
    return this.field_card_id;
  }
  
  public final String bIa()
  {
    return this.field_card_tp_id;
  }
  
  public final String bIb()
  {
    return this.field_from_username;
  }
  
  public final long bIc()
  {
    return this.field_local_updateTime;
  }
  
  public final String bId()
  {
    return "";
  }
  
  public final int bIe()
  {
    return this.field_categoryType;
  }
  
  public final String bIf()
  {
    AppMethodBeat.i(113009);
    ad.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.nru);
    String str = this.nru;
    AppMethodBeat.o(113009);
    return str;
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
    if (!bHR())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.nsC != null) {
      ad.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.nsC.CSb);
    }
    ad.i("MicroMsg.ShareCardInfo", "stock_num:" + this.nsD.CPw + " limit_num:" + this.nsD.CPx);
    if ((this.nsC != null) && (this.nsC.CSb == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.nsC != null) && (this.nsC.CSb == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.nsD.CPw == 0L) || (this.nsD.CPx == 0))
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
  
  public final String yO(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.bJa().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.bJA())
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */