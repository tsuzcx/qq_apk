package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.h.c.dx;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.protocal.c.mb;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends dx
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR = new ShareCardInfo.1();
  protected static c.a buS;
  public String ils = "";
  public mg ims;
  public lv imt;
  public bru imu;
  public mb imv;
  public boolean imw = true;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[19];
    locala.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.ujN.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.ujN.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.ujN.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "consumer";
    locala.ujN.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.ujN.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.ujN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.ujN.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.ujN.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.ujN.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.ujN.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.ujN.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.ujN.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.ujN.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.ujN.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.ujN.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.ujN.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.ujN.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.ujN.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public ShareCardInfo() {}
  
  public ShareCardInfo(Parcel paramParcel)
  {
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
  }
  
  public final void a(lv paramlv)
  {
    this.imt = paramlv;
    if (this.imt != null) {}
    try
    {
      this.field_dataInfoData = paramlv.toByteArray();
      return;
    }
    catch (Exception paramlv)
    {
      y.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramlv.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", paramlv, "", new Object[0]);
    }
  }
  
  public final void a(mb parammb)
  {
    this.imv = parammb;
    try
    {
      this.field_shopInfoData = parammb.toByteArray();
      return;
    }
    catch (Exception parammb)
    {
      y.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { parammb.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", parammb, "", new Object[0]);
    }
  }
  
  public final mb azA()
  {
    if (this.imv != null) {
      return this.imv;
    }
    try
    {
      this.imv = ((mb)new mb().aH(this.field_shopInfoData));
      return this.imv;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
    }
    return null;
  }
  
  public final String azB()
  {
    return this.field_card_id;
  }
  
  public final String azC()
  {
    return this.field_card_tp_id;
  }
  
  public final String azD()
  {
    return this.field_from_username;
  }
  
  public final long azE()
  {
    return this.field_local_updateTime;
  }
  
  public final String azF()
  {
    return "";
  }
  
  public final int azG()
  {
    return this.field_categoryType;
  }
  
  public final String azH()
  {
    y.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.ils);
    return this.ils;
  }
  
  public final boolean azd()
  {
    return (azx() != null) && (azx().sIH == 0);
  }
  
  public final boolean aze()
  {
    return (azx() != null) && (azx().sIH == 1);
  }
  
  public final boolean azf()
  {
    return (azx() != null) && (azx().ilo == 10);
  }
  
  public final boolean azg()
  {
    return (azx() != null) && (azx().ilo == 0);
  }
  
  public final boolean azh()
  {
    return (azx() != null) && (azx().ilo == 20);
  }
  
  public final boolean azi()
  {
    return (azx() != null) && (azx().ilo == 11);
  }
  
  public final boolean azj()
  {
    return (azx() != null) && (azx().ilo == 30);
  }
  
  public final boolean azk()
  {
    return l.oN(azx().ilo);
  }
  
  public final boolean azl()
  {
    return (azx().sIx & 0x2) == 0;
  }
  
  public final boolean azm()
  {
    return (azx().sIx & 0x1) == 0;
  }
  
  public final boolean azn()
  {
    return (azx().sIA & 1L) == 0L;
  }
  
  public final boolean azo()
  {
    return (azx().sIA & 0x10) == 0L;
  }
  
  public final boolean azp()
  {
    return (azx().sIA & 0x2) > 0L;
  }
  
  public final boolean azq()
  {
    return false;
  }
  
  public final boolean azr()
  {
    return (azx().sIA & 0x4) > 0L;
  }
  
  public final boolean azs()
  {
    return (azx().sIA & 0x8) > 0L;
  }
  
  public final boolean azt()
  {
    return (azx() != null) && (azx().sIM == 1);
  }
  
  public final boolean azu()
  {
    if (!isNormal()) {}
    do
    {
      return false;
      if (this.ims != null) {
        y.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.ims.sIN);
      }
      y.i("MicroMsg.ShareCardInfo", "avail_num:" + this.imt.sHw);
      if ((this.ims != null) && (this.ims.sIN == 1)) {
        return true;
      }
      if (this.imt.sHw > 0) {
        return true;
      }
    } while (((this.ims != null) && (this.ims.sIN == 0)) || (this.imt.sHw != 0));
    return false;
  }
  
  public final boolean azv()
  {
    if ((this.ims == null) || (this.ims.sIE == null) || (TextUtils.isEmpty(this.ims.sIE.text))) {}
    ly locally;
    int i;
    int j;
    do
    {
      return false;
      locally = this.ims.sIE;
      i = (int)(System.currentTimeMillis() / 1000L);
      j = locally.nZA;
    } while ((locally.nZA <= 0) || (j - i <= 0));
    return true;
  }
  
  public final boolean azw()
  {
    return (this.ims != null) && (this.ims.sIR == 1);
  }
  
  public final mg azx()
  {
    if (this.ims != null) {
      return this.ims;
    }
    try
    {
      this.ims = ((mg)new mg().aH(this.field_cardTpInfoData));
      return this.ims;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
    }
    return new mg();
  }
  
  public final lv azy()
  {
    if (this.imt != null) {
      return this.imt;
    }
    try
    {
      this.imt = ((lv)new lv().aH(this.field_dataInfoData));
      return this.imt;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
    }
    return new lv();
  }
  
  public final bru azz()
  {
    if (this.imu != null) {
      return this.imu;
    }
    try
    {
      this.imu = ((bru)new bru().aH(this.field_shareInfoData));
      return this.imu;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      y.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
    }
    return new bru();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final long getEndTime()
  {
    return this.field_end_time;
  }
  
  public final boolean isAcceptable()
  {
    if (!isNormal()) {}
    do
    {
      return false;
      if (this.ims != null) {
        y.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.ims.sIN);
      }
      y.i("MicroMsg.ShareCardInfo", "stock_num:" + this.imt.sHz + " limit_num:" + this.imt.sHA);
      if ((this.ims != null) && (this.ims.sIN == 1)) {
        return true;
      }
    } while (((this.ims != null) && (this.ims.sIN == 0)) || (this.imt.sHz == 0L) || (this.imt.sHA != 0));
    return false;
  }
  
  public final boolean isNormal()
  {
    return (this.imt != null) && (this.imt.status == 0);
  }
  
  public final String oL(int paramInt)
  {
    if (paramInt == 10) {
      return (String)am.aAx().getValue("key_share_card_local_city");
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.aAR()) {
        return ae.getResources().getString(a.g.card_share_card_category_type_other_city);
      }
      return "";
    }
    return "";
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
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
  }
  
  public final void xW(String paramString)
  {
    this.field_from_username = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */