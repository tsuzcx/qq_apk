package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.adh;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.protocal.c.ap;
import com.tencent.mm.protocal.c.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR = new CardGiftInfo.1();
  public String bXl;
  public String color;
  public String ilE;
  public String ilF;
  public String ilG;
  public String ilH;
  public String ilI;
  public String ilJ;
  public String ilK;
  public String ilL;
  public String ilM;
  public String ilN;
  public String ilO;
  public String ilP;
  public String ilQ;
  public boolean ilR;
  public int ilS;
  public int ilT;
  public int ilU;
  public String ilV;
  public String ilW;
  public int ilX;
  public String ilY;
  public String ilZ;
  public String ima;
  public String imb;
  public String imc;
  public String imd;
  public String ime;
  public String imf;
  public String imh;
  public LinkedList<CardGiftInfo.AcceptedCardItem> imi = new LinkedList();
  public LinkedList<CardGiftInfo.AccepterItem> imj = new LinkedList();
  public String imk;
  public int iml;
  public String imm;
  public String imn;
  public String toUserName;
  
  public CardGiftInfo() {}
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    this.toUserName = paramParcel.readString();
    this.bXl = paramParcel.readString();
    this.ilE = paramParcel.readString();
    this.ilF = paramParcel.readString();
    this.ilG = paramParcel.readString();
    this.ilH = paramParcel.readString();
    this.ilI = paramParcel.readString();
    this.ilJ = paramParcel.readString();
    this.ilK = paramParcel.readString();
    this.ilL = paramParcel.readString();
    this.ilM = paramParcel.readString();
    this.ilN = paramParcel.readString();
    this.ilO = paramParcel.readString();
    this.ilP = paramParcel.readString();
    this.ilQ = paramParcel.readString();
    this.color = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.ilR = bool;
      this.ilS = paramParcel.readInt();
      this.ilT = paramParcel.readInt();
      this.ilU = paramParcel.readInt();
      this.ilV = paramParcel.readString();
      this.ilW = paramParcel.readString();
      this.ilX = paramParcel.readInt();
      this.ilY = paramParcel.readString();
      this.ilZ = paramParcel.readString();
      this.ima = paramParcel.readString();
      this.imb = paramParcel.readString();
      this.imc = paramParcel.readString();
      this.imd = paramParcel.readString();
      this.ime = paramParcel.readString();
      this.imf = paramParcel.readString();
      this.imh = paramParcel.readString();
      paramParcel.readTypedList(this.imi, CardGiftInfo.AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.imj, CardGiftInfo.AccepterItem.CREATOR);
      this.imk = paramParcel.readString();
      this.iml = paramParcel.readInt();
      this.imm = paramParcel.readString();
      this.imn = paramParcel.readString();
      return;
    }
  }
  
  public static CardGiftInfo a(adh paramadh)
  {
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.toUserName = paramadh.stl;
    localCardGiftInfo.bXl = paramadh.stm;
    localCardGiftInfo.ilE = paramadh.stn;
    localCardGiftInfo.ilF = paramadh.content;
    localCardGiftInfo.ilG = paramadh.sto;
    localCardGiftInfo.ilH = paramadh.stp;
    localCardGiftInfo.ilI = paramadh.stq;
    localCardGiftInfo.ilJ = paramadh.str;
    localCardGiftInfo.ilL = paramadh.stt;
    localCardGiftInfo.ilK = paramadh.sts;
    localCardGiftInfo.ilM = paramadh.stu;
    localCardGiftInfo.ilN = paramadh.stv;
    localCardGiftInfo.ilO = paramadh.imo;
    localCardGiftInfo.ilP = paramadh.imp;
    localCardGiftInfo.ilQ = paramadh.stw;
    localCardGiftInfo.color = paramadh.color;
    localCardGiftInfo.ilR = paramadh.stx;
    localCardGiftInfo.ilS = paramadh.sty;
    localCardGiftInfo.ilT = paramadh.stz;
    localCardGiftInfo.ilU = paramadh.stA;
    localCardGiftInfo.ilV = paramadh.stB;
    localCardGiftInfo.ilW = paramadh.stC;
    localCardGiftInfo.ilX = paramadh.stD;
    localCardGiftInfo.ilY = paramadh.stE;
    localCardGiftInfo.ilZ = paramadh.stF;
    localCardGiftInfo.ima = paramadh.stG;
    localCardGiftInfo.imb = paramadh.stH;
    localCardGiftInfo.imc = paramadh.stI;
    localCardGiftInfo.imd = paramadh.stJ;
    localCardGiftInfo.ime = paramadh.stK;
    localCardGiftInfo.imf = paramadh.iln;
    localCardGiftInfo.imh = paramadh.stL;
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(ao paramao)
  {
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.toUserName = paramao.stl;
    localCardGiftInfo.bXl = paramao.stm;
    localCardGiftInfo.ilE = paramao.stn;
    localCardGiftInfo.ilF = paramao.content;
    localCardGiftInfo.ilG = paramao.sto;
    localCardGiftInfo.ilH = paramao.stp;
    localCardGiftInfo.ilI = paramao.stq;
    localCardGiftInfo.ilJ = paramao.str;
    localCardGiftInfo.ilL = paramao.stt;
    localCardGiftInfo.ilK = paramao.sts;
    localCardGiftInfo.ilM = paramao.stu;
    localCardGiftInfo.ilN = paramao.stv;
    localCardGiftInfo.ilO = paramao.imo;
    localCardGiftInfo.ilP = paramao.imp;
    localCardGiftInfo.ilQ = paramao.stw;
    localCardGiftInfo.color = paramao.color;
    localCardGiftInfo.ilR = paramao.stx;
    localCardGiftInfo.ilS = paramao.sty;
    localCardGiftInfo.ilT = paramao.stz;
    localCardGiftInfo.ilU = paramao.stA;
    localCardGiftInfo.ilV = paramao.stB;
    localCardGiftInfo.ilW = paramao.stC;
    localCardGiftInfo.ilX = paramao.stD;
    localCardGiftInfo.ilY = paramao.stE;
    localCardGiftInfo.ilZ = paramao.stF;
    localCardGiftInfo.ima = paramao.stG;
    localCardGiftInfo.imb = paramao.stH;
    localCardGiftInfo.imc = paramao.stI;
    localCardGiftInfo.imd = paramao.stJ;
    localCardGiftInfo.ime = paramao.stK;
    localCardGiftInfo.imf = paramao.iln;
    localCardGiftInfo.imh = paramao.stL;
    Iterator localIterator = paramao.imi.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (ap)localIterator.next();
      localLinkedList = localCardGiftInfo.imi;
      localObject2 = new CardGiftInfo.AcceptedCardItem();
      ((CardGiftInfo.AcceptedCardItem)localObject2).imp = ((ap)localObject1).imp;
      ((CardGiftInfo.AcceptedCardItem)localObject2).imo = ((ap)localObject1).imo;
      localLinkedList.add(localObject2);
    }
    localIterator = paramao.imj.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (aq)localIterator.next();
      localLinkedList = localCardGiftInfo.imj;
      localObject2 = new CardGiftInfo.AccepterItem();
      ((CardGiftInfo.AccepterItem)localObject2).imp = ((aq)localObject1).imp;
      ((CardGiftInfo.AccepterItem)localObject2).imo = ((aq)localObject1).imo;
      ((CardGiftInfo.AccepterItem)localObject2).imr = ((aq)localObject1).imr;
      ((CardGiftInfo.AccepterItem)localObject2).imq = ((aq)localObject1).imq;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.imk = paramao.imk;
    localCardGiftInfo.iml = paramao.iml;
    localCardGiftInfo.imm = paramao.imm;
    localCardGiftInfo.imn = paramao.imn;
    return localCardGiftInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.bXl + '\'' + ", fromUserImgUrl='" + this.ilE + '\'' + ", fromUserContent='" + this.ilF + '\'' + ", fromUserContentPicUrl='" + this.ilG + '\'' + ", fromUserContentVideoUrl='" + this.ilH + '\'' + ", fromUserContentThumbPicUrl='" + this.ilI + '\'' + ", picAESKey='" + this.ilJ + '\'' + ", videoAESKey='" + this.ilK + '\'' + ", thumbVideoAESKey='" + this.ilL + '\'' + ", cardBackgroundPicUrl='" + this.ilM + '\'' + ", cardLogoLUrl='" + this.ilN + '\'' + ", cardTitle='" + this.ilO + '\'' + ", cardPrice='" + this.ilP + '\'' + ", footerWording='" + this.ilQ + '\'' + ", color='" + this.color + '\'' + ", needJump=" + this.ilR + ", picDataLength=" + this.ilS + ", videoDataLength=" + this.ilT + ", thumbDataLength=" + this.ilU + ", descTitle='" + this.ilV + '\'' + ", descIconUrl='" + this.ilW + '\'' + ", descLayoutMode=" + this.ilX + ", giftingMediaTitle='" + this.ilY + '\'' + ", descriptionTitleColor='" + this.ilZ + '\'' + ", cardTitleColor='" + this.ima + '\'' + ", cardPriceTitleColor='" + this.imb + '\'' + ", userCardId='" + this.imc + '\'' + ", operationTitle='" + this.imd + '\'' + ", operationUrl='" + this.ime + '\'' + ", cardTpId='" + this.imf + '\'' + ", cardCode='" + this.imh + '\'' + ", accepted_card_list_size='" + this.imi.size() + '\'' + ", accepter_list_size='" + this.imj.size() + '\'' + ", accepter_list_title='" + this.imk + '\'' + ", out_of_card='" + this.iml + '\'' + ", operation_wxa_username='" + this.imm + '\'' + ", operation_wxa_path='" + this.imn + '\'' + '}';
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.toUserName);
    paramParcel.writeString(this.bXl);
    paramParcel.writeString(this.ilE);
    paramParcel.writeString(this.ilF);
    paramParcel.writeString(this.ilG);
    paramParcel.writeString(this.ilH);
    paramParcel.writeString(this.ilI);
    paramParcel.writeString(this.ilJ);
    paramParcel.writeString(this.ilK);
    paramParcel.writeString(this.ilL);
    paramParcel.writeString(this.ilM);
    paramParcel.writeString(this.ilN);
    paramParcel.writeString(this.ilO);
    paramParcel.writeString(this.ilP);
    paramParcel.writeString(this.ilQ);
    paramParcel.writeString(this.color);
    if (this.ilR) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.ilS);
      paramParcel.writeInt(this.ilT);
      paramParcel.writeInt(this.ilU);
      paramParcel.writeString(this.ilV);
      paramParcel.writeString(this.ilW);
      paramParcel.writeInt(this.ilX);
      paramParcel.writeString(this.ilY);
      paramParcel.writeString(this.ilZ);
      paramParcel.writeString(this.ima);
      paramParcel.writeString(this.imb);
      paramParcel.writeString(this.imc);
      paramParcel.writeString(this.imd);
      paramParcel.writeString(this.ime);
      paramParcel.writeString(this.imf);
      paramParcel.writeString(this.imh);
      paramParcel.writeTypedList(this.imi);
      paramParcel.writeTypedList(this.imj);
      paramParcel.writeString(this.imk);
      paramParcel.writeInt(this.iml);
      paramParcel.writeString(this.imm);
      paramParcel.writeString(this.imn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */