package com.tencent.mobileqq.app;

import android.content.ContentValues;
import android.content.Intent;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.PrinterSessionAdapter;
import com.tencent.litetransfersdk.Session;
import com.tencent.mobileqq.app.proxy.DataLineMsgProxy;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.pcpush.OpenFileUtil;
import com.tencent.qphone.base.util.QLog;
import hmr;
import hms;
import hmt;
import hmu;
import hmv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import msf.msgcomm.msg_comm.Msg;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter;
import tencent.im.s2c.msgtype0x211.submsgtype0x9.C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo;

public class PrinterHandler
{
  public static final int a = 55;
  public static final String a = "dataline.Printer";
  public static final int b = 56;
  public static final String b = "printer";
  public static final int c = 57;
  public static final String c = "sFilesSelected";
  public static final int d = 0;
  public static final String d = "sPrinterName";
  public static final int e = 1;
  public static final String e = "sPrintParam";
  public static final int f = 2;
  public static final String f = "sPrintResult";
  public static final int g = 3;
  public static final String g = "sPrintSessionID";
  public static final int h = 5;
  long jdField_a_of_type_Long = 0L;
  public PrinterSessionAdapter a;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new hmu(this);
  public QQAppInterface a;
  public ArrayList a;
  public HashMap a;
  public List a;
  public Timer a;
  public boolean a;
  public List b = null;
  public String h;
  public int i = 0;
  
