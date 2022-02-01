package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gb;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends gb
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static c.a info;
  public String nUu;
  public ry nVC;
  public qy nVD;
  public cyg nVE;
  public rr nVF;
  public boolean nVG;
  
  static
  {
    AppMethodBeat.i(112765);
    c.a locala = new c.a();
    locala.GvF = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.GvH.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.GvH.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.GvH.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "delete_state_flag";
    locala.GvH.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "local_updateTime";
    locala.GvH.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateSeq";
    locala.GvH.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "create_time";
    locala.GvH.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.GvH.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.GvH.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "block_mask";
    locala.GvH.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "dataInfoData";
    locala.GvH.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "cardTpInfoData";
    locala.GvH.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareInfoData";
    locala.GvH.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shopInfoData";
    locala.GvH.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "stickyIndex";
    locala.GvH.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "stickyEndTime";
    locala.GvH.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "stickyAnnouncement";
    locala.GvH.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "card_type";
    locala.GvH.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "label_wording";
    locala.GvH.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "is_dynamic";
    locala.GvH.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.nVG = true;
    this.nUu = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.nVG = true;
    this.nUu = "";
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
  
  public final void Ut(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(cyg paramcyg)
  {
    AppMethodBeat.i(112756);
    this.nVE = paramcyg;
    if (paramcyg != null) {}
    try
    {
      this.field_shareInfoData = paramcyg.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramcyg)
    {
      ac.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramcyg.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", paramcyg, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(qy paramqy)
  {
    AppMethodBeat.i(112754);
    this.nVD = paramqy;
    if (this.nVD != null)
    {
      this.field_status = this.nVD.status;
      if (paramqy != null) {}
      try
      {
        this.field_dataInfoData = paramqy.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramqy)
      {
        ac.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramqy.getMessage() });
        ac.printErrStackTrace("MicroMsg.CardInfo", paramqy, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(rr paramrr)
  {
    AppMethodBeat.i(112758);
    this.nVF = paramrr;
    if (paramrr != null) {}
    try
    {
      this.field_shopInfoData = paramrr.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramrr)
    {
      ac.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramrr.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", paramrr, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(ry paramry)
  {
    AppMethodBeat.i(112752);
    this.nVC = paramry;
    if (paramry != null) {}
    try
    {
      this.field_cardTpInfoData = paramry.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramry)
    {
      ac.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramry.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final boolean bON()
  {
    AppMethodBeat.i(112761);
    if ((bPi() != null) && (bPi().EkG == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean bOO()
  {
    AppMethodBeat.i(112762);
    if ((bPi() != null) && (bPi().EkG == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean bOP()
  {
    AppMethodBeat.i(112734);
    if ((bPi() != null) && (bPi().lRv == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean bOQ()
  {
    AppMethodBeat.i(112735);
    if ((bPi() != null) && (bPi().lRv == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean bOR()
  {
    AppMethodBeat.i(112736);
    if ((bPi() != null) && (bPi().lRv == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean bOS()
  {
    AppMethodBeat.i(112737);
    if ((bPi() != null) && (bPi().lRv == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean bOT()
  {
    AppMethodBeat.i(112738);
    if ((bPi() != null) && (bPi().lRv == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean bOU()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.zG(bPi().lRv);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean bOV()
  {
    AppMethodBeat.i(112740);
    if ((bPi().Ekw & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean bOW()
  {
    AppMethodBeat.i(112741);
    if ((bPi().Ekw & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean bOX()
  {
    AppMethodBeat.i(112742);
    if ((bPi().Ekz & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean bOY()
  {
    AppMethodBeat.i(112743);
    if ((bPi().Ekz & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean bOZ()
  {
    AppMethodBeat.i(112744);
    if ((bPi().Ekz & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean bPa()
  {
    AppMethodBeat.i(112745);
    if ((bPi().Ekz & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean bPb()
  {
    AppMethodBeat.i(112746);
    if ((bPi().Ekz & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean bPc()
  {
    AppMethodBeat.i(112747);
    if ((bPi().Ekz & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean bPd()
  {
    AppMethodBeat.i(112764);
    if ((bPi() != null) && (bPi().EkL == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean bPe()
  {
    return (this.nVD != null) && (this.nVD.status == 0);
  }
  
  public final boolean bPf()
  {
    AppMethodBeat.i(112749);
    if (!bPe())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.nVC != null) {
      ac.i("MicroMsg.CardInfo", "is_acceptable:" + this.nVC.EkM);
    }
    ac.i("MicroMsg.CardInfo", "avail_num:" + this.nVD.Eie);
    if ((this.nVC != null) && (this.nVC.EkM == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.nVD.Eie > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.nVC != null) && (this.nVC.EkM == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.nVD.Eie == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean bPg()
  {
    AppMethodBeat.i(112750);
    if ((this.nVC == null) || (this.nVC.EkD == null) || (TextUtils.isEmpty(this.nVC.EkD.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    rn localrn = this.nVC.EkD;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localrn.xxQ;
    if ((localrn.xxQ > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean bPh()
  {
    return (this.nVC != null) && (this.nVC.EkQ == 1);
  }
  
  public final ry bPi()
  {
    AppMethodBeat.i(112751);
    ry localry1;
    if (this.nVC != null)
    {
      localry1 = this.nVC;
      AppMethodBeat.o(112751);
      return localry1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.nVC = ((ry)new ry().parseFrom(this.field_cardTpInfoData));
        localry1 = this.nVC;
        AppMethodBeat.o(112751);
        return localry1;
      }
      localry1 = new ry();
      AppMethodBeat.o(112751);
      return localry1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ry localry2 = new ry();
      AppMethodBeat.o(112751);
      return localry2;
    }
  }
  
  public final qy bPj()
  {
    AppMethodBeat.i(112753);
    qy localqy1;
    if (this.nVD != null)
    {
      localqy1 = this.nVD;
      AppMethodBeat.o(112753);
      return localqy1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.nVD = ((qy)new qy().parseFrom(this.field_dataInfoData));
        localqy1 = this.nVD;
        AppMethodBeat.o(112753);
        return localqy1;
      }
      localqy1 = new qy();
      AppMethodBeat.o(112753);
      return localqy1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      qy localqy2 = new qy();
      AppMethodBeat.o(112753);
      return localqy2;
    }
  }
  
  public final cyg bPk()
  {
    AppMethodBeat.i(112755);
    cyg localcyg1;
    if (this.nVE != null)
    {
      localcyg1 = this.nVE;
      AppMethodBeat.o(112755);
      return localcyg1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.nVE = ((cyg)new cyg().parseFrom(this.field_shareInfoData));
        localcyg1 = this.nVE;
        AppMethodBeat.o(112755);
        return localcyg1;
      }
      localcyg1 = new cyg();
      AppMethodBeat.o(112755);
      return localcyg1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      cyg localcyg2 = new cyg();
      AppMethodBeat.o(112755);
      return localcyg2;
    }
  }
  
  public final rr bPl()
  {
    AppMethodBeat.i(112757);
    rr localrr;
    if (this.nVF != null)
    {
      localrr = this.nVF;
      AppMethodBeat.o(112757);
      return localrr;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.nVF = ((rr)new rr().parseFrom(this.field_shopInfoData));
        localrr = this.nVF;
        AppMethodBeat.o(112757);
        return localrr;
      }
      AppMethodBeat.o(112757);
      return null;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(112757);
    }
    return null;
  }
  
  public final String bPm()
  {
    return this.field_card_id;
  }
  
  public final String bPn()
  {
    return this.field_card_tp_id;
  }
  
  public final String bPo()
  {
    return this.field_from_username;
  }
  
  public final long bPp()
  {
    return this.field_local_updateTime;
  }
  
  public final String bPq()
  {
    return null;
  }
  
  public final int bPr()
  {
    return 0;
  }
  
  public final String bPs()
  {
    AppMethodBeat.i(112763);
    ac.d("MicroMsg.CardInfo", "encrypt_code:" + this.nUu);
    String str = this.nUu;
    AppMethodBeat.o(112763);
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
    AppMethodBeat.i(112748);
    if (!bPe())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.nVC != null) {
      ac.i("MicroMsg.CardInfo", "is_acceptable:" + this.nVC.EkM);
    }
    ac.i("MicroMsg.CardInfo", "stock_num:" + this.nVD.Eih + " limit_num:" + this.nVD.Eii);
    if ((this.nVC != null) && (this.nVC.EkM == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.nVC != null) && (this.nVC.EkM == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.nVD.Eih == 0L) || (this.nVD.Eii == 0))
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
  
  public final String zE(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */