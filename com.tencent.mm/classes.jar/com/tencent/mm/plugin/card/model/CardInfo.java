package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gm;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends gm
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static c.a info;
  public String oEr;
  public st oFA;
  public den oFB;
  public tn oFC;
  public boolean oFD;
  public tu oFz;
  
  static
  {
    AppMethodBeat.i(112765);
    c.a locala = new c.a();
    locala.IBL = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.IBN.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.IBN.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.IBN.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "delete_state_flag";
    locala.IBN.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "local_updateTime";
    locala.IBN.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateSeq";
    locala.IBN.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "create_time";
    locala.IBN.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.IBN.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.IBN.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "block_mask";
    locala.IBN.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "dataInfoData";
    locala.IBN.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "cardTpInfoData";
    locala.IBN.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareInfoData";
    locala.IBN.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shopInfoData";
    locala.IBN.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "stickyIndex";
    locala.IBN.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "stickyEndTime";
    locala.IBN.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "stickyAnnouncement";
    locala.IBN.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "card_type";
    locala.IBN.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "label_wording";
    locala.IBN.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "is_dynamic";
    locala.IBN.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.oFD = true;
    this.oEr = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.oFD = true;
    this.oEr = "";
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
  
  public final String Az(int paramInt)
  {
    return null;
  }
  
  public final void YT(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(den paramden)
  {
    AppMethodBeat.i(112756);
    this.oFB = paramden;
    if (paramden != null) {}
    try
    {
      this.field_shareInfoData = paramden.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramden)
    {
      ae.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramden.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", paramden, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(st paramst)
  {
    AppMethodBeat.i(112754);
    this.oFA = paramst;
    if (this.oFA != null)
    {
      this.field_status = this.oFA.status;
      if (paramst != null) {}
      try
      {
        this.field_dataInfoData = paramst.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramst)
      {
        ae.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramst.getMessage() });
        ae.printErrStackTrace("MicroMsg.CardInfo", paramst, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(tn paramtn)
  {
    AppMethodBeat.i(112758);
    this.oFC = paramtn;
    if (paramtn != null) {}
    try
    {
      this.field_shopInfoData = paramtn.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramtn)
    {
      ae.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramtn.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", paramtn, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(tu paramtu)
  {
    AppMethodBeat.i(112752);
    this.oFz = paramtu;
    if (paramtu != null) {}
    try
    {
      this.field_cardTpInfoData = paramtu.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramtu)
    {
      ae.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramtu.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final boolean bUH()
  {
    AppMethodBeat.i(112761);
    if ((bVc() != null) && (bVc().Gko == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean bUI()
  {
    AppMethodBeat.i(112762);
    if ((bVc() != null) && (bVc().Gko == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean bUJ()
  {
    AppMethodBeat.i(112734);
    if ((bVc() != null) && (bVc().mwj == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(112735);
    if ((bVc() != null) && (bVc().mwj == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean bUL()
  {
    AppMethodBeat.i(112736);
    if ((bVc() != null) && (bVc().mwj == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean bUM()
  {
    AppMethodBeat.i(112737);
    if ((bVc() != null) && (bVc().mwj == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean bUN()
  {
    AppMethodBeat.i(112738);
    if ((bVc() != null) && (bVc().mwj == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean bUO()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.AB(bVc().mwj);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean bUP()
  {
    AppMethodBeat.i(112740);
    if ((bVc().Gke & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean bUQ()
  {
    AppMethodBeat.i(112741);
    if ((bVc().Gke & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean bUR()
  {
    AppMethodBeat.i(112742);
    if ((bVc().Gkh & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean bUS()
  {
    AppMethodBeat.i(112743);
    if ((bVc().Gkh & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean bUT()
  {
    AppMethodBeat.i(112744);
    if ((bVc().Gkh & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean bUU()
  {
    AppMethodBeat.i(112745);
    if ((bVc().Gkh & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean bUV()
  {
    AppMethodBeat.i(112746);
    if ((bVc().Gkh & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean bUW()
  {
    AppMethodBeat.i(112747);
    if ((bVc().Gkh & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean bUX()
  {
    AppMethodBeat.i(112764);
    if ((bVc() != null) && (bVc().Gkt == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean bUY()
  {
    return (this.oFA != null) && (this.oFA.status == 0);
  }
  
  public final boolean bUZ()
  {
    AppMethodBeat.i(112749);
    if (!bUY())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.oFz != null) {
      ae.i("MicroMsg.CardInfo", "is_acceptable:" + this.oFz.Gku);
    }
    ae.i("MicroMsg.CardInfo", "avail_num:" + this.oFA.GhN);
    if ((this.oFz != null) && (this.oFz.Gku == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.oFA.GhN > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.oFz != null) && (this.oFz.Gku == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.oFA.GhN == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean bVa()
  {
    AppMethodBeat.i(112750);
    if ((this.oFz == null) || (this.oFz.Gkl == null) || (TextUtils.isEmpty(this.oFz.Gkl.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    tj localtj = this.oFz.Gkl;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localtj.zcL;
    if ((localtj.zcL > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean bVb()
  {
    return (this.oFz != null) && (this.oFz.Gky == 1);
  }
  
  public final tu bVc()
  {
    AppMethodBeat.i(112751);
    tu localtu1;
    if (this.oFz != null)
    {
      localtu1 = this.oFz;
      AppMethodBeat.o(112751);
      return localtu1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.oFz = ((tu)new tu().parseFrom(this.field_cardTpInfoData));
        localtu1 = this.oFz;
        AppMethodBeat.o(112751);
        return localtu1;
      }
      localtu1 = new tu();
      AppMethodBeat.o(112751);
      return localtu1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      tu localtu2 = new tu();
      AppMethodBeat.o(112751);
      return localtu2;
    }
  }
  
  public final st bVd()
  {
    AppMethodBeat.i(112753);
    st localst1;
    if (this.oFA != null)
    {
      localst1 = this.oFA;
      AppMethodBeat.o(112753);
      return localst1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.oFA = ((st)new st().parseFrom(this.field_dataInfoData));
        localst1 = this.oFA;
        AppMethodBeat.o(112753);
        return localst1;
      }
      localst1 = new st();
      AppMethodBeat.o(112753);
      return localst1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      st localst2 = new st();
      AppMethodBeat.o(112753);
      return localst2;
    }
  }
  
  public final den bVe()
  {
    AppMethodBeat.i(112755);
    den localden1;
    if (this.oFB != null)
    {
      localden1 = this.oFB;
      AppMethodBeat.o(112755);
      return localden1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.oFB = ((den)new den().parseFrom(this.field_shareInfoData));
        localden1 = this.oFB;
        AppMethodBeat.o(112755);
        return localden1;
      }
      localden1 = new den();
      AppMethodBeat.o(112755);
      return localden1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      den localden2 = new den();
      AppMethodBeat.o(112755);
      return localden2;
    }
  }
  
  public final tn bVf()
  {
    AppMethodBeat.i(112757);
    tn localtn;
    if (this.oFC != null)
    {
      localtn = this.oFC;
      AppMethodBeat.o(112757);
      return localtn;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.oFC = ((tn)new tn().parseFrom(this.field_shopInfoData));
        localtn = this.oFC;
        AppMethodBeat.o(112757);
        return localtn;
      }
      AppMethodBeat.o(112757);
      return null;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(112757);
    }
    return null;
  }
  
  public final String bVg()
  {
    return this.field_card_id;
  }
  
  public final String bVh()
  {
    return this.field_card_tp_id;
  }
  
  public final String bVi()
  {
    return this.field_from_username;
  }
  
  public final long bVj()
  {
    return this.field_local_updateTime;
  }
  
  public final String bVk()
  {
    return null;
  }
  
  public final int bVl()
  {
    return 0;
  }
  
  public final String bVm()
  {
    AppMethodBeat.i(112763);
    ae.d("MicroMsg.CardInfo", "encrypt_code:" + this.oEr);
    String str = this.oEr;
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
    if (!bUY())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.oFz != null) {
      ae.i("MicroMsg.CardInfo", "is_acceptable:" + this.oFz.Gku);
    }
    ae.i("MicroMsg.CardInfo", "stock_num:" + this.oFA.GhQ + " limit_num:" + this.oFA.GhR);
    if ((this.oFz != null) && (this.oFz.Gku == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.oFz != null) && (this.oFz.Gku == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.oFA.GhQ == 0L) || (this.oFA.GhR == 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */