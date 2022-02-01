package NS_MOBILE_TEMPLATE_GIFT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class s_send_gift_item
  extends JceStruct
{
  static s_gift_card cache_giftCard;
  static ArrayList cache_receiver;
  public int arch = 0;
  public String clientIp = "";
  public String content = "";
  public s_gift_card giftCard = null;
  public long giftItemId = 0L;
  public int giftType = 0;
  public boolean isBack = true;
  public boolean isPrivate = true;
  public boolean isTiming = true;
  public ArrayList receiver = null;
  public String s_back_id = "";
  public String sendTime = "";
  public String url = "";
  
  public s_send_gift_item() {}
  
  public s_send_gift_item(s_gift_card params_gift_card, int paramInt1, ArrayList paramArrayList, long paramLong, String paramString1, boolean paramBoolean1, boolean paramBoolean2, String paramString2, boolean paramBoolean3, String paramString3, int paramInt2, String paramString4, String paramString5)
  {
    this.giftCard = params_gift_card;
    this.giftType = paramInt1;
    this.receiver = paramArrayList;
    this.giftItemId = paramLong;
    this.content = paramString1;
    this.isBack = paramBoolean1;
    this.isPrivate = paramBoolean2;
    this.url = paramString2;
    this.isTiming = paramBoolean3;
    this.sendTime = paramString3;
    this.arch = paramInt2;
    this.s_back_id = paramString4;
    this.clientIp = paramString5;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_giftCard == null) {
      cache_giftCard = new s_gift_card();
    }
    this.giftCard = ((s_gift_card)paramJceInputStream.read(cache_giftCard, 0, false));
    this.giftType = paramJceInputStream.read(this.giftType, 1, true);
    if (cache_receiver == null)
    {
      cache_receiver = new ArrayList();
      cache_receiver.add(Long.valueOf(0L));
    }
    this.receiver = ((ArrayList)paramJceInputStream.read(cache_receiver, 2, true));
    this.giftItemId = paramJceInputStream.read(this.giftItemId, 3, true);
    this.content = paramJceInputStream.readString(4, false);
    this.isBack = paramJceInputStream.read(this.isBack, 5, false);
    this.isPrivate = paramJceInputStream.read(this.isPrivate, 6, false);
    this.url = paramJceInputStream.readString(7, false);
    this.isTiming = paramJceInputStream.read(this.isTiming, 8, false);
    this.sendTime = paramJceInputStream.readString(9, false);
    this.arch = paramJceInputStream.read(this.arch, 10, false);
    this.s_back_id = paramJceInputStream.readString(11, false);
    this.clientIp = paramJceInputStream.readString(12, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.giftCard != null) {
      paramJceOutputStream.write(this.giftCard, 0);
    }
    paramJceOutputStream.write(this.giftType, 1);
    paramJceOutputStream.write(this.receiver, 2);
    paramJceOutputStream.write(this.giftItemId, 3);
    if (this.content != null) {
      paramJceOutputStream.write(this.content, 4);
    }
    paramJceOutputStream.write(this.isBack, 5);
    paramJceOutputStream.write(this.isPrivate, 6);
    if (this.url != null) {
      paramJceOutputStream.write(this.url, 7);
    }
    paramJceOutputStream.write(this.isTiming, 8);
    if (this.sendTime != null) {
      paramJceOutputStream.write(this.sendTime, 9);
    }
    paramJceOutputStream.write(this.arch, 10);
    if (this.s_back_id != null) {
      paramJceOutputStream.write(this.s_back_id, 11);
    }
    if (this.clientIp != null) {
      paramJceOutputStream.write(this.clientIp, 12);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     NS_MOBILE_TEMPLATE_GIFT.s_send_gift_item
 * JD-Core Version:    0.7.0.1
 */