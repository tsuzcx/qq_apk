package com.tencent.biz.common.offline;

import KQQ.ReqItem;
import KQQ.RespItem;
import android.text.TextUtils;
import com.tencent.biz.ProtoServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import tencent.im.sso.offlinpkg.OfflinePkg.BidPkg;
import tencent.im.sso.offlinpkg.OfflinePkg.ReqBody;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

public class OfflineExpire$OfflineExpireCheckUpdate
  implements CheckUpdateItemInterface
{
  private QQAppInterface a;
  
  public OfflineExpire$OfflineExpireCheckUpdate(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
  }
  
  public int a()
  {
    return 1;
  }
  
  public ReqItem a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "getCheckUpdateItemData");
    }
    ReqItem localReqItem = new ReqItem();
    localReqItem.cOperType = 1;
    localReqItem.eServiceID = 124;
    OfflinePkg.ReqBody localReqBody = new OfflinePkg.ReqBody();
    localReqBody.uint32_cmd.set(1);
    localReqBody.uint32_platform.set(OfflineExpire.jdField_a_of_type_Int);
    Object localObject = HtmlOffline.a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      String[] arrayOfString = ((String)localObject).split(",");
      int n = arrayOfString.length;
      int k = 0;
      if (k < n)
      {
        String str = arrayOfString[k];
        if (!TextUtils.isEmpty(str)) {
          localObject = str.split("\\|");
        }
        for (;;)
        {
          try
          {
            i = Integer.valueOf(localObject[0]).intValue();
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            try
            {
              int m = Integer.valueOf(localObject[1]).intValue();
              j = i;
              i = m;
              if (j != 0) {
                break label252;
              }
              k += 1;
            }
            catch (Exception localException2)
            {
              for (;;)
              {
                OfflinePkg.BidPkg localBidPkg;
                j = i;
              }
            }
            catch (NumberFormatException localNumberFormatException2)
            {
              int i;
              int j = i;
              continue;
            }
            localNumberFormatException1 = localNumberFormatException1;
            j = 0;
            localNumberFormatException1.printStackTrace();
            if (QLog.isColorLevel()) {
              QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "NumberFormatException:" + str);
            }
            i = 0;
            continue;
          }
          catch (Exception localException1)
          {
            j = 0;
          }
          if (QLog.isColorLevel()) {
            QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "Exception:" + str);
          }
          i = 0;
          continue;
          label252:
          localBidPkg = new OfflinePkg.BidPkg();
          localBidPkg.uint32_bid.set(j);
          localBidPkg.uint32_pkg_id.add(Integer.valueOf(i));
          localReqBody.st_bid_pkg.add(localBidPkg);
        }
      }
    }
    localReqItem.vecParam = ProtoServlet.a(localReqBody.toByteArray());
    return localReqItem;
  }
  
  public void a(RespItem paramRespItem)
  {
    if (QLog.isColorLevel()) {
      QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData");
    }
    if (paramRespItem.cResult == 2) {
      if (paramRespItem.eServiceID == 124)
      {
        paramRespItem = ProtoServlet.b(paramRespItem.vecUpdate);
        if (paramRespItem != null) {
          localRspBody = new OfflinePkg.RspBody();
        }
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        OfflinePkg.RspBody localRspBody;
        localRspBody.mergeFrom(paramRespItem);
        OfflineExpire.a(new String(localRspBody.str_expire_pkg.get().toByteArray(), "UTF-8"));
        OfflineExpire.a(new String(localRspBody.str_predown_pkg.get().toByteArray(), "UTF-8"), this.a.a(), this.a.a().getApplicationContext(), 1);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramRespItem)
      {
        do
        {
          paramRespItem.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
        return;
      }
      catch (UnsupportedEncodingException paramRespItem)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
        return;
      }
      catch (Exception paramRespItem)
      {
        do
        {
          paramRespItem.printStackTrace();
        } while (!QLog.isColorLevel());
        QLog.i(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "handleCheckUpdateItemData: " + QLog.getStackTraceString(paramRespItem));
        return;
      }
    }
    QLog.d(OfflineExpire.jdField_a_of_type_JavaLangString, 2, "***handleCheckUpdateItemData fail respitem.cResult:" + paramRespItem.cResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.OfflineExpireCheckUpdate
 * JD-Core Version:    0.7.0.1
 */