package cooperation.qqwifi;

import android.content.Intent;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import qqwifi.WiFiAccountReq;

public class QQWifiServlet
  extends MSFServlet
{
  public static final int a = 1;
  public static String a = "QQWifiServlet";
  public static String b = "MQQ.WiFiAccountServer.WiFiAccountObj";
  public static String c = "cmd_id";
  public static final String d = "";
  public static final String e = "getAccount";
  
  private void a(Intent paramIntent, Packet paramPacket)
  {
    paramPacket.addRequestPacket("req", new WiFiAccountReq(paramIntent.getLongExtra("uin", 0L), paramIntent.getLongExtra("seqno", 0L), paramIntent.getLongExtra("crc", 0L), paramIntent.getByteExtra("barsetting", (byte)0)));
    paramPacket.setServantName(b);
    paramPacket.setFuncName("getAccount");
    paramPacket.setSSOCommand("");
    paramPacket.setNoResponse();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    byte b1 = 1;
    try
    {
      Long localLong1 = Long.valueOf(paramQQAppInterface.a());
      Long localLong2 = Long.valueOf(Math.abs(new Random(System.currentTimeMillis() + localLong1.longValue()).nextLong()));
      long l = QQWifiUtil.a(HexUtil.bytes2HexStr(MessageDigest.getInstance("MD5").digest((localLong1 + "" + localLong2).getBytes("utf-8"))));
      NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a().getApplicationContext(), QQWifiServlet.class);
      localNewIntent.putExtra(c, 1);
      localNewIntent.putExtra("uin", localLong1);
      localNewIntent.putExtra("seqno", localLong2);
      localNewIntent.putExtra("crc", Long.valueOf(l));
      if (paramBoolean) {}
      for (;;)
      {
        localNewIntent.putExtra("barsetting", b1);
        paramQQAppInterface.startServlet(localNewIntent);
        return;
        b1 = 2;
      }
      return;
    }
    catch (NoSuchAlgorithmException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      return;
    }
    catch (UnsupportedEncodingException paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    switch (paramIntent.getIntExtra(c, 0))
    {
    default: 
      return;
    }
    a(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     cooperation.qqwifi.QQWifiServlet
 * JD-Core Version:    0.7.0.1
 */