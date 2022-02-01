package com.tencent.mobileqq.transfile;

import android.os.Environment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kar;
import kas;

public class OldHttpEngine$OldHttpCommunicatorListner
  implements IHttpCommunicatorListener
{
  int jdField_a_of_type_Int = 0;
  public HttpNetReq a;
  public NetResp a;
  public HttpMsg a;
  public OutputStream a;
  String jdField_a_of_type_JavaLangString = null;
  public AtomicBoolean a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  boolean jdField_b_of_type_Boolean = false;
  int c = 5;
  int d = 0;
  
  public OldHttpEngine$OldHttpCommunicatorListner(OldHttpEngine paramOldHttpEngine)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  private void a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Long = System.currentTimeMillis();
        NetworkCenter.a().a();
        if (NetworkCenter.a().a() == 0) {
          break;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (paramLong != 0L))
        {
          ThreadManager.a().schedule(new kar(this), paramLong);
          return;
        }
      } while (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
      this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.c(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
      {
        ThreadManager.a().schedule(new kas(this), paramLong);
        return;
      }
    } while (!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get());
  }
  
  private void c()
  {
    boolean bool = true;
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return;
    }
    HttpNetReq localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    NetResp localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    OutputStream localOutputStream;
    if (localHttpNetReq != null)
    {
      localOutputStream = this.jdField_a_of_type_JavaIoOutputStream;
      if ((localHttpNetReq.jdField_b_of_type_JavaLangString == null) || (localOutputStream == null)) {}
    }
    try
    {
      localOutputStream.close();
      if (localNetResp != null)
      {
        if ((localHttpNetReq.jdField_e_of_type_JavaLangString != null) && (localNetResp.e != 3)) {
          OldHttpEngine.a(this.jdField_a_of_type_ComTencentMobileqqTransfileOldHttpEngine).remove(localHttpNetReq.jdField_e_of_type_JavaLangString);
        }
        if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener != null)
        {
          if (QLog.isColorLevel())
          {
            int i = localHttpNetReq.n;
            if (localHttpNetReq.c != 1) {
              break label203;
            }
            RichMediaUtil.a(i, bool, localHttpNetReq.m, localHttpNetReq.jdField_d_of_type_JavaLangString, "onOutEngine", "result:" + localNetResp.e + " errCode:" + localNetResp.jdField_f_of_type_Int + " desc:" + localNetResp.jdField_a_of_type_JavaLangString);
          }
          localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(localNetResp);
        }
      }
      a();
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        localIOException.printStackTrace();
        continue;
        label203:
        bool = false;
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = OldHttpEngine.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, paramString1, paramString2);
    return this.jdField_a_of_type_JavaLangString;
  }
  
  void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
    HttpNetReq localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
    if (localHttpNetReq != null) {
      localHttpNetReq.jdField_a_of_type_JavaLangObject = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq = null;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
  }
  
  public void a(HttpMsg paramHttpMsg) {}
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Int = 0;
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq != null) {
        try
        {
          if ((paramHttpMsg2.c() == 206) || (paramHttpMsg2.c() == 200))
          {
            paramHttpMsg1 = paramHttpMsg2.a();
            QLog.d("FlowPro", 1, "recvData:" + paramHttpMsg1.length + " ep.getTotalLen:" + paramHttpMsg2.a() + " rep.totalBlockLen:" + paramHttpMsg2.jdField_b_of_type_Long + " netResp.mWrittenBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c);
            this.jdField_b_of_type_Int += paramHttpMsg1.length;
            if (this.jdField_a_of_type_JavaIoOutputStream != null)
            {
              this.jdField_a_of_type_JavaIoOutputStream.write(paramHttpMsg1);
              this.jdField_a_of_type_JavaIoOutputStream.flush();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = paramHttpMsg2.a();
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long = paramHttpMsg2.jdField_b_of_type_Long;
              paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
              paramHttpMsg2.c += paramHttpMsg1.length;
              if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener == null) {
                continue;
              }
              this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long);
            }
          }
        }
        catch (IOException paramHttpMsg1)
        {
          paramHttpMsg1.printStackTrace();
          this.jdField_a_of_type_Boolean = true;
          a(paramHttpMsg1, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
          throw new RuntimeException("io exceptionmsg:" + paramHttpMsg1.getMessage());
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_Long = paramHttpMsg2.a();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long = paramHttpMsg2.jdField_b_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte = paramHttpMsg2.a();
  }
  
  void a(IOException paramIOException, NetResp paramNetResp)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    do
    {
      return;
      paramNetResp = paramIOException.getMessage();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301, paramNetResp + MsfSdkUtils.getStackTraceString(paramIOException), null);
      paramIOException = Environment.getExternalStorageState();
      if (paramNetResp.contains("EACCES"))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
        return;
      }
      if ((paramNetResp.contains("ENOSPC")) || (paramNetResp.contains("space")))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9040;
        return;
      }
      if (paramNetResp.contains("Read-only"))
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
        return;
      }
    } while ("mounted".equals(paramIOException));
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 9039;
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {
      return true;
    }
    if (paramInt == 5)
    {
      b(paramHttpMsg2);
      if (!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.a()) {
        break label549;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c != this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long) && ((!this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_e_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c <= 0L) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long != -1L))) {
        break label360;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.e = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
      int i = 0;
      paramInt = i;
      if (this.jdField_a_of_type_JavaLangString != null)
      {
        paramInt = i;
        if (this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString)) {
          paramInt = 1;
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString == null) {}
    }
    try
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Boolean) && (paramInt == 0) && (FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString))) {
        FileUtils.d(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString);
      }
    }
    catch (Exception paramHttpMsg2)
    {
      try
      {
        if (this.jdField_a_of_type_JavaIoOutputStream == null) {
          break label219;
        }
        this.jdField_a_of_type_JavaIoOutputStream.close();
        label219:
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_Boolean) {
          break label271;
        }
        if (paramHttpMsg1.e == 0L) {
          break label249;
        }
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_g_of_type_Long = paramHttpMsg1.e;
        label249:
        c();
        return true;
        paramHttpMsg2 = paramHttpMsg2;
        paramHttpMsg2.printStackTrace();
      }
      catch (IOException paramHttpMsg2)
      {
        for (;;)
        {
          paramHttpMsg2.printStackTrace();
          continue;
          label271:
          if ((paramInt == 0) && (!FileUtils.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString))) {
            if (FileUtils.c(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString))
            {
              new File(this.jdField_a_of_type_JavaLangString).delete();
            }
            else
            {
              this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, 9301, "rename file failed", null);
              new File(this.jdField_a_of_type_JavaLangString).delete();
            }
          }
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString != null) {}
    label360:
    do
    {
      if (QLog.isColorLevel())
      {
        paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n;
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.c != 1) {
          break label543;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        RichMediaUtil.a(paramInt, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.m, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_d_of_type_JavaLangString, "check", "writtenSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, -9527, null, null);
        paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = ("recvSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.e = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_f_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaLangString = "";
    } while (((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length == this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long)) && ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long == 0L)));
    label543:
    label549:
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.a(1, -9527, null, null);
    paramHttpMsg2 = BaseTransProcessor.a("Q", -9533L);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("netresp_param_reason", paramHttpMsg2);
    paramHttpMsg2 = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    StringBuilder localStringBuilder = new StringBuilder().append("recvSize:");
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte != null) {}
    for (paramInt = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ArrayOfByte.length;; paramInt = 0)
    {
      paramHttpMsg2.jdField_a_of_type_JavaLangString = (paramInt + " totalBlockLen:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_b_of_type_Long);
      break;
    }
  }
  
  public void b()
  {
    this.d = NetworkCenter.a().a();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaLangString = a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_ComTencentMobileqqTransfileNetReq.c = this.jdField_a_of_type_JavaLangString;
        localObject = new File(this.jdField_a_of_type_JavaLangString);
        if (((File)localObject).exists())
        {
          l = ((File)localObject).length();
          if ((l > 0L) && (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix != null))
          {
            this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.c = l;
            this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream((File)localObject, true);
            if (QLog.isColorLevel()) {
              QLog.d("Q.richmedia.OldHttpEngine", 2, "append.oring Len:" + l);
            }
          }
        }
      }
      catch (IOException localIOException)
      {
        Object localObject;
        long l;
        localIOException.printStackTrace();
        this.jdField_b_of_type_Boolean = true;
        a(localIOException, this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp);
        continue;
      }
      try
      {
        localObject = new URL(this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaLangString).getHost();
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_a_of_type_JavaUtilHashMap.put("firstserverip", localObject);
        return;
      }
      catch (Exception localException)
      {
        int i;
        boolean bool;
        label371:
        localException.printStackTrace();
      }
      this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream((File)localObject);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.richmedia.OldHttpEngine", 2, "oring Len:" + l + " trunk");
        continue;
        if (QLog.isColorLevel())
        {
          i = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.n;
          if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.c != 1) {
            break label371;
          }
        }
        for (bool = true;; bool = false)
        {
          RichMediaUtil.a(i, bool, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.m, this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_d_of_type_JavaLangString, "createtmp", this.jdField_a_of_type_JavaLangString);
          FileUtils.a(this.jdField_a_of_type_JavaLangString);
          this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
          break;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaIoOutputStream != null) {
          this.jdField_a_of_type_JavaIoOutputStream = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq.jdField_a_of_type_JavaIoOutputStream;
        }
      }
    }
  }
  
  void b(HttpMsg paramHttpMsg)
  {
    NetResp localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    if ((this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) || (localNetResp == null)) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = localNetResp.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap2.containsKey("firstserverip")) {
      localHashMap1.put("firstserverip", localHashMap2.get("firstserverip"));
    }
    if (localHashMap2.containsKey("serverip")) {
      localHashMap1.put("serverip", localHashMap2.get("serverip"));
    }
    if (localHashMap2.containsKey("param_url")) {
      localHashMap1.put("param_url", localHashMap2.get("param_url"));
    }
    if (paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.containsKey(HttpMsg.ai)) {
      localHashMap1.put("netresp_param_reason", paramHttpMsg.jdField_b_of_type_JavaUtilHashMap.get(HttpMsg.ai));
    }
    localNetResp.jdField_a_of_type_JavaUtilHashMap.clear();
    localNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(localHashMap1);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.putAll(paramHttpMsg.jdField_b_of_type_JavaUtilHashMap);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_rspHeader", paramHttpMsg.ah);
    localNetResp.jdField_a_of_type_JavaUtilHashMap.put("param_reqHeader", paramHttpMsg.ag);
    localNetResp.jdField_g_of_type_Int = paramHttpMsg.c();
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
    HttpNetReq localHttpNetReq;
    NetResp localNetResp;
    do
    {
      return;
      localHttpNetReq = this.jdField_a_of_type_ComTencentMobileqqTransfileHttpNetReq;
      localNetResp = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp;
    } while ((localHttpNetReq == null) || (localNetResp == null));
    b(paramHttpMsg2);
    long l1 = System.currentTimeMillis() - localNetResp.jdField_f_of_type_Long;
    localNetResp.jdField_d_of_type_Long += l1;
    if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() >= 1)) {
      ((ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0)).b();
    }
    long l2 = NetworkCenter.a().a();
    int j;
    if (l2 != 0L) {
      j = 1;
    }
    for (;;)
    {
      int i;
      label156:
      label244:
      int k;
      label268:
      boolean bool1;
      label313:
      label377:
      boolean bool2;
      if ((localNetResp.jdField_f_of_type_Int == 9056) && (l1 < 2000L))
      {
        i = this.c;
        this.c = (i - 1);
        if (i > 0)
        {
          if (this.jdField_a_of_type_Boolean) {
            break label711;
          }
          localNetResp.jdField_f_of_type_Int = paramHttpMsg2.h;
          localNetResp.jdField_a_of_type_JavaLangString = paramHttpMsg2.af;
          localNetResp.e = 1;
          if (j == 0)
          {
            localNetResp.jdField_f_of_type_Int = 9004;
            localNetResp.jdField_a_of_type_JavaLangString = "no network";
            localNetResp.e = 1;
          }
          if ((l2 == this.d) || (l2 == 0L) || (this.d == 0L)) {
            break label716;
          }
          i = 1;
          if ((!localHttpNetReq.jdField_b_of_type_Boolean) || (i == 0) || (!RichMediaStrategy.a(paramHttpMsg2.h))) {
            break label721;
          }
          i = 1;
          if (i != 0)
          {
            localNetResp.jdField_f_of_type_Int = 9364;
            localNetResp.jdField_a_of_type_JavaLangString = "netchg";
            if (QLog.isColorLevel())
            {
              k = localHttpNetReq.n;
              if (localHttpNetReq.c != 1) {
                break label726;
              }
              bool1 = true;
              RichMediaUtil.a(k, bool1, localHttpNetReq.m, localHttpNetReq.jdField_d_of_type_JavaLangString, "netChg", "originNet:" + this.d + " cur:" + l2);
            }
          }
          if (this.jdField_b_of_type_Int <= 0) {
            break label732;
          }
          bool1 = true;
          if ((this.jdField_a_of_type_Boolean) || (i != 0) || (!paramHttpMsg2.d()) || (((localNetResp.jdField_d_of_type_Long >= localHttpNetReq.jdField_d_of_type_Long - 5000L) || (this.jdField_a_of_type_Int > localHttpNetReq.k)) && ((!bool1) || (localNetResp.jdField_d_of_type_Long >= localHttpNetReq.jdField_d_of_type_Long * 3L / 2L - 5000L)))) {
            break label1067;
          }
          if (QLog.isColorLevel())
          {
            i = localHttpNetReq.n;
            if (localHttpNetReq.c != 1) {
              break label738;
            }
            bool2 = true;
            label480:
            RichMediaUtil.a(i, bool2, localHttpNetReq.m, localHttpNetReq.jdField_d_of_type_JavaLangString, "retry", "tryTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.h + " consumeTime:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.jdField_d_of_type_Long + " isLastGetData:" + bool1);
          }
          k = 1;
          i = k;
          if (localNetResp.c > 0L)
          {
            if (!localHttpNetReq.c()) {
              break label749;
            }
            if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix == null) {
              break label744;
            }
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
            this.jdField_a_of_type_JavaIoOutputStream = localHttpNetReq.jdField_a_of_type_JavaIoOutputStream;
            i = k;
          }
          label610:
          k = i;
          if (localHttpNetReq.jdField_d_of_type_Boolean)
          {
            k = i;
            if (paramHttpMsg2.c() >= 400)
            {
              k = i;
              if (paramHttpMsg2.c() <= 424)
              {
                i = 0;
                k = i;
                if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
              }
            }
          }
        }
      }
      try
      {
        for (;;)
        {
          this.jdField_a_of_type_JavaIoOutputStream.close();
          try
          {
            label666:
            FileUtils.d(this.jdField_a_of_type_JavaLangString);
            k = i;
          }
          catch (Exception paramHttpMsg1)
          {
            for (;;)
            {
              k = i;
            }
          }
          if (k != 0) {
            break label842;
          }
          c();
          return;
          j = 0;
          break;
          if (j == 0) {
            break label156;
          }
          this.jdField_a_of_type_Int += 1;
          break label156;
          label711:
          c();
          return;
          label716:
          i = 0;
          break label244;
          label721:
          i = 0;
          break label268;
          label726:
          bool1 = false;
          break label313;
          label732:
          bool1 = false;
          break label377;
          label738:
          bool2 = false;
          break label480;
          label744:
          i = 0;
          break label610;
          label749:
          i = k;
          if (!localHttpNetReq.b()) {
            break label610;
          }
          if (localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix != null)
          {
            localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$IBreakDownFix.a(localHttpNetReq, localNetResp);
            i = k;
            break label610;
          }
          k = 0;
          i = k;
          if (this.jdField_a_of_type_JavaIoOutputStream == null) {
            break label610;
          }
          try
          {
            this.jdField_a_of_type_JavaIoOutputStream.close();
            this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_a_of_type_JavaLangString);
            i = 1;
          }
          catch (IOException paramHttpMsg1)
          {
            a(paramHttpMsg1, localNetResp);
            i = k;
          }
        }
        break label610;
        label842:
        if ((localHttpNetReq.jdField_a_of_type_JavaUtilList != null) && (localHttpNetReq.jdField_a_of_type_JavaUtilList.size() >= 1) && (j != 0))
        {
          paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.remove(0);
          localHttpNetReq.jdField_a_of_type_JavaUtilList.add(paramHttpMsg1);
          paramHttpMsg1 = (ServerAddr)localHttpNetReq.jdField_a_of_type_JavaUtilList.get(0);
          paramHttpMsg2 = "http://" + paramHttpMsg1.jdField_a_of_type_JavaLangString;
          if (paramHttpMsg1.jdField_b_of_type_Int != 80)
          {
            paramHttpMsg1 = paramHttpMsg2 + ":" + paramHttpMsg1.jdField_b_of_type_Int + "/";
            localHttpNetReq.jdField_a_of_type_JavaLangString = RichMediaUtil.a(localHttpNetReq.jdField_a_of_type_JavaLangString, paramHttpMsg1);
          }
        }
        else
        {
          if ((localNetResp.jdField_f_of_type_Int != 9056) || (l2 == 0L)) {
            break label1044;
          }
          l1 = 0L;
        }
        for (;;)
        {
          a(l1);
          return;
          paramHttpMsg1 = paramHttpMsg2 + "/";
          break;
          label1044:
          if (l2 != 0L) {
            l1 = 3000L;
          } else {
            l1 = 6000L;
          }
        }
        label1067:
        c();
        return;
      }
      catch (Exception paramHttpMsg1)
      {
        break label666;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.OldHttpEngine.OldHttpCommunicatorListner
 * JD-Core Version:    0.7.0.1
 */