  public PrinterHandler(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilTimer = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComDatalineUtilPrinterSessionAdapter = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  public int a()
  {
    int j = 0;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
    if (DataLineMsgProxy.a((ProxyManager)localObject2, "mr_dataline_printer")) {
      ((ProxyManager)localObject2).a((EntityManager)localObject1);
    }
    long l = 2147483647L;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      l = ((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).msgId;
    }
    localObject2 = ((EntityManager)localObject1).a(PrinterItemMsgRecord.class, "select * from mr_dataline_printer where msgid<? order by msgid desc limit 5", new String[] { String.valueOf(l) });
    ((EntityManager)localObject1).a();
    if (localObject2 != null)
    {
      int k = ((List)localObject2).size();
      j = 0;
      while (j < ((List)localObject2).size())
      {
        localObject1 = (PrinterItemMsgRecord)((List)localObject2).get(j);
        if (((PrinterItemMsgRecord)localObject1).status < 10) {
          ((PrinterItemMsgRecord)localObject1).status = 11;
        }
        this.jdField_a_of_type_JavaUtilArrayList.add(0, localObject1);
        j += 1;
      }
      j = k;
    }
    return j;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
  }
  
  public void a(int paramInt)
  {
    if ((1021 == paramInt) && (QLog.isDevelopLevel())) {
      QLog.d("dataline.Printer", 4, "向pc枚举打印机，server回包,");
    }
  }
  
  public void a(int paramInt, Session paramSession, double paramDouble, boolean paramBoolean)
  {
    if (!DataLineHandler.a(paramSession, "printer")) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          switch (paramInt)
          {
          default: 
            return;
          case 0: 
            paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
          }
        } while (paramSession == null);
        paramSession.status = 2;
        paramSession.progress = (0.7D * paramDouble);
        return;
        l1 = this.jdField_a_of_type_Long + 1L;
        this.jdField_a_of_type_Long = l1;
        localObject = new PrinterItemMsgRecord(l1);
        ((PrinterItemMsgRecord)localObject).uSessionID = paramSession.uSessionID;
        if (QLog.isColorLevel()) {
          QLog.d("dataline.Printer", 2, "获得printID=" + ((PrinterItemMsgRecord)localObject).uSessionID + ", path=" + paramSession.strFilePathSrc);
        }
        ((PrinterItemMsgRecord)localObject).filename = paramSession.strFilePathSrc;
        ((PrinterItemMsgRecord)localObject).time = MessageCache.a();
        this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
        b((PrinterItemMsgRecord)localObject);
        this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(((PrinterItemMsgRecord)localObject).uSessionID), localObject);
        return;
        paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
      } while (paramSession == null);
      paramSession.status = 2;
      paramSession.progress = ((float)(0.7D * paramDouble));
      return;
      paramSession = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramSession.uSessionID));
    } while (paramSession == null);
    long l2;
    if (paramBoolean)
    {
      paramSession.progress = 0.699999988079071D;
      paramSession.status = 2;
      localObject = new Timer();
      paramSession.mTimer_for_Print = ((Timer)localObject);
      localObject = new hmt(this, paramSession.uSessionID, (Timer)localObject);
      l2 = MessageCache.a();
      if (l2 < paramSession.time) {
        break label458;
      }
    }
    label458:
    for (long l1 = l2 - paramSession.time;; l1 = l2)
    {
      l1 = Math.max(Math.min(l1, 1800L), 60L);
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, "printID=" + paramSession.uSessionID + ", 当前时间[" + l2 + "], 开始时间[" + paramSession.time + "], 超时时间[" + l1);
      }
      paramSession.mTimer_for_Print.schedule((TimerTask)localObject, l1 * 1000L);
      return;
      paramSession.status = 12;
      c(paramSession);
      return;
    }
  }
  
  public void a(BaseActivity paramBaseActivity, String paramString)
  {
    if (FileManagerUtil.a())
    {
      if (FileUtils.a(paramString) > 5242880L) {
        FMDialogUtil.a(paramBaseActivity, 2131362469, 2131362465, new hmv(this, paramBaseActivity, paramString));
      }
      return;
    }
    Intent localIntent = new Intent(paramBaseActivity, PrinterActivity.class);
    localIntent.putExtra(AlbumConstants.i, 55);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramString);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramBaseActivity.startActivity(localIntent);
    paramBaseActivity.finish();
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004059", "0X8004059", 0, 0, "", "", "", "");
  }
  
  public void a(DataLineHandler paramDataLineHandler)
  {
    Object localObject1 = (RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9);
    if ((((RegisterProxySvcPackHandler)localObject1).a() != 0) && (((RegisterProxySvcPackHandler)localObject1).f() == 1)) {
      if (this.jdField_a_of_type_JavaUtilTimer == null)
      {
        localObject1 = new hmr(this);
        this.jdField_a_of_type_JavaUtilTimer = new Timer();
        this.jdField_a_of_type_JavaUtilTimer.schedule((TimerTask)localObject1, 30000L);
        Object localObject2 = new C2CType0x211_SubC2CType0x9.MsgBody();
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).str_service.set("printer");
        ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).uint32_CMD.set(1);
        this.i += 1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
        localObject2 = ((C2CType0x211_SubC2CType0x9.MsgBody)localObject2).toByteArray();
        paramDataLineHandler.a(this.i, (String)localObject1, 529, 9, 1021, (byte[])localObject2, 0L);
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      paramDataLineHandler.b(12, false, null);
    } while (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0);
    localObject1 = new Timer();
    ((Timer)localObject1).schedule(new hms(this, paramDataLineHandler, (Timer)localObject1), 5000L);
  }
  
  public void a(DataLineHandler paramDataLineHandler, msg_comm.Msg paramMsg, C2CType0x211_SubC2CType0x9.MsgBody paramMsgBody)
  {
    boolean bool = false;
    switch (paramMsgBody.uint32_CMD.get())
    {
    default: 
    case 2: 
      do
      {
        return;
        this.jdField_a_of_type_Boolean = false;
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
          this.jdField_a_of_type_JavaUtilTimer = null;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.Printer", 4, "收到pc的打印机列表");
        }
        paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
        if (paramMsg != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("dataline.Printer", 2, "收到pc的打印机列表, msgPrinter为空");
      return;
      this.jdField_a_of_type_JavaUtilList = paramMsg.rpt_string_printer.get();
      this.b = paramMsg.rpt_msg_support_file_info.get();
      if ((((RegisterProxySvcPackHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(9)).a() != 0) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
        this.jdField_a_of_type_Boolean = true;
      }
      paramDataLineHandler.b(12, false, null);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004022", "0X8004022", 0, 0, "", "", "", "");
      return;
    }
    int k = -1;
    paramMsg = (C2CType0x211_SubC2CType0x9.MsgBody.MsgPrinter)paramMsgBody.msg_printer.get();
    int j;
    long l;
    if (paramMsg == null)
    {
      j = k;
      if (!QLog.isColorLevel()) {
        break label475;
      }
      QLog.d("dataline.Printer", 2, "收到pc的打印结果, msgPrinter为空");
      l = 0L;
      j = k;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "收到pc的打印结果, print_result = " + j + ", print_id = " + l);
      }
      new Intent().putExtra("sPrintResult", j);
      if (j == 0) {
        bool = true;
      }
      paramDataLineHandler.b(18, bool, Long.valueOf(l));
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)l, j, "", "", "", "");
      return;
      k = paramMsg.uint32_print_result.get();
      paramMsg = paramMsg.rpt_uint64_session_id.get();
      if ((paramMsg == null) || (paramMsg.size() == 0))
      {
        j = k;
        if (QLog.isColorLevel())
        {
          QLog.d("dataline.Printer", 2, "收到pc的打印结果, rpt_uint64_session_id为空. print_result = " + k);
          l = 0L;
          j = k;
        }
      }
      else
      {
        l = ((Long)paramMsg.get(0)).longValue();
        j = k;
        continue;
      }
      label475:
      l = 0L;
    }
  }
  
  public void a(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    if (paramPrinterItemMsgRecord.mTimer_for_Print != null)
    {
      paramPrinterItemMsgRecord.mTimer_for_Print.cancel();
      paramPrinterItemMsgRecord.mTimer_for_Print = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramPrinterItemMsgRecord);
    this.jdField_a_of_type_JavaUtilHashMap.remove(Long.valueOf(paramPrinterItemMsgRecord.uSessionID));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8004021", "0X8004021", (int)paramPrinterItemMsgRecord.uSessionID, -2, "", "", "", "");
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), "msgId=?", new String[] { String.valueOf(paramPrinterItemMsgRecord.msgId) }, 2, null);
  }
  
  public void a(Long paramLong, boolean paramBoolean)
  {
    PrinterItemMsgRecord localPrinterItemMsgRecord = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilHashMap.get(paramLong);
    int j;
    if (localPrinterItemMsgRecord == null)
    {
      j = this.jdField_a_of_type_JavaUtilArrayList.size() - 1;
      if (j >= 0) {
        if (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(j)).uSessionID == paramLong.longValue()) {
          localPrinterItemMsgRecord = (PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        }
      }
    }
    for (;;)
    {
      if (localPrinterItemMsgRecord != null) {
        if (!paramBoolean) {
          break label136;
        }
      }
      label136:
      for (j = 10;; j = 11)
      {
        localPrinterItemMsgRecord.status = j;
        localPrinterItemMsgRecord.progress = 1.0D;
        if (localPrinterItemMsgRecord.mTimer_for_Print != null)
        {
          localPrinterItemMsgRecord.mTimer_for_Print.cancel();
          localPrinterItemMsgRecord.mTimer_for_Print = null;
        }
        this.jdField_a_of_type_JavaUtilHashMap.remove(paramLong);
        c(localPrinterItemMsgRecord);
        return;
        j -= 1;
        break;
      }
    }
  }
  
  public boolean a(String paramString)
  {
    if (paramString == null) {}
    String[] arrayOfString;
    do
    {
      return false;
      arrayOfString = a();
    } while ((arrayOfString == null) || (!OpenFileUtil.a(paramString.toLowerCase(), arrayOfString)));
    return true;
  }
  
  public String[] a()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.jdField_a_of_type_Boolean)
    {
      localObject1 = localObject2;
      if (this.b != null)
      {
        localObject1 = new String[this.b.size()];
        int j = this.b.size() - 1;
        while (j >= 0)
        {
          localObject1[j] = ("." + ((C2CType0x211_SubC2CType0x9.MsgBody.SupportFileInfo)this.b.get(j)).str_file_suffix.get());
          j -= 1;
        }
      }
    }
    return localObject1;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
      for (;;)
      {
        if ((this.jdField_a_of_type_JavaUtilArrayList.size() <= 5) || (((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(0)).status == 2)) {
          return this.jdField_a_of_type_JavaUtilArrayList.size();
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      }
    }
    int j = a();
    if (this.jdField_a_of_type_Long == 0L)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        this.jdField_a_of_type_Long = ((PrinterItemMsgRecord)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_JavaUtilArrayList.size() - 1)).msgId;
      }
      if (QLog.isColorLevel()) {
        QLog.d("dataline.Printer", 2, "初始化PrinterItemMsgRecord的msgid为" + this.jdField_a_of_type_Long);
      }
    }
    return j;
  }
  
  public void b(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    PrinterItemMsgRecord localPrinterItemMsgRecord = paramPrinterItemMsgRecord.clone();
    localProxyManager.a(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), localPrinterItemMsgRecord, 0, null);
  }
  
  public void c(PrinterItemMsgRecord paramPrinterItemMsgRecord)
  {
    ProxyManager localProxyManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("status", Integer.valueOf(paramPrinterItemMsgRecord.status));
    localProxyManager.a(String.valueOf(0), 0, paramPrinterItemMsgRecord.getTableName(), localContentValues, "msgId=?", new String[] { String.valueOf(paramPrinterItemMsgRecord.msgId) }, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler
 * JD-Core Version:    0.7.0.1
 */