package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gx;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.dxr;
import com.tencent.mm.protocal.protobuf.ty;
import com.tencent.mm.protocal.protobuf.uo;
import com.tencent.mm.protocal.protobuf.us;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends gx
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String pSa;
  public uz pTh;
  public ty pTi;
  public dxr pTj;
  public us pTk;
  public boolean pTl;
  
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
    CREATOR = new CardInfo.1();
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.pTl = true;
    this.pSa = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.pTl = true;
    this.pSa = "";
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
  
  public final String Ee(int paramInt)
  {
    return null;
  }
  
  public final void a(dxr paramdxr)
  {
    AppMethodBeat.i(112756);
    this.pTj = paramdxr;
    if (paramdxr != null) {}
    try
    {
      this.field_shareInfoData = paramdxr.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramdxr)
    {
      Log.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramdxr.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramdxr, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(ty paramty)
  {
    AppMethodBeat.i(112754);
    this.pTi = paramty;
    if (this.pTi != null)
    {
      this.field_status = this.pTi.status;
      if (paramty != null) {}
      try
      {
        this.field_dataInfoData = paramty.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramty)
      {
        Log.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramty.getMessage() });
        Log.printErrStackTrace("MicroMsg.CardInfo", paramty, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(us paramus)
  {
    AppMethodBeat.i(112758);
    this.pTk = paramus;
    if (paramus != null) {}
    try
    {
      this.field_shopInfoData = paramus.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramus)
    {
      Log.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramus.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramus, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(uz paramuz)
  {
    AppMethodBeat.i(112752);
    this.pTh = paramuz;
    if (paramuz != null) {}
    try
    {
      this.field_cardTpInfoData = paramuz.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramuz)
    {
      Log.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramuz.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final void aiY(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final boolean csA()
  {
    AppMethodBeat.i(112737);
    if ((csQ() != null) && (csQ().nHh == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean csB()
  {
    AppMethodBeat.i(112738);
    if ((csQ() != null) && (csQ().nHh == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean csC()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.Eg(csQ().nHh);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean csD()
  {
    AppMethodBeat.i(112740);
    if ((csQ().LeH & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean csE()
  {
    AppMethodBeat.i(112741);
    if ((csQ().LeH & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean csF()
  {
    AppMethodBeat.i(112742);
    if ((csQ().LeK & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean csG()
  {
    AppMethodBeat.i(112743);
    if ((csQ().LeK & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean csH()
  {
    AppMethodBeat.i(112744);
    if ((csQ().LeK & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean csI()
  {
    AppMethodBeat.i(112745);
    if ((csQ().LeK & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean csJ()
  {
    AppMethodBeat.i(112746);
    if ((csQ().LeK & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean csK()
  {
    AppMethodBeat.i(112747);
    if ((csQ().LeK & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean csL()
  {
    AppMethodBeat.i(112764);
    if ((csQ() != null) && (csQ().LeW == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean csM()
  {
    return (this.pTi != null) && (this.pTi.status == 0);
  }
  
  public final boolean csN()
  {
    AppMethodBeat.i(112749);
    if (!csM())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.pTh != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.pTh.LeX);
    }
    Log.i("MicroMsg.CardInfo", "avail_num:" + this.pTi.Lcq);
    if ((this.pTh != null) && (this.pTh.LeX == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.pTi.Lcq > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.pTh != null) && (this.pTh.LeX == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.pTi.Lcq == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean csO()
  {
    AppMethodBeat.i(112750);
    if ((this.pTh == null) || (this.pTh.LeO == null) || (TextUtils.isEmpty(this.pTh.LeO.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    uo localuo = this.pTh.LeO;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localuo.DhD;
    if ((localuo.DhD > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean csP()
  {
    return (this.pTh != null) && (this.pTh.Lfb == 1);
  }
  
  public final uz csQ()
  {
    AppMethodBeat.i(112751);
    uz localuz1;
    if (this.pTh != null)
    {
      localuz1 = this.pTh;
      AppMethodBeat.o(112751);
      return localuz1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.pTh = ((uz)new uz().parseFrom(this.field_cardTpInfoData));
        localuz1 = this.pTh;
        AppMethodBeat.o(112751);
        return localuz1;
      }
      localuz1 = new uz();
      AppMethodBeat.o(112751);
      return localuz1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      uz localuz2 = new uz();
      AppMethodBeat.o(112751);
      return localuz2;
    }
  }
  
  public final ty csR()
  {
    AppMethodBeat.i(112753);
    ty localty1;
    if (this.pTi != null)
    {
      localty1 = this.pTi;
      AppMethodBeat.o(112753);
      return localty1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.pTi = ((ty)new ty().parseFrom(this.field_dataInfoData));
        localty1 = this.pTi;
        AppMethodBeat.o(112753);
        return localty1;
      }
      localty1 = new ty();
      AppMethodBeat.o(112753);
      return localty1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ty localty2 = new ty();
      AppMethodBeat.o(112753);
      return localty2;
    }
  }
  
  public final dxr csS()
  {
    AppMethodBeat.i(112755);
    dxr localdxr1;
    if (this.pTj != null)
    {
      localdxr1 = this.pTj;
      AppMethodBeat.o(112755);
      return localdxr1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.pTj = ((dxr)new dxr().parseFrom(this.field_shareInfoData));
        localdxr1 = this.pTj;
        AppMethodBeat.o(112755);
        return localdxr1;
      }
      localdxr1 = new dxr();
      AppMethodBeat.o(112755);
      return localdxr1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      dxr localdxr2 = new dxr();
      AppMethodBeat.o(112755);
      return localdxr2;
    }
  }
  
  public final us csT()
  {
    AppMethodBeat.i(112757);
    us localus;
    if (this.pTk != null)
    {
      localus = this.pTk;
      AppMethodBeat.o(112757);
      return localus;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.pTk = ((us)new us().parseFrom(this.field_shopInfoData));
        localus = this.pTk;
        AppMethodBeat.o(112757);
        return localus;
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
    return null;
  }
  
  public final int csZ()
  {
    return 0;
  }
  
  public final boolean csv()
  {
    AppMethodBeat.i(112761);
    if ((csQ() != null) && (csQ().LeR == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean csw()
  {
    AppMethodBeat.i(112762);
    if ((csQ() != null) && (csQ().LeR == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean csx()
  {
    AppMethodBeat.i(112734);
    if ((csQ() != null) && (csQ().nHh == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean csy()
  {
    AppMethodBeat.i(112735);
    if ((csQ() != null) && (csQ().nHh == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean csz()
  {
    AppMethodBeat.i(112736);
    if ((csQ() != null) && (csQ().nHh == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final String cta()
  {
    AppMethodBeat.i(112763);
    Log.d("MicroMsg.CardInfo", "encrypt_code:" + this.pSa);
    String str = this.pSa;
    AppMethodBeat.o(112763);
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
    AppMethodBeat.i(112748);
    if (!csM())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.pTh != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.pTh.LeX);
    }
    Log.i("MicroMsg.CardInfo", "stock_num:" + this.pTi.Lct + " limit_num:" + this.pTi.Lcu);
    if ((this.pTh != null) && (this.pTh.LeX == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.pTh != null) && (this.pTh.LeX == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.pTi.Lct == 0L) || (this.pTi.Lcu == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    AppMethodBeat.o(112748);
    return false;
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