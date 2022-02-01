package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.he;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.ehs;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.uu;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends he
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String toa;
  public vb tpi;
  public ua tpj;
  public ehs tpk;
  public uu tpl;
  public boolean tpm;
  
  static
  {
    AppMethodBeat.i(112765);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
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
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "delete_state_flag";
    localMAutoDBInfo.colsMap.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "local_updateTime";
    localMAutoDBInfo.colsMap.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "updateSeq";
    localMAutoDBInfo.colsMap.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "create_time";
    localMAutoDBInfo.colsMap.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "begin_time";
    localMAutoDBInfo.colsMap.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "end_time";
    localMAutoDBInfo.colsMap.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "block_mask";
    localMAutoDBInfo.colsMap.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "dataInfoData";
    localMAutoDBInfo.colsMap.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "cardTpInfoData";
    localMAutoDBInfo.colsMap.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "shareInfoData";
    localMAutoDBInfo.colsMap.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shopInfoData";
    localMAutoDBInfo.colsMap.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "stickyIndex";
    localMAutoDBInfo.colsMap.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "stickyEndTime";
    localMAutoDBInfo.colsMap.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "stickyAnnouncement";
    localMAutoDBInfo.colsMap.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "card_type";
    localMAutoDBInfo.colsMap.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "label_wording";
    localMAutoDBInfo.colsMap.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "is_dynamic";
    localMAutoDBInfo.colsMap.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.tpm = true;
    this.toa = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.tpm = true;
    this.toa = "";
    this.field_card_id = paramParcel.readString();
    this.field_card_tp_id = paramParcel.readString();
    this.field_from_username = paramParcel.readString();
    this.field_status = paramParcel.readInt();
    this.field_delete_state_flag = paramParcel.readInt();
    this.field_local_updateTime = paramParcel.readLong();
    this.field_updateTime = paramParcel.readLong();
    this.field_updateSeq = paramParcel.readLong();
    this.field_create_time = paramParcel.readLong();
    this.field_begin_time = paramParcel.readLong();
    this.field_end_time = paramParcel.readLong();
    this.field_block_mask = paramParcel.readString();
    this.field_stickyIndex = paramParcel.readInt();
    this.field_stickyEndTime = paramParcel.readInt();
    this.field_stickyAnnouncement = paramParcel.readString();
    this.field_card_type = paramParcel.readInt();
    this.field_label_wording = paramParcel.readString();
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
    AppMethodBeat.o(112759);
  }
  
  public final String HF(int paramInt)
  {
    return null;
  }
  
  public final void a(ehs paramehs)
  {
    AppMethodBeat.i(112756);
    this.tpk = paramehs;
    if (paramehs != null) {}
    try
    {
      this.field_shareInfoData = paramehs.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramehs)
    {
      Log.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramehs.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramehs, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(ua paramua)
  {
    AppMethodBeat.i(112754);
    this.tpj = paramua;
    if (this.tpj != null)
    {
      this.field_status = this.tpj.status;
      if (paramua != null) {}
      try
      {
        this.field_dataInfoData = paramua.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramua)
      {
        Log.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramua.getMessage() });
        Log.printErrStackTrace("MicroMsg.CardInfo", paramua, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(uu paramuu)
  {
    AppMethodBeat.i(112758);
    this.tpl = paramuu;
    if (paramuu != null) {}
    try
    {
      this.field_shopInfoData = paramuu.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramuu)
    {
      Log.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramuu.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramuu, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(vb paramvb)
  {
    AppMethodBeat.i(112752);
    this.tpi = paramvb;
    if (paramvb != null) {}
    try
    {
      this.field_cardTpInfoData = paramvb.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramvb)
    {
      Log.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramvb.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final void aqL(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final boolean cFW()
  {
    AppMethodBeat.i(112761);
    if ((cGs() != null) && (cGs().Sgf == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean cFX()
  {
    AppMethodBeat.i(112762);
    if ((cGs() != null) && (cGs().Sgf == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean cFY()
  {
    AppMethodBeat.i(112734);
    if ((cGs() != null) && (cGs().qJt == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean cFZ()
  {
    AppMethodBeat.i(112735);
    if ((cGs() != null) && (cGs().qJt == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final String cGA()
  {
    return null;
  }
  
  public final int cGB()
  {
    return 0;
  }
  
  public final String cGC()
  {
    AppMethodBeat.i(112763);
    Log.d("MicroMsg.CardInfo", "encrypt_code:" + this.toa);
    String str = this.toa;
    AppMethodBeat.o(112763);
    return str;
  }
  
  public final boolean cGa()
  {
    AppMethodBeat.i(112736);
    if ((cGs() != null) && (cGs().qJt == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean cGb()
  {
    AppMethodBeat.i(112737);
    if ((cGs() != null) && (cGs().qJt == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean cGc()
  {
    AppMethodBeat.i(112738);
    if ((cGs() != null) && (cGs().qJt == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean cGd()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.HH(cGs().qJt);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean cGe()
  {
    AppMethodBeat.i(112740);
    if ((cGs().SfV & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean cGf()
  {
    AppMethodBeat.i(112741);
    if ((cGs().SfV & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean cGg()
  {
    AppMethodBeat.i(112742);
    if ((cGs().SfY & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean cGh()
  {
    AppMethodBeat.i(112743);
    if ((cGs().SfY & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean cGi()
  {
    AppMethodBeat.i(112744);
    if ((cGs().SfY & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean cGj()
  {
    AppMethodBeat.i(112745);
    if ((cGs().SfY & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean cGk()
  {
    AppMethodBeat.i(112746);
    if ((cGs().SfY & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean cGl()
  {
    AppMethodBeat.i(112747);
    if ((cGs().SfY & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean cGm()
  {
    AppMethodBeat.i(112764);
    if ((cGs() != null) && (cGs().Sgk == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean cGn()
  {
    return (this.tpj != null) && (this.tpj.status == 0);
  }
  
  public final boolean cGo()
  {
    AppMethodBeat.i(112748);
    if (!cGn())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.tpi != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.tpi.Sgl);
    }
    Log.i("MicroMsg.CardInfo", "stock_num:" + this.tpj.SdG + " limit_num:" + this.tpj.SdH);
    if ((this.tpi != null) && (this.tpi.Sgl == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.tpi != null) && (this.tpi.Sgl == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.tpj.SdG == 0L) || (this.tpj.SdH == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    AppMethodBeat.o(112748);
    return false;
  }
  
  public final boolean cGp()
  {
    AppMethodBeat.i(112749);
    if (!cGn())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.tpi != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.tpi.Sgl);
    }
    Log.i("MicroMsg.CardInfo", "avail_num:" + this.tpj.SdD);
    if ((this.tpi != null) && (this.tpi.Sgl == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.tpj.SdD > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.tpi != null) && (this.tpi.Sgl == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.tpj.SdD == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean cGq()
  {
    AppMethodBeat.i(112750);
    if ((this.tpi == null) || (this.tpi.Sgc == null) || (TextUtils.isEmpty(this.tpi.Sgc.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    uq localuq = this.tpi.Sgc;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localuq.Jnj;
    if ((localuq.Jnj > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean cGr()
  {
    return (this.tpi != null) && (this.tpi.Sgp == 1);
  }
  
  public final vb cGs()
  {
    AppMethodBeat.i(112751);
    vb localvb1;
    if (this.tpi != null)
    {
      localvb1 = this.tpi;
      AppMethodBeat.o(112751);
      return localvb1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.tpi = ((vb)new vb().parseFrom(this.field_cardTpInfoData));
        localvb1 = this.tpi;
        AppMethodBeat.o(112751);
        return localvb1;
      }
      localvb1 = new vb();
      AppMethodBeat.o(112751);
      return localvb1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      vb localvb2 = new vb();
      AppMethodBeat.o(112751);
      return localvb2;
    }
  }
  
  public final ua cGt()
  {
    AppMethodBeat.i(112753);
    ua localua1;
    if (this.tpj != null)
    {
      localua1 = this.tpj;
      AppMethodBeat.o(112753);
      return localua1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.tpj = ((ua)new ua().parseFrom(this.field_dataInfoData));
        localua1 = this.tpj;
        AppMethodBeat.o(112753);
        return localua1;
      }
      localua1 = new ua();
      AppMethodBeat.o(112753);
      return localua1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ua localua2 = new ua();
      AppMethodBeat.o(112753);
      return localua2;
    }
  }
  
  public final ehs cGu()
  {
    AppMethodBeat.i(112755);
    ehs localehs1;
    if (this.tpk != null)
    {
      localehs1 = this.tpk;
      AppMethodBeat.o(112755);
      return localehs1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.tpk = ((ehs)new ehs().parseFrom(this.field_shareInfoData));
        localehs1 = this.tpk;
        AppMethodBeat.o(112755);
        return localehs1;
      }
      localehs1 = new ehs();
      AppMethodBeat.o(112755);
      return localehs1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ehs localehs2 = new ehs();
      AppMethodBeat.o(112755);
      return localehs2;
    }
  }
  
  public final uu cGv()
  {
    AppMethodBeat.i(112757);
    uu localuu;
    if (this.tpl != null)
    {
      localuu = this.tpl;
      AppMethodBeat.o(112757);
      return localuu;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.tpl = ((uu)new uu().parseFrom(this.field_shopInfoData));
        localuu = this.tpl;
        AppMethodBeat.o(112757);
        return localuu;
      }
      AppMethodBeat.o(112757);
      return null;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(112757);
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
    AppMethodBeat.i(112760);
    paramParcel.writeString(this.field_card_id);
    paramParcel.writeString(this.field_card_tp_id);
    paramParcel.writeString(this.field_from_username);
    paramParcel.writeInt(this.field_status);
    paramParcel.writeInt(this.field_delete_state_flag);
    paramParcel.writeLong(this.field_local_updateTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeLong(this.field_updateSeq);
    paramParcel.writeLong(this.field_create_time);
    paramParcel.writeLong(this.field_begin_time);
    paramParcel.writeLong(this.field_end_time);
    paramParcel.writeString(this.field_block_mask);
    paramParcel.writeInt(this.field_stickyIndex);
    paramParcel.writeInt(this.field_stickyEndTime);
    paramParcel.writeString(this.field_stickyAnnouncement);
    paramParcel.writeInt(this.field_card_type);
    paramParcel.writeString(this.field_label_wording);
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
    paramParcel.writeInt(0);
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
    paramParcel.writeInt(0);
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
    paramParcel.writeInt(0);
    if (this.field_shopInfoData != null)
    {
      paramParcel.writeInt(this.field_shopInfoData.length);
      paramInt = i;
      while (paramInt < this.field_shopInfoData.length)
      {
        paramParcel.writeByte(this.field_shopInfoData[paramInt]);
        paramInt += 1;
      }
      AppMethodBeat.o(112760);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(112760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */