package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.gj;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends gj
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String toa;
  public vb tpi;
  public ua tpj;
  public ehs tpk;
  public uu tpl;
  public boolean tpm;
  
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
    this.tpm = true;
    this.toa = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.tpm = true;
    this.toa = "";
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
  
  public final String HF(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.cHx().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.cIa())
      {
        str = MMApplicationContext.getResources().getString(a.g.tlr);
        AppMethodBeat.o(113008);
        return str;
      }
      AppMethodBeat.o(113008);
      return "";
    }
    AppMethodBeat.o(113008);
    return "";
  }
  
  public final void a(ehs paramehs)
  {
    AppMethodBeat.i(113001);
    this.tpk = paramehs;
    try
    {
      this.field_shareInfoData = paramehs.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramehs)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramehs.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramehs, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(ua paramua)
  {
    AppMethodBeat.i(112999);
    this.tpj = paramua;
    if (this.tpj != null) {
      try
      {
        this.field_dataInfoData = paramua.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramua)
      {
        Log.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramua.getMessage() });
        Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramua, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(uu paramuu)
  {
    AppMethodBeat.i(113003);
    this.tpl = paramuu;
    try
    {
      this.field_shopInfoData = paramuu.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramuu)
    {
      Log.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramuu.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", paramuu, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(vb paramvb)
  {
    AppMethodBeat.i(112997);
    this.tpi = paramvb;
    try
    {
      this.field_cardTpInfoData = paramvb.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramvb)
    {
      Log.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramvb.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final void aqL(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final boolean cFW()
  {
    AppMethodBeat.i(113006);
    if ((cGs() != null) && (cGs().Sgf == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean cFX()
  {
    AppMethodBeat.i(113007);
    if ((cGs() != null) && (cGs().Sgf == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean cFY()
  {
    AppMethodBeat.i(112980);
    if ((cGs() != null) && (cGs().qJt == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean cFZ()
  {
    AppMethodBeat.i(112981);
    if ((cGs() != null) && (cGs().qJt == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final String cGA()
  {
    return "";
  }
  
  public final int cGB()
  {
    return this.field_categoryType;
  }
  
  public final String cGC()
  {
    AppMethodBeat.i(113009);
    Log.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.toa);
    String str = this.toa;
    AppMethodBeat.o(113009);
    return str;
  }
  
  public final boolean cGa()
  {
    AppMethodBeat.i(112982);
    if ((cGs() != null) && (cGs().qJt == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean cGb()
  {
    AppMethodBeat.i(112983);
    if ((cGs() != null) && (cGs().qJt == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean cGc()
  {
    AppMethodBeat.i(112984);
    if ((cGs() != null) && (cGs().qJt == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean cGd()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.HH(cGs().qJt);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean cGe()
  {
    AppMethodBeat.i(112986);
    if ((cGs().SfV & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean cGf()
  {
    AppMethodBeat.i(112987);
    if ((cGs().SfV & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean cGg()
  {
    AppMethodBeat.i(112988);
    if ((cGs().SfY & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean cGh()
  {
    AppMethodBeat.i(112989);
    if ((cGs().SfY & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean cGi()
  {
    AppMethodBeat.i(112990);
    if ((cGs().SfY & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean cGj()
  {
    return false;
  }
  
  public final boolean cGk()
  {
    AppMethodBeat.i(112991);
    if ((cGs().SfY & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean cGl()
  {
    AppMethodBeat.i(112992);
    if ((cGs().SfY & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean cGm()
  {
    AppMethodBeat.i(113010);
    if ((cGs() != null) && (cGs().Sgk == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean cGn()
  {
    return (this.tpj != null) && (this.tpj.status == 0);
  }
  
  public final boolean cGo()
  {
    AppMethodBeat.i(112993);
    if (!cGn())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.tpi != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.tpi.Sgl);
    }
    Log.i("MicroMsg.ShareCardInfo", "stock_num:" + this.tpj.SdG + " limit_num:" + this.tpj.SdH);
    if ((this.tpi != null) && (this.tpi.Sgl == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.tpi != null) && (this.tpi.Sgl == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.tpj.SdG == 0L) || (this.tpj.SdH == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    AppMethodBeat.o(112993);
    return false;
  }
  
  public final boolean cGp()
  {
    AppMethodBeat.i(112994);
    if (!cGn())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.tpi != null) {
      Log.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.tpi.Sgl);
    }
    Log.i("MicroMsg.ShareCardInfo", "avail_num:" + this.tpj.SdD);
    if ((this.tpi != null) && (this.tpi.Sgl == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.tpj.SdD > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.tpi != null) && (this.tpi.Sgl == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.tpj.SdD == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean cGq()
  {
    AppMethodBeat.i(112995);
    if ((this.tpi == null) || (this.tpi.Sgc == null) || (TextUtils.isEmpty(this.tpi.Sgc.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    uq localuq = this.tpi.Sgc;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localuq.Jnj;
    if ((localuq.Jnj > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean cGr()
  {
    return (this.tpi != null) && (this.tpi.Sgp == 1);
  }
  
  public final vb cGs()
  {
    AppMethodBeat.i(112996);
    vb localvb1;
    if (this.tpi != null)
    {
      localvb1 = this.tpi;
      AppMethodBeat.o(112996);
      return localvb1;
    }
    try
    {
      this.tpi = ((vb)new vb().parseFrom(this.field_cardTpInfoData));
      localvb1 = this.tpi;
      AppMethodBeat.o(112996);
      return localvb1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      vb localvb2 = new vb();
      AppMethodBeat.o(112996);
      return localvb2;
    }
  }
  
  public final ua cGt()
  {
    AppMethodBeat.i(112998);
    ua localua1;
    if (this.tpj != null)
    {
      localua1 = this.tpj;
      AppMethodBeat.o(112998);
      return localua1;
    }
    try
    {
      this.tpj = ((ua)new ua().parseFrom(this.field_dataInfoData));
      localua1 = this.tpj;
      AppMethodBeat.o(112998);
      return localua1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ua localua2 = new ua();
      AppMethodBeat.o(112998);
      return localua2;
    }
  }
  
  public final ehs cGu()
  {
    AppMethodBeat.i(113000);
    ehs localehs1;
    if (this.tpk != null)
    {
      localehs1 = this.tpk;
      AppMethodBeat.o(113000);
      return localehs1;
    }
    try
    {
      this.tpk = ((ehs)new ehs().parseFrom(this.field_shareInfoData));
      localehs1 = this.tpk;
      AppMethodBeat.o(113000);
      return localehs1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ehs localehs2 = new ehs();
      AppMethodBeat.o(113000);
      return localehs2;
    }
  }
  
  public final uu cGv()
  {
    AppMethodBeat.i(113002);
    uu localuu;
    if (this.tpl != null)
    {
      localuu = this.tpl;
      AppMethodBeat.o(113002);
      return localuu;
    }
    try
    {
      this.tpl = ((uu)new uu().parseFrom(this.field_shopInfoData));
      localuu = this.tpl;
      AppMethodBeat.o(113002);
      return localuu;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
    }
    return null;
  }
  
  public final String cGw()
  {
    return this.field_card_id;
  }
  
  public final String cGx()
  {
    return this.field_card_tp_id;
  }
  
  public final String cGy()
  {
    return this.field_from_username;
  }
  
  public final long cGz()
  {
    return this.field_local_updateTime;
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