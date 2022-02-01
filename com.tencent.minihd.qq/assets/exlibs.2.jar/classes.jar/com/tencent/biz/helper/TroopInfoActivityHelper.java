package com.tencent.biz.helper;

import cgj;
import cgk;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.ReqBody;
import tencent.im.oidb.cmd0x79a.oidb_0x79a.RspBody;
import tencent.im.oidb.cmd0x79b.oidb_0x79b.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.TagRecord;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopInfoActivityHelper
{
  public static void a(QQAppInterface paramQQAppInterface, long paramLong, TroopInfoActivityHelper.IGetSameCityCheckTypeInfo paramIGetSameCityCheckTypeInfo)
  {
    Object localObject = new oidb_0x79a.ReqBody();
    ((oidb_0x79a.ReqBody)localObject).uint64_group_code.set(paramLong);
    ((oidb_0x79a.ReqBody)localObject).uint32_source.set(1);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1946);
    localOIDBSSOPkg.uint32_service_type.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x79a.ReqBody)localObject).toByteArray()));
    localObject = new NewIntent(paramQQAppInterface.getApplication(), ProtoServlet.class);
    ((NewIntent)localObject).putExtra("cmd", "OidbSvc.0x79a_1");
    ((NewIntent)localObject).putExtra("data", localOIDBSSOPkg.toByteArray());
    ((NewIntent)localObject).setObserver(new cgj(paramQQAppInterface, paramIGetSameCityCheckTypeInfo));
    paramQQAppInterface.startServlet((NewIntent)localObject);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, int paramInt, long paramLong2, long paramLong3, String paramString2, long paramLong4, List paramList, String paramString3, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo)
  {
    oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
    localGroupInfo.string_group_name.set(ByteStringMicro.copyFromUtf8(paramString1));
    if ((paramLong2 != 0L) && (paramLong3 != 0L))
    {
      paramString1 = new oidb_0x88d.GroupGeoInfo();
      paramString1.uint32_cityid.set(paramInt);
      paramString1.int64_latitude.set(paramLong2);
      paramString1.int64_longitude.set(paramLong3);
      paramString1.bytes_geocontent.set(ByteStringMicro.copyFromUtf8(paramString2));
      localGroupInfo.group_geo_info.set(paramString1);
    }
    localGroupInfo.uint32_group_class_ext.set((int)paramLong4);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = new ArrayList();
      paramString2 = paramList.iterator();
      while (paramString2.hasNext())
      {
        paramList = (String)paramString2.next();
        oidb_0x88d.TagRecord localTagRecord = new oidb_0x88d.TagRecord();
        localTagRecord.bytes_tag_value.set(ByteStringMicro.copyFromUtf8(paramList));
        paramString1.add(localTagRecord);
      }
      localGroupInfo.rpt_tag_record.set(paramString1);
    }
    localGroupInfo.string_group_rich_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    localGroupInfo.string_group_finger_memo.set(ByteStringMicro.copyFromUtf8(paramString3));
    paramString1 = new oidb_0x79b.ReqBody();
    paramString1.uint64_group_code.set(paramLong1);
    paramString1.uint32_source.set(1);
    paramString1.info.set(localGroupInfo);
    paramString2 = new oidb_sso.OIDBSSOPkg();
    paramString2.uint32_command.set(1947);
    paramString2.uint32_service_type.set(1);
    paramString2.bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramString1.toByteArray()));
    paramString1 = new NewIntent(paramQQAppInterface.getApplication(), ProtoServlet.class);
    paramString1.putExtra("cmd", "OidbSvc.0x79b_1");
    paramString1.putExtra("data", paramString2.toByteArray());
    paramString1.setObserver(new cgk(paramQQAppInterface, paramISetSameCityCheckTypeInfo));
    paramQQAppInterface.startServlet(paramString1);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, TroopInfoActivityHelper.IGetSameCityCheckTypeInfo paramIGetSameCityCheckTypeInfo)
  {
    try
    {
      paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()) || (paramQQAppInterface.uint32_result.get() != 0) || (!paramQQAppInterface.bytes_bodybuffer.has()) || (paramQQAppInterface.bytes_bodybuffer.get() == null))
      {
        paramIGetSameCityCheckTypeInfo.a();
        return;
      }
      paramArrayOfByte = new oidb_0x79a.RspBody();
      paramArrayOfByte.mergeFrom(paramQQAppInterface.bytes_bodybuffer.get().toByteArray());
      paramIGetSameCityCheckTypeInfo.a((oidb_0x88d.GroupInfo)paramArrayOfByte.info.get());
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramIGetSameCityCheckTypeInfo.a();
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte, TroopInfoActivityHelper.ISetSameCityCheckTypeInfo paramISetSameCityCheckTypeInfo)
  {
    try
    {
      paramQQAppInterface = new oidb_sso.OIDBSSOPkg();
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      if ((paramQQAppInterface == null) || (!paramQQAppInterface.uint32_result.has()) || (paramQQAppInterface.uint32_result.get() != 0) || (!paramQQAppInterface.bytes_bodybuffer.has()) || (paramQQAppInterface.bytes_bodybuffer.get() == null))
      {
        paramISetSameCityCheckTypeInfo.b();
        return;
      }
      paramISetSameCityCheckTypeInfo.a();
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      paramISetSameCityCheckTypeInfo.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.helper.TroopInfoActivityHelper
 * JD-Core Version:    0.7.0.1
 */