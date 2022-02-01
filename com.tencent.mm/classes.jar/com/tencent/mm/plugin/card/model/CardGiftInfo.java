package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.as;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.cgk;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String footerWording;
  public String hHa;
  public boolean hPp;
  public String hYg;
  public String nRQ;
  public String wsN;
  public String wsO;
  public String wsP;
  public String wsQ;
  public String wsR;
  public String wsS;
  public String wsT;
  public String wsU;
  public String wsV;
  public String wsW;
  public String wsX;
  public String wsY;
  public int wsZ;
  public String wtA;
  public String wtB;
  public String wtC;
  public int wta;
  public int wtb;
  public String wtc;
  public String wtd;
  public int wte;
  public String wtf;
  public String wtg;
  public String wth;
  public String wti;
  public String wtj;
  public String wtk;
  public String wtl;
  public String wtm;
  public String wtn;
  public LinkedList<AcceptedCardItem> wto;
  public LinkedList<AccepterItem> wtp;
  public String wtq;
  public int wtr;
  public String wts;
  public String wtt;
  public String wtu;
  public String wtv;
  public String wtw;
  public String wtx;
  public int wty;
  public String wtz;
  
  static
  {
    AppMethodBeat.i(112732);
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112732);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(112726);
    this.wto = new LinkedList();
    this.wtp = new LinkedList();
    AppMethodBeat.o(112726);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112727);
    this.wto = new LinkedList();
    this.wtp = new LinkedList();
    this.hHa = paramParcel.readString();
    this.hYg = paramParcel.readString();
    this.wsN = paramParcel.readString();
    this.wsO = paramParcel.readString();
    this.wsP = paramParcel.readString();
    this.wsQ = paramParcel.readString();
    this.wsR = paramParcel.readString();
    this.wsS = paramParcel.readString();
    this.wsT = paramParcel.readString();
    this.wsU = paramParcel.readString();
    this.wsV = paramParcel.readString();
    this.wsW = paramParcel.readString();
    this.wsX = paramParcel.readString();
    this.wsY = paramParcel.readString();
    this.footerWording = paramParcel.readString();
    this.nRQ = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hPp = bool;
      this.wsZ = paramParcel.readInt();
      this.wta = paramParcel.readInt();
      this.wtb = paramParcel.readInt();
      this.wtc = paramParcel.readString();
      this.wtd = paramParcel.readString();
      this.wte = paramParcel.readInt();
      this.wtf = paramParcel.readString();
      this.wtg = paramParcel.readString();
      this.wth = paramParcel.readString();
      this.wti = paramParcel.readString();
      this.wtj = paramParcel.readString();
      this.wtk = paramParcel.readString();
      this.wtl = paramParcel.readString();
      this.wtm = paramParcel.readString();
      this.wtn = paramParcel.readString();
      paramParcel.readTypedList(this.wto, AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.wtp, AccepterItem.CREATOR);
      this.wtq = paramParcel.readString();
      this.wtr = paramParcel.readInt();
      this.wts = paramParcel.readString();
      this.wtt = paramParcel.readString();
      this.wtt = paramParcel.readString();
      this.wtu = paramParcel.readString();
      this.wtv = paramParcel.readString();
      this.wtw = paramParcel.readString();
      this.wtx = paramParcel.readString();
      this.wty = paramParcel.readInt();
      this.wtz = paramParcel.readString();
      this.wtA = paramParcel.readString();
      this.wtB = paramParcel.readString();
      this.wtC = paramParcel.readString();
      AppMethodBeat.o(112727);
      return;
    }
  }
  
  public static CardGiftInfo a(as paramas)
  {
    AppMethodBeat.i(112730);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.hHa = paramas.YBk;
    localCardGiftInfo.hYg = paramas.YBl;
    localCardGiftInfo.wsN = paramas.YBm;
    localCardGiftInfo.wsO = paramas.content;
    localCardGiftInfo.wsP = paramas.YBn;
    localCardGiftInfo.wsQ = paramas.YBo;
    localCardGiftInfo.wsR = paramas.YBp;
    localCardGiftInfo.wsS = paramas.YBq;
    localCardGiftInfo.wsU = paramas.YBs;
    localCardGiftInfo.wsT = paramas.YBr;
    localCardGiftInfo.wsV = paramas.YBt;
    localCardGiftInfo.wsW = paramas.YBu;
    localCardGiftInfo.wsX = paramas.wtD;
    localCardGiftInfo.wsY = paramas.wtE;
    localCardGiftInfo.footerWording = paramas.YBv;
    localCardGiftInfo.nRQ = paramas.nRQ;
    localCardGiftInfo.hPp = paramas.YBw;
    localCardGiftInfo.wsZ = paramas.YBx;
    localCardGiftInfo.wta = paramas.YBy;
    localCardGiftInfo.wtb = paramas.YBz;
    localCardGiftInfo.wtc = paramas.YBA;
    localCardGiftInfo.wtd = paramas.YBB;
    localCardGiftInfo.wte = paramas.YBC;
    localCardGiftInfo.wtf = paramas.YBD;
    localCardGiftInfo.wtg = paramas.YBE;
    localCardGiftInfo.wth = paramas.YBF;
    localCardGiftInfo.wti = paramas.YBG;
    localCardGiftInfo.wtj = paramas.YBH;
    localCardGiftInfo.wtk = paramas.YBI;
    localCardGiftInfo.wtl = paramas.YBJ;
    localCardGiftInfo.wtm = paramas.wsy;
    localCardGiftInfo.wtn = paramas.YBK;
    Iterator localIterator = paramas.wto.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (av)localIterator.next();
      localLinkedList = localCardGiftInfo.wto;
      localObject2 = new AcceptedCardItem();
      ((AcceptedCardItem)localObject2).wtE = ((av)localObject1).wtE;
      ((AcceptedCardItem)localObject2).wtD = ((av)localObject1).wtD;
      localLinkedList.add(localObject2);
    }
    localIterator = paramas.wtp.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (aw)localIterator.next();
      localLinkedList = localCardGiftInfo.wtp;
      localObject2 = new AccepterItem();
      ((AccepterItem)localObject2).wtE = ((aw)localObject1).wtE;
      ((AccepterItem)localObject2).wtD = ((aw)localObject1).wtD;
      ((AccepterItem)localObject2).wtG = ((aw)localObject1).wtG;
      ((AccepterItem)localObject2).wtF = ((aw)localObject1).wtF;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.wtq = paramas.wtq;
    localCardGiftInfo.wtr = paramas.wtr;
    localCardGiftInfo.wts = paramas.wts;
    localCardGiftInfo.wtt = paramas.wtt;
    localCardGiftInfo.wtu = paramas.wtu;
    localCardGiftInfo.wtv = paramas.wtv;
    localCardGiftInfo.wtw = paramas.wtw;
    localCardGiftInfo.wtx = paramas.wtx;
    localCardGiftInfo.wty = paramas.wty;
    localCardGiftInfo.wtz = paramas.wtz;
    localCardGiftInfo.wtB = paramas.wtB;
    localCardGiftInfo.wtA = paramas.wtA;
    localCardGiftInfo.wtC = paramas.wtC;
    AppMethodBeat.o(112730);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(cgk paramcgk)
  {
    AppMethodBeat.i(112731);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.hHa = paramcgk.YBk;
    localCardGiftInfo.hYg = paramcgk.YBl;
    localCardGiftInfo.wsN = paramcgk.YBm;
    localCardGiftInfo.wsO = paramcgk.content;
    localCardGiftInfo.wsP = paramcgk.YBn;
    localCardGiftInfo.wsQ = paramcgk.YBo;
    localCardGiftInfo.wsR = paramcgk.YBp;
    localCardGiftInfo.wsS = paramcgk.YBq;
    localCardGiftInfo.wsU = paramcgk.YBs;
    localCardGiftInfo.wsT = paramcgk.YBr;
    localCardGiftInfo.wsV = paramcgk.YBt;
    localCardGiftInfo.wsW = paramcgk.YBu;
    localCardGiftInfo.wsX = paramcgk.wtD;
    localCardGiftInfo.wsY = paramcgk.wtE;
    localCardGiftInfo.footerWording = paramcgk.YBv;
    localCardGiftInfo.nRQ = paramcgk.nRQ;
    localCardGiftInfo.hPp = paramcgk.YBw;
    localCardGiftInfo.wsZ = paramcgk.YBx;
    localCardGiftInfo.wta = paramcgk.YBy;
    localCardGiftInfo.wtb = paramcgk.YBz;
    localCardGiftInfo.wtc = paramcgk.YBA;
    localCardGiftInfo.wtd = paramcgk.YBB;
    localCardGiftInfo.wte = paramcgk.aapx;
    localCardGiftInfo.wtf = paramcgk.YBD;
    localCardGiftInfo.wtg = paramcgk.YBE;
    localCardGiftInfo.wth = paramcgk.YBF;
    localCardGiftInfo.wti = paramcgk.YBG;
    localCardGiftInfo.wtj = paramcgk.YBH;
    localCardGiftInfo.wtk = paramcgk.YBI;
    localCardGiftInfo.wtl = paramcgk.YBJ;
    localCardGiftInfo.wtm = paramcgk.wsy;
    localCardGiftInfo.wtn = paramcgk.YBK;
    localCardGiftInfo.wts = paramcgk.wts;
    localCardGiftInfo.wtt = paramcgk.wtt;
    localCardGiftInfo.wtu = paramcgk.wtu;
    localCardGiftInfo.wtv = paramcgk.wtv;
    localCardGiftInfo.wtw = paramcgk.wtw;
    localCardGiftInfo.wtx = paramcgk.wtx;
    localCardGiftInfo.wty = paramcgk.wty;
    localCardGiftInfo.wtz = paramcgk.wtz;
    localCardGiftInfo.wtB = paramcgk.wtB;
    localCardGiftInfo.wtA = paramcgk.wtA;
    localCardGiftInfo.wtC = paramcgk.wtC;
    AppMethodBeat.o(112731);
    return localCardGiftInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(112729);
    String str = "CardGiftInfo{toUserName='" + this.hHa + '\'' + ", fromUserName='" + this.hYg + '\'' + ", fromUserImgUrl='" + this.wsN + '\'' + ", fromUserContent='" + this.wsO + '\'' + ", fromUserContentPicUrl='" + this.wsP + '\'' + ", fromUserContentVideoUrl='" + this.wsQ + '\'' + ", fromUserContentThumbPicUrl='" + this.wsR + '\'' + ", picAESKey='" + this.wsS + '\'' + ", videoAESKey='" + this.wsT + '\'' + ", thumbVideoAESKey='" + this.wsU + '\'' + ", cardBackgroundPicUrl='" + this.wsV + '\'' + ", cardLogoLUrl='" + this.wsW + '\'' + ", cardTitle='" + this.wsX + '\'' + ", cardPrice='" + this.wsY + '\'' + ", footerWording='" + this.footerWording + '\'' + ", color='" + this.nRQ + '\'' + ", needJump=" + this.hPp + ", picDataLength=" + this.wsZ + ", videoDataLength=" + this.wta + ", thumbDataLength=" + this.wtb + ", descTitle='" + this.wtc + '\'' + ", descIconUrl='" + this.wtd + '\'' + ", descLayoutMode=" + this.wte + ", giftingMediaTitle='" + this.wtf + '\'' + ", descriptionTitleColor='" + this.wtg + '\'' + ", cardTitleColor='" + this.wth + '\'' + ", cardPriceTitleColor='" + this.wti + '\'' + ", userCardId='" + this.wtj + '\'' + ", operationTitle='" + this.wtk + '\'' + ", operationUrl='" + this.wtl + '\'' + ", cardTpId='" + this.wtm + '\'' + ", cardCode='" + this.wtn + '\'' + ", accepted_card_list_size='" + this.wto.size() + '\'' + ", accepter_list_size='" + this.wtp.size() + '\'' + ", accepter_list_title='" + this.wtq + '\'' + ", out_of_card='" + this.wtr + '\'' + ", operation_wxa_username='" + this.wts + '\'' + ", operation_wxa_path='" + this.wtt + '\'' + '}';
    AppMethodBeat.o(112729);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(112728);
    paramParcel.writeString(this.hHa);
    paramParcel.writeString(this.hYg);
    paramParcel.writeString(this.wsN);
    paramParcel.writeString(this.wsO);
    paramParcel.writeString(this.wsP);
    paramParcel.writeString(this.wsQ);
    paramParcel.writeString(this.wsR);
    paramParcel.writeString(this.wsS);
    paramParcel.writeString(this.wsT);
    paramParcel.writeString(this.wsU);
    paramParcel.writeString(this.wsV);
    paramParcel.writeString(this.wsW);
    paramParcel.writeString(this.wsX);
    paramParcel.writeString(this.wsY);
    paramParcel.writeString(this.footerWording);
    paramParcel.writeString(this.nRQ);
    if (this.hPp) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.wsZ);
      paramParcel.writeInt(this.wta);
      paramParcel.writeInt(this.wtb);
      paramParcel.writeString(this.wtc);
      paramParcel.writeString(this.wtd);
      paramParcel.writeInt(this.wte);
      paramParcel.writeString(this.wtf);
      paramParcel.writeString(this.wtg);
      paramParcel.writeString(this.wth);
      paramParcel.writeString(this.wti);
      paramParcel.writeString(this.wtj);
      paramParcel.writeString(this.wtk);
      paramParcel.writeString(this.wtl);
      paramParcel.writeString(this.wtm);
      paramParcel.writeString(this.wtn);
      paramParcel.writeTypedList(this.wto);
      paramParcel.writeTypedList(this.wtp);
      paramParcel.writeString(this.wtq);
      paramParcel.writeInt(this.wtr);
      paramParcel.writeString(this.wts);
      paramParcel.writeString(this.wtt);
      paramParcel.writeString(this.wtt);
      paramParcel.writeString(this.wtu);
      paramParcel.writeString(this.wtv);
      paramParcel.writeString(this.wtw);
      paramParcel.writeString(this.wtx);
      paramParcel.writeInt(this.wty);
      paramParcel.writeString(this.wtz);
      paramParcel.writeString(this.wtA);
      paramParcel.writeString(this.wtB);
      paramParcel.writeString(this.wtC);
      AppMethodBeat.o(112728);
      return;
    }
  }
  
  public static class AcceptedCardItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AcceptedCardItem> CREATOR;
    public String wtD;
    public String wtE;
    
    static
    {
      AppMethodBeat.i(112721);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(112721);
    }
    
    public AcceptedCardItem() {}
    
    private AcceptedCardItem(Parcel paramParcel)
    {
      AppMethodBeat.i(112719);
      this.wtD = paramParcel.readString();
      this.wtE = paramParcel.readString();
      AppMethodBeat.o(112719);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112720);
      paramParcel.writeString(this.wtD);
      paramParcel.writeString(this.wtE);
      AppMethodBeat.o(112720);
    }
  }
  
  public static class AccepterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<AccepterItem> CREATOR;
    public String wtD;
    public String wtE;
    public String wtF;
    public String wtG;
    
    static
    {
      AppMethodBeat.i(112725);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(112725);
    }
    
    public AccepterItem() {}
    
    private AccepterItem(Parcel paramParcel)
    {
      AppMethodBeat.i(112723);
      this.wtD = paramParcel.readString();
      this.wtE = paramParcel.readString();
      this.wtF = paramParcel.readString();
      this.wtG = paramParcel.readString();
      AppMethodBeat.o(112723);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(112724);
      paramParcel.writeString(this.wtD);
      paramParcel.writeString(this.wtE);
      paramParcel.writeString(this.wtF);
      paramParcel.writeString(this.wtG);
      AppMethodBeat.o(112724);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */