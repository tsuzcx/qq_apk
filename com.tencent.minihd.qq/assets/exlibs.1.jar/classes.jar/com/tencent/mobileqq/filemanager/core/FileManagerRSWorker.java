package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileHttpUploder;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploadPara;
import com.tencent.mobileqq.filemanager.offlinefile.OfflineFileUpload.OfflineFileUploader;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import com.weiyun.sdk.IWyTaskManager.Task;
import irs;
import iru;
import irv;
import irw;
import irx;
import iry;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileManagerRSWorker
  implements IFileHttpBase, IHttpCommunicatorListener
{
  private static final int e = 8;
  private static final int f = 6000;
  private static final String jdField_k_of_type_JavaLangString = "FileManagerRSWorker<FileAssistant>";
  private static final long m = 1000L;
  public int a;
  public long a;
  public QQAppInterface a;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new irs(this);
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  public FileManagerEntity a;
  public OfflineFileHttpUploder a;
  OfflineFileUploader jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = null;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  public IWyTaskManager.Task a;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  public OutputStream a;
  public String a;
  Thread jdField_a_of_type_JavaLangThread;
  public boolean a;
  public byte[] a;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public int b;
  public long b;
  HttpMsg b;
  public String b;
  public byte[] b;
  int c;
  public long c;
  public String c;
  public byte[] c;
  public int d;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  private int g;
  public long g;
  public String g;
  private int h;
  public long h;
  public String h;
  private int i;
  public long i;
  public String i;
  private int j;
  public long j;
  public String j;
  long jdField_k_of_type_Long;
  long jdField_l_of_type_Long = 0L;
  private String jdField_l_of_type_JavaLangString = "";
  private long n = 0L;
  
  public FileManagerRSWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = null;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = null;
    this.k = 0L;
    if (paramFileManagerEntity == null)
    {
      try
      {
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.strFilePath;
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    b();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
      this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
      this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
      paramFileManagerEntity.status = 0;
      paramQQAppInterface.a().c(paramFileManagerEntity);
      paramFileManagerEntity.fProgress = 0.0F;
      paramFileManagerEntity.status = 2;
      if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
      return;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]filepath[" + this.jdField_b_of_type_JavaLangString + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileUp";
        this.jdField_j_of_type_JavaLangString = "actFileUpDetail";
      }
      while ((paramFileManagerEntity.strFilePath != null) && (paramFileManagerEntity.strFilePath.length() > 0))
      {
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.strFilePath);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_i_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath");
        }
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDown";
        this.jdField_j_of_type_JavaLangString = "actFileDownDetail";
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDiscDownLoad";
        this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyDown";
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyUp";
      }
    }
  }
  
  private String a(ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = HexUtil.bytes2HexStr(paramByteStringMicro.toByteArray());
    return "/?ver=2&rkey=" + paramByteStringMicro;
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, long paramLong)
  {
    return "/?ver=2&ukey=" + paramString1 + "&filekey=" + paramString2 + "&filesize=" + paramLong;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      String str2 = "bytes=" + paramLong + "-";
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localHttpMsg.b(false);
      String str1 = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.a("Net-type", str1);
      localHttpMsg.a("cache-control", "no-cache");
      localHttpMsg.a("Range", str2);
      if (paramString != null) {
        localHttpMsg.a("Cookie", paramString);
      }
      localHttpMsg.b(1);
      localHttpMsg.a(true);
      localHttpMsg.jdField_d_of_type_Int = 0;
      localHttpMsg.e = this.jdField_a_of_type_Int;
      localHttpMsg.ae = String.valueOf(this.jdField_c_of_type_Long);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(FileTransferHandler.FileUploadInfo paramFileUploadInfo)
  {
    if (paramFileUploadInfo.jdField_d_of_type_Int == 2)
    {
      if (paramFileUploadInfo.a == 0) {
        paramFileUploadInfo.a = 80;
      }
      this.jdField_f_of_type_JavaLangString = (paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.a);
      return;
    }
    this.jdField_f_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]sendFilePakage transferData null");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((HttpMsg)localObject).b(false);
      ((HttpMsg)localObject).a("cache-control", "no-cache");
      paramString = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((HttpMsg)localObject).a("Net-type", paramString);
      ((HttpMsg)localObject).a("Range", "bytes=" + paramLong + "-");
      ((HttpMsg)localObject).c("POST");
      ((HttpMsg)localObject).b(1);
      ((HttpMsg)localObject).jdField_d_of_type_Int = 0;
      ((HttpMsg)localObject).e = this.jdField_a_of_type_Int;
      ((HttpMsg)localObject).ae = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((HttpMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private void a(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader = new OfflineFileUploader();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader.a(HexUtil.bytes2HexStr(paramArrayOfByte), HexUtil.bytes2HexStr(this.jdField_b_of_type_ArrayOfByte), HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder = new OfflineFileHttpUploder(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileUploader);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder.b();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, FileTransferObserver paramFileTransferObserver, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new OfflineFileUploadPara();
    paramString.jdField_a_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
    paramString.jdField_b_of_type_ArrayOfByte = paramArrayOfByte2;
    paramString.jdField_a_of_type_ArrayOfByte = paramArrayOfByte1;
    paramString.jdField_a_of_type_Long = this.jdField_d_of_type_Long;
    paramString.jdField_c_of_type_ArrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramLong <= 104857600L)
    {
      paramString.jdField_a_of_type_Int = 1700;
      this.jdField_b_of_type_ArrayOfByte = FileManagerUtil.a(new String(paramArrayOfByte1));
      paramString.d = this.jdField_b_of_type_ArrayOfByte;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, paramFileManagerEntity);
      return;
      paramString.jdField_a_of_type_Int = 1600;
      this.jdField_c_of_type_ArrayOfByte = FileManagerUtil.b(new String(paramArrayOfByte1));
      paramString.e = this.jdField_c_of_type_ArrayOfByte;
    }
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {}
    do
    {
      return false;
      if (paramHttpMsg2 == null) {
        return true;
      }
    } while (!NetworkUtil.e(BaseApplication.getContext()));
    return true;
  }
  
  private static String e()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    if (!FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "rename error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      b(null, null);
      return;
    }
    Object localObject = HexUtil.bytes2HexStr(FileManagerUtil.c(this.jdField_b_of_type_JavaLangString));
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if ((2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType) && (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_JavaLangString, 150, 150);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
      a(2003);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      }
      else
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      }
    }
  }
  
  private void k()
  {
    ThreadManager.a().post(new iry(this));
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = AppConstants.aP;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = e();
    }
    paramString1 = new File(str + paramString1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return;
    }
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.c(paramInt);
    if ((this.jdField_j_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_j_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_g_of_type_JavaLangString != null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i1;
    int i2;
    int i3;
    if (paramHttpMsg != null)
    {
      i1 = paramHttpMsg.jdField_d_of_type_Int;
      i2 = paramHttpMsg.e;
      i3 = paramHttpMsg.f;
      if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
      }
      if (!"POST".equals(paramHttpMsg.e())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i3, i1, i2, paramHttpMsg.jdField_i_of_type_Int);
      return;
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 76	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 493
    //   25: iconst_2
    //   26: new 218	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 747
    //   36: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 749
    //   55: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 12
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   73: if_acmpeq +305 -> 378
    //   76: aload_1
    //   77: ifnull +92 -> 169
    //   80: aload_0
    //   81: getfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   84: ifnull +85 -> 169
    //   87: ldc 17
    //   89: iconst_1
    //   90: new 218	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 751
    //   100: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   107: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 753
    //   116: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 755	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   123: invokestatic 407	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 757
    //   132: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   139: invokevirtual 755	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   142: invokestatic 407	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 240
    //   150: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 12
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload 12
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +142 -> 312
    //   173: ldc 17
    //   175: iconst_1
    //   176: new 218	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 751
    //   186: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   193: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 753
    //   202: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 755	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   209: invokestatic 407	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 240
    //   217: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -67 -> 159
    //   229: astore 10
    //   231: aload 10
    //   233: invokevirtual 758	java/lang/Exception:printStackTrace	()V
    //   236: ldc 17
    //   238: iconst_1
    //   239: aload 10
    //   241: invokevirtual 759	java/lang/Exception:toString	()Ljava/lang/String;
    //   244: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: ldc 111
    //   249: astore 9
    //   251: aload 10
    //   253: invokevirtual 763	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   256: astore 10
    //   258: aload 10
    //   260: arraylength
    //   261: istore 4
    //   263: iconst_0
    //   264: istore_3
    //   265: iload_3
    //   266: iload 4
    //   268: if_icmpge +1656 -> 1924
    //   271: aload 10
    //   273: iload_3
    //   274: aaload
    //   275: astore 11
    //   277: new 218	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   284: aload 9
    //   286: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 11
    //   291: invokevirtual 766	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: ldc_w 768
    //   297: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 9
    //   305: iload_3
    //   306: iconst_1
    //   307: iadd
    //   308: istore_3
    //   309: goto -44 -> 265
    //   312: aload_0
    //   313: getfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   316: ifnull -157 -> 159
    //   319: ldc 17
    //   321: iconst_1
    //   322: new 218	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 751
    //   332: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   339: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   342: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 770
    //   348: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   355: invokevirtual 755	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   358: invokestatic 407	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 240
    //   366: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -216 -> 159
    //   378: aload_0
    //   379: getfield 151	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Int	I
    //   382: ifne +1067 -> 1449
    //   385: aload_2
    //   386: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   389: sipush 200
    //   392: if_icmpne +858 -> 1250
    //   395: aload_0
    //   396: getfield 207	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   399: invokevirtual 773	com/tencent/wstt/SSCM/SSCM:b	()V
    //   402: aload_2
    //   403: ldc_w 775
    //   406: invokevirtual 776	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: ifnull +1694 -> 2103
    //   412: aload_2
    //   413: ldc_w 775
    //   416: invokevirtual 776	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 713	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   422: lstore 5
    //   424: lload 5
    //   426: lconst_0
    //   427: lcmp
    //   428: ifeq +110 -> 538
    //   431: aload_0
    //   432: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: aload_0
    //   436: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   439: aload_0
    //   440: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   447: aload_0
    //   448: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_0
    //   456: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   459: aload_0
    //   460: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   463: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   466: ldc2_w 777
    //   469: ldc 111
    //   471: aload_0
    //   472: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   475: aload_0
    //   476: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   479: aload_0
    //   480: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   483: aload_2
    //   484: invokevirtual 779	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   487: aload_2
    //   488: getfield 782	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   495: new 218	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 784
    //   505: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 5
    //   510: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   513: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 240
    //   518: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: aconst_null
    //   525: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: aload_1
    //   530: aload_2
    //   531: invokevirtual 473	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   534: aload 12
    //   536: monitorexit
    //   537: return
    //   538: aload_2
    //   539: ldc_w 385
    //   542: invokevirtual 776	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 9
    //   547: aload 9
    //   549: ifnull +1548 -> 2097
    //   552: aload 9
    //   554: invokestatic 713	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   557: lstore 5
    //   559: lload 5
    //   561: aload_0
    //   562: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   565: lcmp
    //   566: ifgt +365 -> 931
    //   569: new 218	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 786
    //   579: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: lload 5
    //   584: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   587: ldc_w 788
    //   590: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   597: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   600: ldc_w 790
    //   603: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_0
    //   607: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   610: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 792
    //   616: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_0
    //   620: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   623: invokevirtual 442	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   626: ldc 240
    //   628: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: astore 9
    //   636: lload 5
    //   638: aload_0
    //   639: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   642: lcmp
    //   643: ifgt +176 -> 819
    //   646: aload_0
    //   647: getfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   650: iconst_1
    //   651: iadd
    //   652: istore_3
    //   653: aload_0
    //   654: iload_3
    //   655: putfield 103	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   658: iload_3
    //   659: iconst_3
    //   660: if_icmple +159 -> 819
    //   663: aload_0
    //   664: sipush 1005
    //   667: invokevirtual 249	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   670: aload_0
    //   671: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   674: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   677: aload_0
    //   678: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   681: aload_0
    //   682: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   685: aload_0
    //   686: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   689: aload_0
    //   690: getfield 141	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   693: bipush 15
    //   695: aconst_null
    //   696: iconst_5
    //   697: aconst_null
    //   698: invokevirtual 429	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   701: aload_0
    //   702: invokevirtual 794	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:c	()V
    //   705: aload_0
    //   706: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   709: aload_0
    //   710: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   713: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   716: aload_0
    //   717: getfield 86	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   720: aload_0
    //   721: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   724: aload_0
    //   725: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   728: aload_0
    //   729: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   732: aload_0
    //   733: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   736: aload_0
    //   737: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   740: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   743: ldc2_w 795
    //   746: ldc 111
    //   748: aload_0
    //   749: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   752: aload_0
    //   753: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   756: aload_0
    //   757: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   760: aload_0
    //   761: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   764: ldc 111
    //   766: aload_0
    //   767: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   770: aload 9
    //   772: aconst_null
    //   773: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   776: ldc 17
    //   778: iconst_1
    //   779: new 218	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 798
    //   789: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_0
    //   793: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   796: invokevirtual 228	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: ldc 240
    //   801: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload 9
    //   806: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 801	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: aload 12
    //   817: monitorexit
    //   818: return
    //   819: aload_0
    //   820: lload 5
    //   822: putfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   825: aload_0
    //   826: lload 5
    //   828: putfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   831: new 682	android/os/Handler
    //   834: dup
    //   835: invokespecial 802	android/os/Handler:<init>	()V
    //   838: new 804	irt
    //   841: dup
    //   842: aload_0
    //   843: lload 5
    //   845: invokespecial 807	irt:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;J)V
    //   848: ldc2_w 808
    //   851: invokevirtual 813	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   854: pop
    //   855: aload_0
    //   856: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   859: aload_0
    //   860: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   863: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   866: aload_0
    //   867: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   870: aload_0
    //   871: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   874: aload_0
    //   875: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   878: aload_0
    //   879: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   882: aload_0
    //   883: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   886: aload_0
    //   887: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   890: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   893: ldc2_w 795
    //   896: ldc 111
    //   898: aload_0
    //   899: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   902: aload_0
    //   903: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   906: aload_0
    //   907: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   910: aload_0
    //   911: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   914: aload_2
    //   915: getfield 782	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   918: aload_0
    //   919: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   922: aload 9
    //   924: aconst_null
    //   925: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   928: goto -152 -> 776
    //   931: iconst_0
    //   932: istore 4
    //   934: iload 4
    //   936: istore_3
    //   937: aload_0
    //   938: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   941: lconst_0
    //   942: lcmp
    //   943: ifne +67 -> 1010
    //   946: iload 4
    //   948: istore_3
    //   949: lload 5
    //   951: aload_0
    //   952: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   955: lcmp
    //   956: ifne +54 -> 1010
    //   959: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   962: ifeq +1147 -> 2109
    //   965: ldc_w 493
    //   968: iconst_2
    //   969: new 218	java/lang/StringBuilder
    //   972: dup
    //   973: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   976: ldc_w 747
    //   979: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   982: aload_0
    //   983: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   986: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   989: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   992: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   995: ldc_w 815
    //   998: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1001: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1004: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1007: goto +1102 -> 2109
    //   1010: aload_0
    //   1011: lload 5
    //   1013: putfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1016: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1019: ifeq +72 -> 1091
    //   1022: ldc 17
    //   1024: iconst_2
    //   1025: new 218	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1032: ldc 221
    //   1034: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1037: aload_0
    //   1038: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1041: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1044: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1047: ldc_w 491
    //   1050: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1053: aload_0
    //   1054: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1057: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1060: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: ldc_w 817
    //   1066: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1069: aload_0
    //   1070: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1073: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1076: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1079: ldc_w 819
    //   1082: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1085: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1088: invokestatic 246	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1091: lload 5
    //   1093: aload_0
    //   1094: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1097: lcmp
    //   1098: ifge +156 -> 1254
    //   1101: aload_0
    //   1102: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1105: aload_0
    //   1106: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1109: l2f
    //   1110: aload_0
    //   1111: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1114: l2f
    //   1115: fdiv
    //   1116: putfield 205	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1119: aload_0
    //   1120: sipush 1002
    //   1123: invokevirtual 249	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1126: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   1129: lstore 5
    //   1131: lload 5
    //   1133: aload_0
    //   1134: getfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1137: lsub
    //   1138: ldc2_w 20
    //   1141: lcmp
    //   1142: iflt +91 -> 1233
    //   1145: aload_0
    //   1146: lload 5
    //   1148: putfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1151: aload_0
    //   1152: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1155: iconst_3
    //   1156: putfield 637	com/tencent/mobileqq/filemanager/data/FileManagerEntity:cloudType	I
    //   1159: aload_0
    //   1160: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1163: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1166: aload_0
    //   1167: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1170: aload_0
    //   1171: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1174: aload_0
    //   1175: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1178: aload_0
    //   1179: getfield 141	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1182: bipush 16
    //   1184: aconst_null
    //   1185: iconst_0
    //   1186: aconst_null
    //   1187: invokevirtual 429	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1190: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1193: ifeq +40 -> 1233
    //   1196: ldc 17
    //   1198: iconst_2
    //   1199: new 218	java/lang/StringBuilder
    //   1202: dup
    //   1203: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1206: ldc 221
    //   1208: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: aload_0
    //   1212: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1215: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1218: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1221: ldc_w 821
    //   1224: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1227: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1230: invokestatic 246	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1233: aload_0
    //   1234: iconst_0
    //   1235: putfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1238: aload_0
    //   1239: aload_0
    //   1240: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1243: aload_0
    //   1244: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1247: invokevirtual 824	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(Ljava/lang/String;J)V
    //   1250: aload 12
    //   1252: monitorexit
    //   1253: return
    //   1254: aload_0
    //   1255: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   1258: putfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Long	J
    //   1261: aload_0
    //   1262: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   1265: putfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_h_of_type_Long	J
    //   1268: iload_3
    //   1269: ifne +67 -> 1336
    //   1272: aload_0
    //   1273: invokevirtual 826	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:i	()V
    //   1276: new 654	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData
    //   1279: dup
    //   1280: invokespecial 655	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:<init>	()V
    //   1283: astore 9
    //   1285: aload 9
    //   1287: ldc_w 828
    //   1290: putfield 658	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1293: aload 9
    //   1295: iconst_1
    //   1296: putfield 659	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_a_of_type_Int	I
    //   1299: aload_0
    //   1300: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1303: invokevirtual 660	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1306: aload 9
    //   1308: invokestatic 665	com/tencent/mobileqq/filemanager/util/FileManagerReporter:a	(Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData;)V
    //   1311: aload_0
    //   1312: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1315: iconst_1
    //   1316: putfield 193	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1319: aload_0
    //   1320: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1323: invokevirtual 196	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   1326: aload_0
    //   1327: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1330: invokevirtual 201	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1333: goto -83 -> 1250
    //   1336: invokestatic 216	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1339: ifeq +45 -> 1384
    //   1342: ldc_w 493
    //   1345: iconst_2
    //   1346: new 218	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1353: ldc_w 747
    //   1356: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1359: aload_0
    //   1360: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1363: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1366: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1369: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: ldc_w 830
    //   1375: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1381: invokestatic 497	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1384: aload_0
    //   1385: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1388: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1391: invokestatic 832	com/tencent/mobileqq/filemanager/util/FileManagerUtil:b	(J)V
    //   1394: aload_0
    //   1395: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1398: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1401: aload_0
    //   1402: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1405: iconst_5
    //   1406: aload_0
    //   1407: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1410: invokevirtual 835	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1413: aload_0
    //   1414: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1417: invokevirtual 540	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1420: aload_0
    //   1421: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1424: aload_0
    //   1425: getfield 173	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1428: aload_0
    //   1429: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1432: aload_0
    //   1433: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1436: getfield 144	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1439: aload_0
    //   1440: getfield 97	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1443: invokevirtual 838	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1446: goto -170 -> 1276
    //   1449: aload_2
    //   1450: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1453: sipush 206
    //   1456: if_icmpeq +15 -> 1471
    //   1459: aload_2
    //   1460: invokevirtual 772	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1463: istore_3
    //   1464: iload_3
    //   1465: sipush 200
    //   1468: if_icmpne -218 -> 1250
    //   1471: aload_0
    //   1472: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1475: aload_2
    //   1476: invokevirtual 840	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1479: invokevirtual 845	java/io/OutputStream:write	([B)V
    //   1482: aload_0
    //   1483: iconst_0
    //   1484: putfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1487: aload_2
    //   1488: invokevirtual 840	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1491: arraylength
    //   1492: i2l
    //   1493: lstore 5
    //   1495: aload_0
    //   1496: aload_0
    //   1497: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1500: lload 5
    //   1502: ladd
    //   1503: putfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1506: aload_0
    //   1507: lload 5
    //   1509: aload_0
    //   1510: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1513: ladd
    //   1514: putfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1517: aload_0
    //   1518: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1521: lstore 5
    //   1523: aload_2
    //   1524: invokevirtual 847	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()J
    //   1527: lstore 5
    //   1529: aload_0
    //   1530: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1533: lload 5
    //   1535: lcmp
    //   1536: iflt +278 -> 1814
    //   1539: aload_0
    //   1540: getfield 141	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1543: sipush 3000
    //   1546: if_icmpeq +25 -> 1571
    //   1549: aload_0
    //   1550: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1553: invokevirtual 540	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1556: aload_0
    //   1557: getfield 173	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1560: aload_0
    //   1561: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1564: aload_0
    //   1565: getfield 97	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1568: invokevirtual 850	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1571: aload_0
    //   1572: aconst_null
    //   1573: putfield 421	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1576: aload_0
    //   1577: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1580: ifnull +10 -> 1590
    //   1583: aload_0
    //   1584: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1587: invokevirtual 853	java/io/OutputStream:close	()V
    //   1590: aload_0
    //   1591: aconst_null
    //   1592: putfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1595: aload_0
    //   1596: invokespecial 855	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:j	()V
    //   1599: goto -349 -> 1250
    //   1602: astore 9
    //   1604: aload_0
    //   1605: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1608: aload_0
    //   1609: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1612: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1615: aload_0
    //   1616: getfield 86	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1619: aload_0
    //   1620: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1623: aload_0
    //   1624: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1627: aload_0
    //   1628: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1631: aload_0
    //   1632: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1635: aload_0
    //   1636: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1639: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1642: ldc2_w 462
    //   1645: ldc 111
    //   1647: aload_0
    //   1648: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1651: aload_0
    //   1652: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1655: aload_0
    //   1656: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1659: aload_0
    //   1660: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1663: ldc 111
    //   1665: aload_0
    //   1666: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1669: ldc_w 857
    //   1672: aconst_null
    //   1673: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1676: aload_0
    //   1677: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1680: aload_0
    //   1681: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1684: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1687: aload_0
    //   1688: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1691: aload_0
    //   1692: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1695: aload_0
    //   1696: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1699: aload_0
    //   1700: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1703: aload_0
    //   1704: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1707: aload_0
    //   1708: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1711: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1714: ldc2_w 462
    //   1717: ldc 111
    //   1719: aload_0
    //   1720: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1723: aload_0
    //   1724: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1727: aload_0
    //   1728: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1731: aload_0
    //   1732: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1735: ldc 111
    //   1737: aload_0
    //   1738: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   1741: ldc_w 857
    //   1744: aconst_null
    //   1745: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1748: aload_0
    //   1749: aconst_null
    //   1750: aconst_null
    //   1751: invokevirtual 473	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1754: aload 12
    //   1756: monitorexit
    //   1757: return
    //   1758: astore 9
    //   1760: ldc_w 859
    //   1763: iconst_1
    //   1764: new 218	java/lang/StringBuilder
    //   1767: dup
    //   1768: invokespecial 219	java/lang/StringBuilder:<init>	()V
    //   1771: ldc 221
    //   1773: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1776: aload_0
    //   1777: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1780: invokestatic 238	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1783: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1786: ldc_w 861
    //   1789: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1792: aload 9
    //   1794: invokevirtual 862	java/io/IOException:toString	()Ljava/lang/String;
    //   1797: invokevirtual 225	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1800: invokevirtual 243	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1803: invokestatic 246	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1806: aload 9
    //   1808: invokevirtual 863	java/io/IOException:printStackTrace	()V
    //   1811: goto -221 -> 1590
    //   1814: aload_0
    //   1815: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1818: aload_0
    //   1819: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1822: l2f
    //   1823: aload_0
    //   1824: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1827: l2f
    //   1828: fdiv
    //   1829: putfield 205	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1832: aload_0
    //   1833: sipush 2002
    //   1836: invokevirtual 249	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1839: invokestatic 347	java/lang/System:currentTimeMillis	()J
    //   1842: lstore 5
    //   1844: aload_0
    //   1845: getfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1848: lstore 7
    //   1850: lload 5
    //   1852: lload 7
    //   1854: lsub
    //   1855: ldc2_w 20
    //   1858: lcmp
    //   1859: ifge +7 -> 1866
    //   1862: aload 12
    //   1864: monitorexit
    //   1865: return
    //   1866: aload_0
    //   1867: lload 5
    //   1869: putfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1872: aload_0
    //   1873: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1876: aload_0
    //   1877: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1880: l2f
    //   1881: aload_0
    //   1882: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1885: l2f
    //   1886: fdiv
    //   1887: putfield 205	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1890: aload_0
    //   1891: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1894: invokevirtual 424	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1897: aload_0
    //   1898: getfield 62	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1901: aload_0
    //   1902: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1905: aload_0
    //   1906: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1909: aload_0
    //   1910: getfield 141	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1913: bipush 16
    //   1915: aconst_null
    //   1916: iconst_0
    //   1917: aconst_null
    //   1918: invokevirtual 429	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1921: goto -671 -> 1250
    //   1924: ldc 111
    //   1926: astore 10
    //   1928: ldc 111
    //   1930: astore 11
    //   1932: aload_1
    //   1933: ifnull +9 -> 1942
    //   1936: aload_1
    //   1937: invokevirtual 779	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   1940: astore 10
    //   1942: aload 11
    //   1944: astore_1
    //   1945: aload_2
    //   1946: ifnull +8 -> 1954
    //   1949: aload_2
    //   1950: getfield 782	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   1953: astore_1
    //   1954: aload_0
    //   1955: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1958: aload_0
    //   1959: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1962: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1965: aload_0
    //   1966: getfield 86	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1969: aload_0
    //   1970: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1973: aload_0
    //   1974: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1977: aload_0
    //   1978: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1981: aload_0
    //   1982: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1985: aload_0
    //   1986: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1989: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1992: ldc2_w 864
    //   1995: aconst_null
    //   1996: aload_0
    //   1997: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2000: aload_0
    //   2001: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2004: aload_0
    //   2005: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2008: aload 10
    //   2010: aload_1
    //   2011: aload_0
    //   2012: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2015: aload 9
    //   2017: aconst_null
    //   2018: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2021: aload_0
    //   2022: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2025: aload_0
    //   2026: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2029: getfield 190	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2032: aload_0
    //   2033: getfield 88	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2036: aload_0
    //   2037: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2040: aload_0
    //   2041: getfield 113	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2044: aload_0
    //   2045: getfield 161	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2048: aload_0
    //   2049: getfield 146	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2052: aload_0
    //   2053: getfield 163	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2056: getfield 461	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2059: ldc2_w 864
    //   2062: aconst_null
    //   2063: aload_0
    //   2064: getfield 99	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2067: aload_0
    //   2068: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2071: aload_0
    //   2072: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2075: aload 10
    //   2077: aload_1
    //   2078: aload_0
    //   2079: getfield 109	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2082: aload 9
    //   2084: aconst_null
    //   2085: invokestatic 470	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2088: aload_0
    //   2089: aconst_null
    //   2090: aconst_null
    //   2091: invokevirtual 473	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2094: goto -844 -> 1250
    //   2097: lconst_0
    //   2098: lstore 5
    //   2100: goto -1541 -> 559
    //   2103: lconst_0
    //   2104: lstore 5
    //   2106: goto -1682 -> 424
    //   2109: iconst_1
    //   2110: istore_3
    //   2111: goto -1101 -> 1010
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2114	0	this	FileManagerRSWorker
    //   0	2114	1	paramHttpMsg1	HttpMsg
    //   0	2114	2	paramHttpMsg2	HttpMsg
    //   264	1847	3	i1	int
    //   261	686	4	i2	int
    //   422	1683	5	l1	long
    //   1848	5	7	l2	long
    //   249	1058	9	localObject1	Object
    //   1602	1	9	localException1	java.lang.Exception
    //   1758	325	9	localIOException	java.io.IOException
    //   229	23	10	localException2	java.lang.Exception
    //   256	1820	10	localObject2	Object
    //   275	1668	11	localObject3	Object
    //   4	1859	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   9	64	163	finally
    //   64	67	163	finally
    //   68	76	163	finally
    //   80	159	163	finally
    //   159	162	163	finally
    //   164	167	163	finally
    //   173	226	163	finally
    //   231	247	163	finally
    //   251	263	163	finally
    //   277	305	163	finally
    //   312	375	163	finally
    //   378	424	163	finally
    //   431	534	163	finally
    //   534	537	163	finally
    //   538	547	163	finally
    //   552	559	163	finally
    //   559	658	163	finally
    //   663	776	163	finally
    //   776	815	163	finally
    //   815	818	163	finally
    //   819	928	163	finally
    //   937	946	163	finally
    //   949	1007	163	finally
    //   1010	1091	163	finally
    //   1091	1233	163	finally
    //   1233	1250	163	finally
    //   1250	1253	163	finally
    //   1254	1268	163	finally
    //   1272	1276	163	finally
    //   1276	1333	163	finally
    //   1336	1384	163	finally
    //   1384	1446	163	finally
    //   1449	1464	163	finally
    //   1471	1482	163	finally
    //   1482	1571	163	finally
    //   1571	1576	163	finally
    //   1576	1590	163	finally
    //   1590	1599	163	finally
    //   1604	1754	163	finally
    //   1754	1757	163	finally
    //   1760	1811	163	finally
    //   1814	1850	163	finally
    //   1862	1865	163	finally
    //   1866	1921	163	finally
    //   1936	1942	163	finally
    //   1949	1954	163	finally
    //   1954	2094	163	finally
    //   9	64	229	java/lang/Exception
    //   68	76	229	java/lang/Exception
    //   80	159	229	java/lang/Exception
    //   173	226	229	java/lang/Exception
    //   312	375	229	java/lang/Exception
    //   378	424	229	java/lang/Exception
    //   431	534	229	java/lang/Exception
    //   538	547	229	java/lang/Exception
    //   552	559	229	java/lang/Exception
    //   559	658	229	java/lang/Exception
    //   663	776	229	java/lang/Exception
    //   776	815	229	java/lang/Exception
    //   819	928	229	java/lang/Exception
    //   937	946	229	java/lang/Exception
    //   949	1007	229	java/lang/Exception
    //   1010	1091	229	java/lang/Exception
    //   1091	1233	229	java/lang/Exception
    //   1233	1250	229	java/lang/Exception
    //   1254	1268	229	java/lang/Exception
    //   1272	1276	229	java/lang/Exception
    //   1276	1333	229	java/lang/Exception
    //   1336	1384	229	java/lang/Exception
    //   1384	1446	229	java/lang/Exception
    //   1449	1464	229	java/lang/Exception
    //   1482	1571	229	java/lang/Exception
    //   1571	1576	229	java/lang/Exception
    //   1576	1590	229	java/lang/Exception
    //   1590	1599	229	java/lang/Exception
    //   1604	1754	229	java/lang/Exception
    //   1760	1811	229	java/lang/Exception
    //   1814	1850	229	java/lang/Exception
    //   1866	1921	229	java/lang/Exception
    //   1471	1482	1602	java/lang/Exception
    //   1576	1590	1758	java/io/IOException
  }
  
  public void a(Object paramObject)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int i1;
    Object localObject;
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        i1 = 0;
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      int i2 = localHttpMsg.jdField_h_of_type_Int;
      localObject = localHttpMsg.d();
      i1 = i2;
      paramObject = localObject;
      if (i2 == 0)
      {
        i1 = i2;
        paramObject = localObject;
        if (localObject == null)
        {
          i1 = 9001;
          paramObject = "[Http_RespValue_Null]" + FileManagerUtil.a();
        }
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + i1 + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        i1 = 9042;
      }
      break;
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(localHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.b(), localHttpMsg.ah, this.jdField_i_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      i1 = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9062L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b(), this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah, this.jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d() + "&UrlOver", null);
    a(null);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramLong == 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    int i2 = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, 1048576);
    int i3 = Utils.a(BaseApplication.getContext());
    int i1;
    if (i3 != 1)
    {
      i1 = i2;
      if (i3 != 2) {}
    }
    else
    {
      i1 = i2;
      if (i2 > 16384) {
        i1 = 16384;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + paramLong + "], packetSize[" + i1 + "]");
    a(paramString, paramLong, i1);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i1;
    if (paramLong == 0L)
    {
      FMConstants.ad = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, FMConstants.ab);
      if (this.jdField_d_of_type_Long < FMConstants.ad) {}
      for (l1 = this.jdField_d_of_type_Long;; l1 = FMConstants.ad)
      {
        i1 = (int)l1;
        this.jdField_a_of_type_Long = 0L;
        i1 = Math.min(i1, 1048576);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + i1 + "]");
        }
        a(paramString, paramLong, i1, paramArrayOfByte);
        return;
      }
    }
    FMConstants.ab = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong, FMConstants.ab);
    this.jdField_e_of_type_Long = FMConstants.ab;
    if (this.jdField_d_of_type_Long < this.jdField_e_of_type_Long + paramLong) {}
    for (long l1 = this.jdField_d_of_type_Long - paramLong;; l1 = this.jdField_e_of_type_Long)
    {
      int i2 = (int)l1;
      int i3 = Utils.a(BaseApplication.getContext());
      if (i3 != 1)
      {
        i1 = i2;
        if (i3 != 2) {
          break;
        }
      }
      i1 = i2;
      if (i2 <= 16384) {
        break;
      }
      i1 = 16384;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      j();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 944	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 136	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 945	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 944	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 136	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 945	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 951	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 952	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 952	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   144: lsub
    //   145: invokevirtual 956	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 863	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 944	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 136	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 945	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 119	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   190: aload_0
    //   191: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 956	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 863	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FileManagerRSWorker
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	java.lang.Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = AppConstants.aP;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]getTransferFilePath dir: " + (String)localObject);
    String str = AppConstants.aE;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Root[" + str + "]");
    str = AppConstants.aG;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "SDCard[" + str + "]");
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = AppConstants.aR;
      localObject = new File(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getTmpDir[" + bool1 + "]");
      }
      return this.jdField_c_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],ReceiveOfflineForOldMsg");
    if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        i1 = 9080;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "errserverPathForOldMsg", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "errServerPathForOldMsg", null);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          i1 = 9081;
        } else {
          i1 = 9020;
        }
      }
    }
    if (-1L != this.jdField_b_of_type_Long) {}
    label1299:
    Object localObject;
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);; localObject = null)
    {
      if (localMessageRecord != null)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        TransFileInfo localTransFileInfo = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_JavaLangString });
        localEntityManager.a();
        if ((localTransFileInfo != null) && (2008 == localTransFileInfo.status)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
      }
      if ((localMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 1)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        if (a()) {
          break;
        }
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
        a(2003);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
        FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
        return;
      }
      if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
      {
        long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
        if (SystemUtil.a()) {}
        for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "sdcard full", null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "sdcard full", null);
          return;
        }
      }
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 2002);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        a(this.jdField_a_of_type_Long, null);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label1299;
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.d();
    }
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]transferedSize[" + this.jdField_a_of_type_Long + "]isStop[" + String.valueOf(a()) + "],  status[" + String.valueOf(this.jdField_j_of_type_Int) + "], strErrString[" + str1 + "], autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
      if ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)) {}
      do
      {
        return;
        if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
        {
          c();
          a(null);
          return;
        }
      } while ((!NetworkUtil.e(BaseApplication.getContext())) && ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)));
      int i2 = paramHttpMsg2.jdField_h_of_type_Int;
      if (FileHttpUtils.a(paramHttpMsg2.jdField_h_of_type_Int))
      {
        this.jdField_i_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor == null) {
          break label1123;
        }
      }
      label641:
      label780:
      label1116:
      label1123:
      for (String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();; str2 = null)
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str2 + "]errCode[" + i2 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, paramHttpMsg2.d() + "&goChangeUrl", null);
        long l1;
        if ((str2 == null) || (str2.length() == 0))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i2 + "]");
          l1 = this.jdField_g_of_type_Long;
          if (str1.indexOf("-29602") <= 0) {
            break label641;
          }
          paramHttpMsg2.jdField_h_of_type_Int = -29602;
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, paramHttpMsg2.d(), null);
        }
        do
        {
          for (;;)
          {
            this.jdField_g_of_type_Int = 0;
            c();
            a(paramHttpMsg2);
            return;
            b(str2);
            return;
            QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i2 + "]");
            break;
            if (a(paramHttpMsg1, paramHttpMsg2))
            {
              if (str1.indexOf("-29120") > 0)
              {
                this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
                this.jdField_f_of_type_JavaLangString = "";
              }
              if (str1.indexOf("-6101") <= 0) {
                break label780;
              }
              FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, paramHttpMsg2.d(), null);
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          if (QLog.isColorLevel()) {
            QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]handleError-----------retryTime:" + this.jdField_g_of_type_Int);
          }
        } while (this.jdField_g_of_type_Int >= 8);
        this.jdField_g_of_type_Int += 1;
        this.jdField_i_of_type_Int += 1;
        if ((this.jdField_h_of_type_Int < 3) && (i2 == 9056))
        {
          this.jdField_h_of_type_Int += 1;
          this.jdField_g_of_type_Int -= 1;
          if (i2 != 9056) {
            break label1116;
          }
        }
        for (int i1 = 0;; i1 = 6000)
        {
          new Handler().postDelayed(new iru(this), i1);
          QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + i1 + "] time retry!");
          if (9048 == i2) {
            i2 = 11202;
          }
          for (;;)
          {
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, l1, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, "delayTimes[" + i1 + "]" + paramHttpMsg2.d(), null);
            return;
            this.jdField_h_of_type_Int = 0;
            break;
          }
        }
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int += 1;
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int += 1;
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, null);
  }
  
  public boolean b()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      b(null, null);
      return false;
    }
    Object localObject;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (localObject != null)
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], entify" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        }
        this.jdField_e_of_type_Long = FMConstants.ab;
        this.jdField_i_of_type_Long = 0L;
        a(this.jdField_f_of_type_JavaLangString, 0L);
        return true;
      }
    }
    this.jdField_a_of_type_ArrayOfByte = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_d_of_type_Long);
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      byte[] arrayOfByte = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.jdField_e_of_type_JavaLangString, arrayOfByte, (byte[])localObject, this.jdField_d_of_type_Long, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      a(0);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Long <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / this.jdField_d_of_type_Long);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangThread = null;
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder != null) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerOfflinefileOfflineFileUploadOfflineFileHttpUploder.a();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]stop serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]WeiyunFile stop!!!");
      }
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is Successed, return!");
      }
      return;
    }
    if (this.jdField_b_of_type_Int == 0) {
      a(1004);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]stop for pause!");
      }
      long l1 = System.currentTimeMillis();
      String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, str, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, str, null);
      return;
      if (1 == this.jdField_b_of_type_Int) {
        a(2004);
      } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
        this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
      } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
        this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangThread = new Thread(new irv(this));
    this.jdField_a_of_type_JavaLangThread.start();
    if ((this.jdField_b_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
      k();
    }
  }
  
  protected void finalize()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      c();
      super.finalize();
      return;
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
  }
  
  public void g()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]weiyun local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + "] modifytime[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new irw(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  public void h()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new irx(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  public void i()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    a(1003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "uuid is null Entity[" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */