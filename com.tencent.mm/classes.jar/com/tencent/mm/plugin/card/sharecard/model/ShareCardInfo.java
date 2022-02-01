package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fi;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.protocal.protobuf.rn;
import com.tencent.mm.protocal.protobuf.rr;
import com.tencent.mm.protocal.protobuf.ry;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends fi
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static c.a info;
  public String nUu;
  public ry nVC;
  public qy nVD;
  public cyg nVE;
  public rr nVF;
  public boolean nVG;
  
  static
  {
    AppMethodBeat.i(113011);
    c.a locala = new c.a();
    locala.GvF = new Field[19];
    locala.columns = new String[20];
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
    locala.columns[3] = "consumer";
    locala.GvH.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.GvH.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.GvH.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.GvH.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.GvH.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.GvH.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.GvH.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.GvH.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.GvH.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.GvH.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.GvH.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.GvH.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.GvH.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.GvH.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.GvH.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.nVG = true;
    this.nUu = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.nVG = true;
    this.nUu = "";
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
  
  public final void Ut(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(cyg paramcyg)
  {
    AppMethodBeat.i(113001);
    this.nVE = paramcyg;
    try
    {
      this.field_shareInfoData = paramcyg.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramcyg)
    {
      ac.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramcyg.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", paramcyg, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(qy paramqy)
  {
    AppMethodBeat.i(112999);
    this.nVD = paramqy;
    if (this.nVD != null) {
      try
      {
        this.field_dataInfoData = paramqy.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramqy)
      {
        ac.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramqy.getMessage() });
        ac.printErrStackTrace("MicroMsg.ShareCardInfo", paramqy, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(rr paramrr)
  {
    AppMethodBeat.i(113003);
    this.nVF = paramrr;
    try
    {
      this.field_shopInfoData = paramrr.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramrr)
    {
      ac.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramrr.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", paramrr, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(ry paramry)
  {
    AppMethodBeat.i(112997);
    this.nVC = paramry;
    try
    {
      this.field_cardTpInfoData = paramry.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramry)
    {
      ac.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramry.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final boolean bON()
  {
    AppMethodBeat.i(113006);
    if ((bPi() != null) && (bPi().EkG == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean bOO()
  {
    AppMethodBeat.i(113007);
    if ((bPi() != null) && (bPi().EkG == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean bOP()
  {
    AppMethodBeat.i(112980);
    if ((bPi() != null) && (bPi().lRv == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean bOQ()
  {
    AppMethodBeat.i(112981);
    if ((bPi() != null) && (bPi().lRv == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean bOR()
  {
    AppMethodBeat.i(112982);
    if ((bPi() != null) && (bPi().lRv == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean bOS()
  {
    AppMethodBeat.i(112983);
    if ((bPi() != null) && (bPi().lRv == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean bOT()
  {
    AppMethodBeat.i(112984);
    if ((bPi() != null) && (bPi().lRv == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean bOU()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.zG(bPi().lRv);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean bOV()
  {
    AppMethodBeat.i(112986);
    if ((bPi().Ekw & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean bOW()
  {
    AppMethodBeat.i(112987);
    if ((bPi().Ekw & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean bOX()
  {
    AppMethodBeat.i(112988);
    if ((bPi().Ekz & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean bOY()
  {
    AppMethodBeat.i(112989);
    if ((bPi().Ekz & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean bOZ()
  {
    AppMethodBeat.i(112990);
    if ((bPi().Ekz & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean bPa()
  {
    return false;
  }
  
  public final boolean bPb()
  {
    AppMethodBeat.i(112991);
    if ((bPi().Ekz & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean bPc()
  {
    AppMethodBeat.i(112992);
    if ((bPi().Ekz & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean bPd()
  {
    AppMethodBeat.i(113010);
    if ((bPi() != null) && (bPi().EkL == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean bPe()
  {
    return (this.nVD != null) && (this.nVD.status == 0);
  }
  
  public final boolean bPf()
  {
    AppMethodBeat.i(112994);
    if (!bPe())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.nVC != null) {
      ac.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.nVC.EkM);
    }
    ac.i("MicroMsg.ShareCardInfo", "avail_num:" + this.nVD.Eie);
    if ((this.nVC != null) && (this.nVC.EkM == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.nVD.Eie > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.nVC != null) && (this.nVC.EkM == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.nVD.Eie == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean bPg()
  {
    AppMethodBeat.i(112995);
    if ((this.nVC == null) || (this.nVC.EkD == null) || (TextUtils.isEmpty(this.nVC.EkD.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    rn localrn = this.nVC.EkD;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localrn.xxQ;
    if ((localrn.xxQ > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean bPh()
  {
    return (this.nVC != null) && (this.nVC.EkQ == 1);
  }
  
  public final ry bPi()
  {
    AppMethodBeat.i(112996);
    ry localry1;
    if (this.nVC != null)
    {
      localry1 = this.nVC;
      AppMethodBeat.o(112996);
      return localry1;
    }
    try
    {
      this.nVC = ((ry)new ry().parseFrom(this.field_cardTpInfoData));
      localry1 = this.nVC;
      AppMethodBeat.o(112996);
      return localry1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ry localry2 = new ry();
      AppMethodBeat.o(112996);
      return localry2;
    }
  }
  
  public final qy bPj()
  {
    AppMethodBeat.i(112998);
    qy localqy1;
    if (this.nVD != null)
    {
      localqy1 = this.nVD;
      AppMethodBeat.o(112998);
      return localqy1;
    }
    try
    {
      this.nVD = ((qy)new qy().parseFrom(this.field_dataInfoData));
      localqy1 = this.nVD;
      AppMethodBeat.o(112998);
      return localqy1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      qy localqy2 = new qy();
      AppMethodBeat.o(112998);
      return localqy2;
    }
  }
  
  public final cyg bPk()
  {
    AppMethodBeat.i(113000);
    cyg localcyg1;
    if (this.nVE != null)
    {
      localcyg1 = this.nVE;
      AppMethodBeat.o(113000);
      return localcyg1;
    }
    try
    {
      this.nVE = ((cyg)new cyg().parseFrom(this.field_shareInfoData));
      localcyg1 = this.nVE;
      AppMethodBeat.o(113000);
      return localcyg1;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      cyg localcyg2 = new cyg();
      AppMethodBeat.o(113000);
      return localcyg2;
    }
  }
  
  public final rr bPl()
  {
    AppMethodBeat.i(113002);
    rr localrr;
    if (this.nVF != null)
    {
      localrr = this.nVF;
      AppMethodBeat.o(113002);
      return localrr;
    }
    try
    {
      this.nVF = ((rr)new rr().parseFrom(this.field_shopInfoData));
      localrr = this.nVF;
      AppMethodBeat.o(113002);
      return localrr;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ac.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
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
    return "";
  }
  
  public final int bPr()
  {
    return this.field_categoryType;
  }
  
  public final String bPs()
  {
    AppMethodBeat.i(113009);
    ac.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.nUu);
    String str = this.nUu;
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
    if (!bPe())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.nVC != null) {
      ac.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.nVC.EkM);
    }
    ac.i("MicroMsg.ShareCardInfo", "stock_num:" + this.nVD.Eih + " limit_num:" + this.nVD.Eii);
    if ((this.nVC != null) && (this.nVC.EkM == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.nVC != null) && (this.nVC.EkM == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.nVD.Eih == 0L) || (this.nVD.Eii == 0))
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
  
  public final String zE(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.bQn().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.bQN())
      {
        str = ai.getResources().getString(2131756965);
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