package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ft;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.den;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tj;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.protocal.protobuf.tu;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends ft
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static c.a info;
  public String oEr;
  public st oFA;
  public den oFB;
  public tn oFC;
  public boolean oFD;
  public tu oFz;
  
  static
  {
    AppMethodBeat.i(113011);
    c.a locala = new c.a();
    locala.IBL = new Field[19];
    locala.columns = new String[20];
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
    locala.columns[3] = "consumer";
    locala.IBN.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.IBN.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.IBN.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.IBN.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.IBN.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.IBN.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.IBN.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.IBN.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.IBN.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.IBN.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.IBN.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.IBN.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.IBN.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.IBN.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.IBN.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(113011);
  }
  
  public ShareCardInfo()
  {
    this.oFD = true;
    this.oEr = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(113004);
    this.oFD = true;
    this.oEr = "";
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
  
  public final String Az(int paramInt)
  {
    AppMethodBeat.i(113008);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.bWh().getValue("key_share_card_local_city");
      AppMethodBeat.o(113008);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.bWH())
      {
        str = ak.getResources().getString(2131756965);
        AppMethodBeat.o(113008);
        return str;
      }
      AppMethodBeat.o(113008);
      return "";
    }
    AppMethodBeat.o(113008);
    return "";
  }
  
  public final void YT(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(den paramden)
  {
    AppMethodBeat.i(113001);
    this.oFB = paramden;
    try
    {
      this.field_shareInfoData = paramden.toByteArray();
      AppMethodBeat.o(113001);
      return;
    }
    catch (Exception paramden)
    {
      ae.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramden.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", paramden, "", new Object[0]);
      AppMethodBeat.o(113001);
    }
  }
  
  public final void a(st paramst)
  {
    AppMethodBeat.i(112999);
    this.oFA = paramst;
    if (this.oFA != null) {
      try
      {
        this.field_dataInfoData = paramst.toByteArray();
        AppMethodBeat.o(112999);
        return;
      }
      catch (Exception paramst)
      {
        ae.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramst.getMessage() });
        ae.printErrStackTrace("MicroMsg.ShareCardInfo", paramst, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112999);
  }
  
  public final void a(tn paramtn)
  {
    AppMethodBeat.i(113003);
    this.oFC = paramtn;
    try
    {
      this.field_shopInfoData = paramtn.toByteArray();
      AppMethodBeat.o(113003);
      return;
    }
    catch (Exception paramtn)
    {
      ae.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramtn.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", paramtn, "", new Object[0]);
      AppMethodBeat.o(113003);
    }
  }
  
  public final void a(tu paramtu)
  {
    AppMethodBeat.i(112997);
    this.oFz = paramtu;
    try
    {
      this.field_cardTpInfoData = paramtu.toByteArray();
      AppMethodBeat.o(112997);
      return;
    }
    catch (Exception paramtu)
    {
      ae.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramtu.getMessage() });
      AppMethodBeat.o(112997);
    }
  }
  
  public final boolean bUH()
  {
    AppMethodBeat.i(113006);
    if ((bVc() != null) && (bVc().Gko == 0))
    {
      AppMethodBeat.o(113006);
      return true;
    }
    AppMethodBeat.o(113006);
    return false;
  }
  
  public final boolean bUI()
  {
    AppMethodBeat.i(113007);
    if ((bVc() != null) && (bVc().Gko == 1))
    {
      AppMethodBeat.o(113007);
      return true;
    }
    AppMethodBeat.o(113007);
    return false;
  }
  
  public final boolean bUJ()
  {
    AppMethodBeat.i(112980);
    if ((bVc() != null) && (bVc().mwj == 10))
    {
      AppMethodBeat.o(112980);
      return true;
    }
    AppMethodBeat.o(112980);
    return false;
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(112981);
    if ((bVc() != null) && (bVc().mwj == 0))
    {
      AppMethodBeat.o(112981);
      return true;
    }
    AppMethodBeat.o(112981);
    return false;
  }
  
  public final boolean bUL()
  {
    AppMethodBeat.i(112982);
    if ((bVc() != null) && (bVc().mwj == 20))
    {
      AppMethodBeat.o(112982);
      return true;
    }
    AppMethodBeat.o(112982);
    return false;
  }
  
  public final boolean bUM()
  {
    AppMethodBeat.i(112983);
    if ((bVc() != null) && (bVc().mwj == 11))
    {
      AppMethodBeat.o(112983);
      return true;
    }
    AppMethodBeat.o(112983);
    return false;
  }
  
  public final boolean bUN()
  {
    AppMethodBeat.i(112984);
    if ((bVc() != null) && (bVc().mwj == 30))
    {
      AppMethodBeat.o(112984);
      return true;
    }
    AppMethodBeat.o(112984);
    return false;
  }
  
  public final boolean bUO()
  {
    AppMethodBeat.i(112985);
    boolean bool = l.AB(bVc().mwj);
    AppMethodBeat.o(112985);
    return bool;
  }
  
  public final boolean bUP()
  {
    AppMethodBeat.i(112986);
    if ((bVc().Gke & 0x2) == 0)
    {
      AppMethodBeat.o(112986);
      return true;
    }
    AppMethodBeat.o(112986);
    return false;
  }
  
  public final boolean bUQ()
  {
    AppMethodBeat.i(112987);
    if ((bVc().Gke & 0x1) == 0)
    {
      AppMethodBeat.o(112987);
      return true;
    }
    AppMethodBeat.o(112987);
    return false;
  }
  
  public final boolean bUR()
  {
    AppMethodBeat.i(112988);
    if ((bVc().Gkh & 1L) == 0L)
    {
      AppMethodBeat.o(112988);
      return true;
    }
    AppMethodBeat.o(112988);
    return false;
  }
  
  public final boolean bUS()
  {
    AppMethodBeat.i(112989);
    if ((bVc().Gkh & 0x10) == 0L)
    {
      AppMethodBeat.o(112989);
      return true;
    }
    AppMethodBeat.o(112989);
    return false;
  }
  
  public final boolean bUT()
  {
    AppMethodBeat.i(112990);
    if ((bVc().Gkh & 0x2) > 0L)
    {
      AppMethodBeat.o(112990);
      return true;
    }
    AppMethodBeat.o(112990);
    return false;
  }
  
  public final boolean bUU()
  {
    return false;
  }
  
  public final boolean bUV()
  {
    AppMethodBeat.i(112991);
    if ((bVc().Gkh & 0x4) > 0L)
    {
      AppMethodBeat.o(112991);
      return true;
    }
    AppMethodBeat.o(112991);
    return false;
  }
  
  public final boolean bUW()
  {
    AppMethodBeat.i(112992);
    if ((bVc().Gkh & 0x8) > 0L)
    {
      AppMethodBeat.o(112992);
      return true;
    }
    AppMethodBeat.o(112992);
    return false;
  }
  
  public final boolean bUX()
  {
    AppMethodBeat.i(113010);
    if ((bVc() != null) && (bVc().Gkt == 1))
    {
      AppMethodBeat.o(113010);
      return true;
    }
    AppMethodBeat.o(113010);
    return false;
  }
  
  public final boolean bUY()
  {
    return (this.oFA != null) && (this.oFA.status == 0);
  }
  
  public final boolean bUZ()
  {
    AppMethodBeat.i(112994);
    if (!bUY())
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.oFz != null) {
      ae.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.oFz.Gku);
    }
    ae.i("MicroMsg.ShareCardInfo", "avail_num:" + this.oFA.GhN);
    if ((this.oFz != null) && (this.oFz.Gku == 1))
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if (this.oFA.GhN > 0)
    {
      AppMethodBeat.o(112994);
      return true;
    }
    if ((this.oFz != null) && (this.oFz.Gku == 0))
    {
      AppMethodBeat.o(112994);
      return false;
    }
    if (this.oFA.GhN == 0)
    {
      AppMethodBeat.o(112994);
      return false;
    }
    AppMethodBeat.o(112994);
    return false;
  }
  
  public final boolean bVa()
  {
    AppMethodBeat.i(112995);
    if ((this.oFz == null) || (this.oFz.Gkl == null) || (TextUtils.isEmpty(this.oFz.Gkl.text)))
    {
      AppMethodBeat.o(112995);
      return false;
    }
    tj localtj = this.oFz.Gkl;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localtj.zcL;
    if ((localtj.zcL > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112995);
      return true;
    }
    AppMethodBeat.o(112995);
    return false;
  }
  
  public final boolean bVb()
  {
    return (this.oFz != null) && (this.oFz.Gky == 1);
  }
  
  public final tu bVc()
  {
    AppMethodBeat.i(112996);
    tu localtu1;
    if (this.oFz != null)
    {
      localtu1 = this.oFz;
      AppMethodBeat.o(112996);
      return localtu1;
    }
    try
    {
      this.oFz = ((tu)new tu().parseFrom(this.field_cardTpInfoData));
      localtu1 = this.oFz;
      AppMethodBeat.o(112996);
      return localtu1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      tu localtu2 = new tu();
      AppMethodBeat.o(112996);
      return localtu2;
    }
  }
  
  public final st bVd()
  {
    AppMethodBeat.i(112998);
    st localst1;
    if (this.oFA != null)
    {
      localst1 = this.oFA;
      AppMethodBeat.o(112998);
      return localst1;
    }
    try
    {
      this.oFA = ((st)new st().parseFrom(this.field_dataInfoData));
      localst1 = this.oFA;
      AppMethodBeat.o(112998);
      return localst1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      st localst2 = new st();
      AppMethodBeat.o(112998);
      return localst2;
    }
  }
  
  public final den bVe()
  {
    AppMethodBeat.i(113000);
    den localden1;
    if (this.oFB != null)
    {
      localden1 = this.oFB;
      AppMethodBeat.o(113000);
      return localden1;
    }
    try
    {
      this.oFB = ((den)new den().parseFrom(this.field_shareInfoData));
      localden1 = this.oFB;
      AppMethodBeat.o(113000);
      return localden1;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      den localden2 = new den();
      AppMethodBeat.o(113000);
      return localden2;
    }
  }
  
  public final tn bVf()
  {
    AppMethodBeat.i(113002);
    tn localtn;
    if (this.oFC != null)
    {
      localtn = this.oFC;
      AppMethodBeat.o(113002);
      return localtn;
    }
    try
    {
      this.oFC = ((tn)new tn().parseFrom(this.field_shopInfoData));
      localtn = this.oFC;
      AppMethodBeat.o(113002);
      return localtn;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ae.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(113002);
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
    return "";
  }
  
  public final int bVl()
  {
    return this.field_categoryType;
  }
  
  public final String bVm()
  {
    AppMethodBeat.i(113009);
    ae.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.oEr);
    String str = this.oEr;
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
    if (!bUY())
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if (this.oFz != null) {
      ae.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.oFz.Gku);
    }
    ae.i("MicroMsg.ShareCardInfo", "stock_num:" + this.oFA.GhQ + " limit_num:" + this.oFA.GhR);
    if ((this.oFz != null) && (this.oFz.Gku == 1))
    {
      AppMethodBeat.o(112993);
      return true;
    }
    if ((this.oFz != null) && (this.oFz.Gku == 0))
    {
      AppMethodBeat.o(112993);
      return false;
    }
    if ((this.oFA.GhQ == 0L) || (this.oFA.GhR == 0))
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