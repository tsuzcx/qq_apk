package localpb.richMsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MixedMsg$Elem
  extends MessageMicro
{
  public static final int MARKFACEMSG_FIELD_NUMBER = 3;
  public static final int PICMSG_FIELD_NUMBER = 2;
  public static final int TEXTMSG_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "textMsg", "picMsg", "markfaceMsg" }, new Object[] { "", null, null }, Elem.class);
  public MarketFaceMsg.MarketFaceRec markfaceMsg = new MarketFaceMsg.MarketFaceRec();
  public RichMsg.PicRec picMsg = new RichMsg.PicRec();
  public final PBStringField textMsg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     localpb.richMsg.MixedMsg.Elem
 * JD-Core Version:    0.7.0.1
 */