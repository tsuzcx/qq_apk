package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gc;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends gc
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String pSa;
  public uz pTh;
  public ty pTi;
  public dxr pTj;
  public us pTk;
  public boolean pTl;
  
  static
  {
    AppMethodBeat.i(113011);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[19];
    localMAutoDBInfo.columns = new String[20];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "card_tp_id";
    localMAutoDBInfo.colsMap.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "from_username";
    localMAutoDBInfo.colsMap.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "consumer";
    localMAutoDBInfo.colsMap.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "app_id";
    localMAutoDBInfo.colsMap.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "share_time";
    localMAutoDBInfo.colsMap.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "local_updateTime";
    localMAutoDBInfo.colsMap.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "begin_time";
    localMAutoDBInfo.colsMap.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "end_time";
    localMAutoDBInfo.colsMap.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "updateSeq";
    localMAutoDBInfo.colsMap.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "block_mask";
    localMAutoDBInfo.colsMap.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "dataInfoData";
    localMAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "cardTpInfoData";
    localMAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shareInfoData";
    localMAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "shopInfoData";
    localMAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "categoryType";
    localMAutoDBInfo.colsMap.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "itemIndex";
    localMAutoDBInfo.colsMap.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    localMAutoDBInfo.columns[19] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.pTl = true;
    this.pSa = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.pTl = true;
    this.pSa = "";
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
  
  public final String Ee(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.ctV().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.cuy())
      {
        str = MMApplicationContext.getResources().getString(2131757135);
        AppMethodBeat.o(113008);
        return str;
      }
      AppMethodBeat.o(113008);
      return "";
    }
    AppMethodBeat.o(113008);
    return "";
  }
  
  public final void a(dxr paramdxr)
  {
    AppMethodBeat.i(113001);
    this.pTj = paramdxr;
    try
    {
      this.field_shareInfoData = paramdxr.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramdxr)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramdxr.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramdxr, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(ty paramty)
  {
    AppMethodBeat.i(112999);
    this.pTi = paramty;
    if (this.pTi != null) {
      try
      {
        this.field_dataInfoData = paramty.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramty)
      {
        Log.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramty.getMessage() });
        Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramty, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(us paramus)
  {
    AppMethodBeat.i(113003);
    this.pTk = paramus;
    try
    {
      this.field_shopInfoData = paramus.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramus)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramus.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramus, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(uz paramuz)
  {
    AppMethodBeat.i(112997);
    this.pTh = paramuz;
    try
    {
      this.field_cardTpInfoData = paramuz.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramuz)
    {
      Log.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramuz.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final void aiY(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final boolean csA()
  {
    AppMethodBeat.i(112983);
    if ((csQ() != null) && (csQ().nHh == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean csB()
  {
    AppMethodBeat.i(112984);
    if ((csQ() != null) && (csQ().nHh == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean csC()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.Eg(csQ().nHh);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean csD()
  {
    AppMethodBeat.i(112986);
    if ((csQ().LeH & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean csE()
  {
    AppMethodBeat.i(112987);
    if ((csQ().LeH & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean csF()
  {
    AppMethodBeat.i(112988);
    if ((csQ().LeK & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean csG()
  {
    AppMethodBeat.i(112989);
    if ((csQ().LeK & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean csH()
  {
    AppMethodBeat.i(112990);
    if ((csQ().LeK & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean csI()
  {
    return false;
  }
  
  public final boolean csJ()
  {
    AppMethodBeat.i(112991);
    if ((csQ().LeK & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean csK()
  {
    AppMethodBeat.i(112992);
    if ((csQ().LeK & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean csL()
  {
    AppMethodBeat.i(113010);
    if ((csQ() != null) && (csQ().LeW == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean csM()
  {
    return (this.pTi != null) && (this.pTi.status == 0);
  }
  
  public final boolean csN()
  {
    AppMethodBeat.i(112994);
    if (!csM())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.pTh != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.pTh.LeX);
    }
    Log.i("MicroMsg.ShareCardInfo", "avail_num:" + this.pTi.Lcq);
    if ((this.pTh != null) && (this.pTh.LeX == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.pTi.Lcq > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.pTh != null) && (this.pTh.LeX == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.pTi.Lcq == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean csO()
  {
    AppMethodBeat.i(112995);
    if ((this.pTh == null) || (this.pTh.LeO == null) || (TextUtils.isEmpty(this.pTh.LeO.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    uo localuo = this.pTh.LeO;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localuo.DhD;
    if ((localuo.DhD > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean csP()
  {
    return (this.pTh != null) && (this.pTh.Lfb == 1);
  }
  
  public final uz csQ()
  {
    AppMethodBeat.i(112996);
    uz localuz1;
    if (this.pTh != null)
    {
      localuz1 = this.pTh;
      AppMethodBeat.o(112996);
      return localuz1;
    }
    try
    {
      this.pTh = ((uz)new uz().parseFrom(this.field_cardTpInfoData));
      localuz1 = this.pTh;
      AppMethodBeat.o(112996);
      return localuz1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      uz localuz2 = new uz();
      AppMethodBeat.o(112996);
      return localuz2;
    }
  }
  
  public final ty csR()
  {
    AppMethodBeat.i(112998);
    ty localty1;
    if (this.pTi != null)
    {
      localty1 = this.pTi;
      AppMethodBeat.o(112998);
      return localty1;
    }
    try
    {
      this.pTi = ((ty)new ty().parseFrom(this.field_dataInfoData));
      localty1 = this.pTi;
      AppMethodBeat.o(112998);
      return localty1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ty localty2 = new ty();
      AppMethodBeat.o(112998);
      return localty2;
    }
  }
  
  public final dxr csS()
  {
    AppMethodBeat.i(113000);
    dxr localdxr1;
    if (this.pTj != null)
    {
      localdxr1 = this.pTj;
      AppMethodBeat.o(113000);
      return localdxr1;
    }
    try
    {
      this.pTj = ((dxr)new dxr().parseFrom(this.field_shareInfoData));
      localdxr1 = this.pTj;
      AppMethodBeat.o(113000);
      return localdxr1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      dxr localdxr2 = new dxr();
      AppMethodBeat.o(113000);
      return localdxr2;
    }
  }
  
  public final us csT()
  {
    AppMethodBeat.i(113002);
    us localus;
    if (this.pTk != null)
    {
      localus = this.pTk;
      AppMethodBeat.o(113002);
      return localus;
    }
    try
    {
      this.pTk = ((us)new us().parseFrom(this.field_shopInfoData));
      localus = this.pTk;
      AppMethodBeat.o(113002);
      return localus;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
    }
    return null;
  }
  
  public final String csU()
  {
    return this.field_card_id;
  }
  
  public final String csV()
  {
    return this.field_card_tp_id;
  }
  
  public final String csW()
  {
    return this.field_from_username;
  }
  
  public final long csX()
  {
    return this.field_local_updateTime;
  }
  
  public final String csY()
  {
    return "";
  }
  
  public final int csZ()
  {
    return this.field_categoryType;
  }
  
  public final boolean csv()
  {
    AppMethodBeat.i(113006);
    if ((csQ() != null) && (csQ().LeR == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean csw()
  {
    AppMethodBeat.i(113007);
    if ((csQ() != null) && (csQ().LeR == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean csx()
  {
    AppMethodBeat.i(112980);
    if ((csQ() != null) && (csQ().nHh == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean csy()
  {
    AppMethodBeat.i(112981);
    if ((csQ() != null) && (csQ().nHh == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean csz()
  {
    AppMethodBeat.i(112982);
    if ((csQ() != null) && (csQ().nHh == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final String cta()
  {
    AppMethodBeat.i(113009);
    Log.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.pSa);
    String str = this.pSa;
    AppMethodBeat.o(113009);
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
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
    if (!csM())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.pTh != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.pTh.LeX);
    }
    Log.i("MicroMsg.ShareCardInfo", "stock_num:" + this.pTi.Lct + " limit_num:" + this.pTi.Lcu);
    if ((this.pTh != null) && (this.pTh.LeX == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.pTh != null) && (this.pTh.LeX == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.pTi.Lct == 0L) || (this.pTi.Lcu == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */