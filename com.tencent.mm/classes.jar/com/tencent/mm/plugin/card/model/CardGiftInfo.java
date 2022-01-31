package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ahz;
import com.tencent.mm.protocal.protobuf.ao;
import com.tencent.mm.protocal.protobuf.ap;
import com.tencent.mm.protocal.protobuf.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo
  implements Parcelable
{
  public static final Parcelable.Creator<CardGiftInfo> CREATOR;
  public String cFh;
  public String color;
  public String kmB;
  public String kmC;
  public String kmD;
  public String kmE;
  public String kmF;
  public String kmG;
  public String kmH;
  public String kmI;
  public String kmJ;
  public String kmK;
  public String kmL;
  public String kmM;
  public String kmN;
  public boolean kmO;
  public int kmP;
  public int kmQ;
  public int kmR;
  public String kmS;
  public String kmT;
  public int kmU;
  public String kmV;
  public String kmW;
  public String kmX;
  public String kmY;
  public String kmZ;
  public String kna;
  public String knb;
  public String knc;
  public String knd;
  public LinkedList<CardGiftInfo.AcceptedCardItem> kne;
  public LinkedList<CardGiftInfo.AccepterItem> knf;
  public String kng;
  public int knh;
  public String kni;
  public String knj;
  public String toUserName;
  
  static
  {
    AppMethodBeat.i(87790);
    CREATOR = new CardGiftInfo.1();
    AppMethodBeat.o(87790);
  }
  
  public CardGiftInfo()
  {
    AppMethodBeat.i(87784);
    this.kne = new LinkedList();
    this.knf = new LinkedList();
    AppMethodBeat.o(87784);
  }
  
  protected CardGiftInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(87785);
    this.kne = new LinkedList();
    this.knf = new LinkedList();
    this.toUserName = paramParcel.readString();
    this.cFh = paramParcel.readString();
    this.kmB = paramParcel.readString();
    this.kmC = paramParcel.readString();
    this.kmD = paramParcel.readString();
    this.kmE = paramParcel.readString();
    this.kmF = paramParcel.readString();
    this.kmG = paramParcel.readString();
    this.kmH = paramParcel.readString();
    this.kmI = paramParcel.readString();
    this.kmJ = paramParcel.readString();
    this.kmK = paramParcel.readString();
    this.kmL = paramParcel.readString();
    this.kmM = paramParcel.readString();
    this.kmN = paramParcel.readString();
    this.color = paramParcel.readString();
    if (paramParcel.readByte() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.kmO = bool;
      this.kmP = paramParcel.readInt();
      this.kmQ = paramParcel.readInt();
      this.kmR = paramParcel.readInt();
      this.kmS = paramParcel.readString();
      this.kmT = paramParcel.readString();
      this.kmU = paramParcel.readInt();
      this.kmV = paramParcel.readString();
      this.kmW = paramParcel.readString();
      this.kmX = paramParcel.readString();
      this.kmY = paramParcel.readString();
      this.kmZ = paramParcel.readString();
      this.kna = paramParcel.readString();
      this.knb = paramParcel.readString();
      this.knc = paramParcel.readString();
      this.knd = paramParcel.readString();
      paramParcel.readTypedList(this.kne, CardGiftInfo.AcceptedCardItem.CREATOR);
      paramParcel.readTypedList(this.knf, CardGiftInfo.AccepterItem.CREATOR);
      this.kng = paramParcel.readString();
      this.knh = paramParcel.readInt();
      this.kni = paramParcel.readString();
      this.knj = paramParcel.readString();
      AppMethodBeat.o(87785);
      return;
    }
  }
  
  public static CardGiftInfo a(ahz paramahz)
  {
    AppMethodBeat.i(87789);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.toUserName = paramahz.wlP;
    localCardGiftInfo.cFh = paramahz.wlQ;
    localCardGiftInfo.kmB = paramahz.wlR;
    localCardGiftInfo.kmC = paramahz.content;
    localCardGiftInfo.kmD = paramahz.wlS;
    localCardGiftInfo.kmE = paramahz.wlT;
    localCardGiftInfo.kmF = paramahz.wlU;
    localCardGiftInfo.kmG = paramahz.wlV;
    localCardGiftInfo.kmI = paramahz.wlX;
    localCardGiftInfo.kmH = paramahz.wlW;
    localCardGiftInfo.kmJ = paramahz.wlY;
    localCardGiftInfo.kmK = paramahz.wlZ;
    localCardGiftInfo.kmL = paramahz.knk;
    localCardGiftInfo.kmM = paramahz.knl;
    localCardGiftInfo.kmN = paramahz.wma;
    localCardGiftInfo.color = paramahz.color;
    localCardGiftInfo.kmO = paramahz.wmb;
    localCardGiftInfo.kmP = paramahz.wmc;
    localCardGiftInfo.kmQ = paramahz.wmd;
    localCardGiftInfo.kmR = paramahz.wme;
    localCardGiftInfo.kmS = paramahz.wmf;
    localCardGiftInfo.kmT = paramahz.wmg;
    localCardGiftInfo.kmU = paramahz.wZX;
    localCardGiftInfo.kmV = paramahz.wmi;
    localCardGiftInfo.kmW = paramahz.wmj;
    localCardGiftInfo.kmX = paramahz.wmk;
    localCardGiftInfo.kmY = paramahz.wml;
    localCardGiftInfo.kmZ = paramahz.wmm;
    localCardGiftInfo.kna = paramahz.wmn;
    localCardGiftInfo.knb = paramahz.wmo;
    localCardGiftInfo.knc = paramahz.kml;
    localCardGiftInfo.knd = paramahz.wmp;
    localCardGiftInfo.kni = paramahz.kni;
    localCardGiftInfo.knj = paramahz.knj;
    AppMethodBeat.o(87789);
    return localCardGiftInfo;
  }
  
  public static CardGiftInfo a(ao paramao)
  {
    AppMethodBeat.i(87788);
    CardGiftInfo localCardGiftInfo = new CardGiftInfo();
    localCardGiftInfo.toUserName = paramao.wlP;
    localCardGiftInfo.cFh = paramao.wlQ;
    localCardGiftInfo.kmB = paramao.wlR;
    localCardGiftInfo.kmC = paramao.content;
    localCardGiftInfo.kmD = paramao.wlS;
    localCardGiftInfo.kmE = paramao.wlT;
    localCardGiftInfo.kmF = paramao.wlU;
    localCardGiftInfo.kmG = paramao.wlV;
    localCardGiftInfo.kmI = paramao.wlX;
    localCardGiftInfo.kmH = paramao.wlW;
    localCardGiftInfo.kmJ = paramao.wlY;
    localCardGiftInfo.kmK = paramao.wlZ;
    localCardGiftInfo.kmL = paramao.knk;
    localCardGiftInfo.kmM = paramao.knl;
    localCardGiftInfo.kmN = paramao.wma;
    localCardGiftInfo.color = paramao.color;
    localCardGiftInfo.kmO = paramao.wmb;
    localCardGiftInfo.kmP = paramao.wmc;
    localCardGiftInfo.kmQ = paramao.wmd;
    localCardGiftInfo.kmR = paramao.wme;
    localCardGiftInfo.kmS = paramao.wmf;
    localCardGiftInfo.kmT = paramao.wmg;
    localCardGiftInfo.kmU = paramao.wmh;
    localCardGiftInfo.kmV = paramao.wmi;
    localCardGiftInfo.kmW = paramao.wmj;
    localCardGiftInfo.kmX = paramao.wmk;
    localCardGiftInfo.kmY = paramao.wml;
    localCardGiftInfo.kmZ = paramao.wmm;
    localCardGiftInfo.kna = paramao.wmn;
    localCardGiftInfo.knb = paramao.wmo;
    localCardGiftInfo.knc = paramao.kml;
    localCardGiftInfo.knd = paramao.wmp;
    Iterator localIterator = paramao.kne.iterator();
    Object localObject1;
    LinkedList localLinkedList;
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject1 = (ap)localIterator.next();
      localLinkedList = localCardGiftInfo.kne;
      localObject2 = new CardGiftInfo.AcceptedCardItem();
      ((CardGiftInfo.AcceptedCardItem)localObject2).knl = ((ap)localObject1).knl;
      ((CardGiftInfo.AcceptedCardItem)localObject2).knk = ((ap)localObject1).knk;
      localLinkedList.add(localObject2);
    }
    localIterator = paramao.knf.iterator();
    while (localIterator.hasNext())
    {
      localObject1 = (aq)localIterator.next();
      localLinkedList = localCardGiftInfo.knf;
      localObject2 = new CardGiftInfo.AccepterItem();
      ((CardGiftInfo.AccepterItem)localObject2).knl = ((aq)localObject1).knl;
      ((CardGiftInfo.AccepterItem)localObject2).knk = ((aq)localObject1).knk;
      ((CardGiftInfo.AccepterItem)localObject2).knn = ((aq)localObject1).knn;
      ((CardGiftInfo.AccepterItem)localObject2).knm = ((aq)localObject1).knm;
      localLinkedList.add(localObject2);
    }
    localCardGiftInfo.kng = paramao.kng;
    localCardGiftInfo.knh = paramao.knh;
    localCardGiftInfo.kni = paramao.kni;
    localCardGiftInfo.knj = paramao.knj;
    AppMethodBeat.o(87788);
    return localCardGiftInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    AppMethodBeat.i(87787);
    String str = "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.cFh + '\'' + ", fromUserImgUrl='" + this.kmB + '\'' + ", fromUserContent='" + this.kmC + '\'' + ", fromUserContentPicUrl='" + this.kmD + '\'' + ", fromUserContentVideoUrl='" + this.kmE + '\'' + ", fromUserContentThumbPicUrl='" + this.kmF + '\'' + ", picAESKey='" + this.kmG + '\'' + ", videoAESKey='" + this.kmH + '\'' + ", thumbVideoAESKey='" + this.kmI + '\'' + ", cardBackgroundPicUrl='" + this.kmJ + '\'' + ", cardLogoLUrl='" + this.kmK + '\'' + ", cardTitle='" + this.kmL + '\'' + ", cardPrice='" + this.kmM + '\'' + ", footerWording='" + this.kmN + '\'' + ", color='" + this.color + '\'' + ", needJump=" + this.kmO + ", picDataLength=" + this.kmP + ", videoDataLength=" + this.kmQ + ", thumbDataLength=" + this.kmR + ", descTitle='" + this.kmS + '\'' + ", descIconUrl='" + this.kmT + '\'' + ", descLayoutMode=" + this.kmU + ", giftingMediaTitle='" + this.kmV + '\'' + ", descriptionTitleColor='" + this.kmW + '\'' + ", cardTitleColor='" + this.kmX + '\'' + ", cardPriceTitleColor='" + this.kmY + '\'' + ", userCardId='" + this.kmZ + '\'' + ", operationTitle='" + this.kna + '\'' + ", operationUrl='" + this.knb + '\'' + ", cardTpId='" + this.knc + '\'' + ", cardCode='" + this.knd + '\'' + ", accepted_card_list_size='" + this.kne.size() + '\'' + ", accepter_list_size='" + this.knf.size() + '\'' + ", accepter_list_title='" + this.kng + '\'' + ", out_of_card='" + this.knh + '\'' + ", operation_wxa_username='" + this.kni + '\'' + ", operation_wxa_path='" + this.knj + '\'' + '}';
    AppMethodBeat.o(87787);
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(87786);
    paramParcel.writeString(this.toUserName);
    paramParcel.writeString(this.cFh);
    paramParcel.writeString(this.kmB);
    paramParcel.writeString(this.kmC);
    paramParcel.writeString(this.kmD);
    paramParcel.writeString(this.kmE);
    paramParcel.writeString(this.kmF);
    paramParcel.writeString(this.kmG);
    paramParcel.writeString(this.kmH);
    paramParcel.writeString(this.kmI);
    paramParcel.writeString(this.kmJ);
    paramParcel.writeString(this.kmK);
    paramParcel.writeString(this.kmL);
    paramParcel.writeString(this.kmM);
    paramParcel.writeString(this.kmN);
    paramParcel.writeString(this.color);
    if (this.kmO) {}
    for (byte b = 1;; b = 0)
    {
      paramParcel.writeByte(b);
      paramParcel.writeInt(this.kmP);
      paramParcel.writeInt(this.kmQ);
      paramParcel.writeInt(this.kmR);
      paramParcel.writeString(this.kmS);
      paramParcel.writeString(this.kmT);
      paramParcel.writeInt(this.kmU);
      paramParcel.writeString(this.kmV);
      paramParcel.writeString(this.kmW);
      paramParcel.writeString(this.kmX);
      paramParcel.writeString(this.kmY);
      paramParcel.writeString(this.kmZ);
      paramParcel.writeString(this.kna);
      paramParcel.writeString(this.knb);
      paramParcel.writeString(this.knc);
      paramParcel.writeString(this.knd);
      paramParcel.writeTypedList(this.kne);
      paramParcel.writeTypedList(this.knf);
      paramParcel.writeString(this.kng);
      paramParcel.writeInt(this.knh);
      paramParcel.writeString(this.kni);
      paramParcel.writeString(this.knj);
      AppMethodBeat.o(87786);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardGiftInfo
 * JD-Core Version:    0.7.0.1
 */