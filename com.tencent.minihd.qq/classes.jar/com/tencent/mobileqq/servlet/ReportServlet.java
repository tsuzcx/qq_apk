package com.tencent.mobileqq.servlet;

import QQService.strupbuff;
import QQService.strupbuffResp;
import android.content.Intent;
import android.os.Bundle;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.activity.TrafficDetailActivity;
import com.tencent.mobileqq.activity.TrafficStatActivity;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.RdmReq;
import com.tencent.mobileqq.pic.PreDownloadStrategyAlpha;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.report.StrupBuff;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ReportServlet
  extends MSFServlet
{
  public static final int a = 2;
  public static final int b = 3;
  public static final int c = 4;
  public static final int d = 5;
  public static final int e = 6;
  public static final int f = 7;
  public static final int g = 8;
  public static final int h = 9;
  public static final int i = 10;
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "CliLogSvc.UploadReq" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject1 = paramFromServiceMsg.getServiceCmd();
    if (("App_GetDataCount".equals(localObject1)) && (paramFromServiceMsg.isSuccess()))
    {
      Object localObject2 = (long[])paramFromServiceMsg.getAttribute("__base_tag_curentDay", null);
      long[] arrayOfLong = (long[])paramFromServiceMsg.getAttribute("__base_tag_curentMonth", null);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putLongArray("__base_tag_curentDay", (long[])localObject2);
      ((Bundle)localObject1).putLongArray("__base_tag_curentMonth", arrayOfLong);
      notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, TrafficStatActivity.class);
      notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, TrafficDetailActivity.class);
      localObject2 = paramIntent.getStringArrayExtra("tags");
      if ((localObject2 != null) && (localObject2.length == 4) && (localObject2[0].equals("param_XGC2CPicDownloadFlow"))) {
        notifyObserver(paramIntent, 3, paramFromServiceMsg.isSuccess(), (Bundle)localObject1, PreDownloadStrategyAlpha.class);
      }
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!"CliLogSvc.UploadReq".equals(localObject1));
      bool = paramFromServiceMsg.isSuccess();
      if (paramIntent.getExtras().getInt("seqKey") != 0) {
        notifyObserver(paramIntent, paramIntent.getExtras().getInt("sendType"), bool, paramIntent.getExtras(), null);
      }
    } while (!bool);
    paramIntent = (strupbuffResp)decodePacket(paramFromServiceMsg.getWupBuffer(), "DataResp", new strupbuffResp());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1;
    Object localObject2;
    switch (paramIntent.getExtras().getInt("sendType"))
    {
    case 5: 
    default: 
      return;
    case 7: 
      sendToMSF(paramIntent, MsfMsgUtil.getAppDataIncermentMsg(null, paramIntent.getStringExtra("uin"), paramIntent.getStringArrayExtra("tags"), paramIntent.getLongExtra("count", 0L)));
      return;
    case 2: 
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getString("content");
      paramIntent = new ArrayList();
      try
      {
        paramIntent.add(((String)localObject3).getBytes("utf-8"));
        localObject3 = new HashMap();
        ((HashMap)localObject3).put(localObject2, paramIntent);
        ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
        ((StrupBuff)localObject1).encoding = 2;
        paramPacket.setSSOCommand("CliLogSvc.UploadReq");
        paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
        paramPacket.setFuncName("UploadReq");
        paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
        paramPacket.setNoResponse();
        return;
      }
      catch (UnsupportedEncodingException paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
    case 9: 
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getByteArray("content");
      paramIntent = new ArrayList();
      paramIntent.add(localObject3);
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 0;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
    case 6: 
      localObject1 = new StrupBuff();
      localObject2 = paramIntent.getExtras().getString("tag");
      ((StrupBuff)localObject1).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("content");
      paramIntent = new ArrayList();
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        try
        {
          paramIntent.add(((String)localObject4).getBytes("utf-8"));
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      localObject3 = new HashMap();
      ((HashMap)localObject3).put(localObject2, paramIntent);
      ((StrupBuff)localObject1).logstring = new HashMap((Map)localObject3);
      ((StrupBuff)localObject1).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject1);
      paramPacket.setNoResponse();
      return;
    case 8: 
      localObject2 = new StrupBuff();
      ((StrupBuff)localObject2).prefix = "";
      localObject3 = paramIntent.getExtras().getStringArrayList("tags");
      localObject4 = paramIntent.getExtras().getStringArrayList("contents");
      localObject5 = new HashMap();
      j = 0;
      while (j < ((List)localObject3).size())
      {
        localObject6 = (String)((List)localObject3).get(j);
        paramIntent = (String)((List)localObject4).get(j);
        try
        {
          localObject7 = paramIntent.getBytes("utf-8");
          localObject1 = (ArrayList)((HashMap)localObject5).get(localObject6);
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            paramIntent = new ArrayList();
            ((HashMap)localObject5).put(localObject6, paramIntent);
          }
          paramIntent.add(localObject7);
        }
        catch (UnsupportedEncodingException paramIntent)
        {
          Object localObject7;
          long l1;
          long l2;
          boolean bool1;
          boolean bool2;
          break label649;
        }
        j += 1;
      }
      ((StrupBuff)localObject2).logstring = new HashMap((Map)localObject5);
      ((StrupBuff)localObject2).encoding = 2;
      paramPacket.setSSOCommand("CliLogSvc.UploadReq");
      paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
      paramPacket.setFuncName("UploadReq");
      paramPacket.addRequestPacket("Data", (JceStruct)localObject2);
      paramPacket.setNoResponse();
      return;
    case 3: 
      sendToMSF(paramIntent, MsfMsgUtil.getCurrentDataCountMsg(null, paramIntent.getStringArrayExtra("tags")));
      return;
    case 4: 
      label649:
      paramPacket = paramIntent.getExtras().getString("tagName");
      l1 = paramIntent.getExtras().getLong("duration");
      l2 = paramIntent.getExtras().getLong("size");
      bool1 = paramIntent.getExtras().getBoolean("success");
      localObject1 = (HashMap)paramIntent.getExtras().getSerializable("Params_MAP");
      bool2 = paramIntent.getExtras().getBoolean("realtime");
      localObject2 = new RdmReq();
      ((RdmReq)localObject2).eventName = paramPacket;
      ((RdmReq)localObject2).elapse = l1;
      ((RdmReq)localObject2).size = l2;
      ((RdmReq)localObject2).isSucceed = Boolean.valueOf(bool1).booleanValue();
      ((RdmReq)localObject2).isRealTime = Boolean.valueOf(bool2).booleanValue();
      ((RdmReq)localObject2).params = ((Map)localObject1);
      sendToMSF(paramIntent, MsfMsgUtil.getRdmReportMsg(null, (RdmReq)localObject2));
      return;
    }
    Object localObject3 = new strupbuff();
    ((strupbuff)localObject3).prefix = "";
    Object localObject4 = paramIntent.getExtras().getStringArrayList("tags");
    Object localObject5 = paramIntent.getExtras().getStringArrayList("contents");
    Object localObject6 = new HashMap();
    int j = 0;
    while (j < ((List)localObject4).size())
    {
      localObject7 = (String)((List)localObject4).get(j);
      localObject1 = (String)((List)localObject5).get(j);
      try
      {
        byte[] arrayOfByte = ((String)localObject1).getBytes("utf-8");
        localObject2 = (ArrayList)((HashMap)localObject6).get(localObject7);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ArrayList();
          ((HashMap)localObject6).put(localObject7, localObject1);
        }
        ((ArrayList)localObject1).add(arrayOfByte);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label1013:
        break label1013;
      }
      j += 1;
    }
    ((strupbuff)localObject3).logstring = new HashMap((Map)localObject6);
    ((strupbuff)localObject3).encoding = 2;
    ((strupbuff)localObject3).seqno = paramIntent.getExtras().getInt("seqKey");
    paramPacket.setSSOCommand("CliLogSvc.UploadReq");
    paramPacket.setServantName("QQService.CliLogSvc.MainServantObj");
    paramPacket.setFuncName("UploadReq");
    paramPacket.addRequestPacket("Data", (JceStruct)localObject3);
    paramPacket.setTimeout(30000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.servlet.ReportServlet
 * JD-Core Version:    0.7.0.1
 */