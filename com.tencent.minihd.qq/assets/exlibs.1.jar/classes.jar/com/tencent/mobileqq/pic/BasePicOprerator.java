package com.tencent.mobileqq.pic;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.aio.item.PicItemBuilder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.TransferRequest.PicDownExtraInfo;
import com.tencent.mobileqq.transfile.TransferResult;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import jlj;
import jlk;
import jlo;
import jlp;
import jlq;
import jlr;
import jlu;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BasePicOprerator
  implements DownCallBack, InfoBuilder, UpCallBack, jlu
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  public static final int e = 4;
  public static final int f = 5;
  public static final int g = 6;
  protected Handler a;
  public QQAppInterface a;
  public MessageRecord a;
  public PicReq a;
  public UiCallBack a;
  public String a;
  public String b;
  
  public BasePicOprerator() {}
  
  public BasePicOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new jlj(this, Looper.getMainLooper());
    }
  }
  
  private TransferRequest a(PicDownloadInfo paramPicDownloadInfo, String paramString)
  {
    paramPicDownloadInfo.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.jdField_a_of_type_Boolean = false;
    localTransferRequest.jdField_a_of_type_Int = paramPicDownloadInfo.jdField_b_of_type_Int;
    boolean bool;
    if (paramPicDownloadInfo.jdField_f_of_type_Int == 1)
    {
      bool = true;
      localTransferRequest.jdField_b_of_type_Int = URLDrawableHelper.a(paramString, bool);
      localTransferRequest.jdField_a_of_type_Long = paramPicDownloadInfo.jdField_a_of_type_Long;
      localTransferRequest.jdField_b_of_type_Long = paramPicDownloadInfo.jdField_i_of_type_Int;
      localTransferRequest.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_b_of_type_JavaLangString;
      localTransferRequest.jdField_b_of_type_JavaLangString = paramPicDownloadInfo.jdField_c_of_type_JavaLangString;
      localTransferRequest.jdField_d_of_type_JavaLangString = paramPicDownloadInfo.jdField_g_of_type_JavaLangString;
      localTransferRequest.jdField_h_of_type_JavaLangString = null;
      localTransferRequest.jdField_a_of_type_ComTencentMobileqqPicDownCallBack = this;
      localTransferRequest.jdField_c_of_type_Boolean = false;
      localTransferRequest.jdField_g_of_type_JavaLangString = paramPicDownloadInfo.b();
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null)) {
        localTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
      }
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "convert2TranferRequest", "outFilePath:" + localTransferRequest.jdField_g_of_type_JavaLangString + "info.protocol:" + paramPicDownloadInfo.jdField_e_of_type_JavaLangString);
      paramString = new TransferRequest.PicDownExtraInfo();
      localTransferRequest.jdField_a_of_type_JavaLangObject = paramString;
      if (localTransferRequest.jdField_b_of_type_Int != 65537) {
        break label350;
      }
      if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
      {
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_h_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_g_of_type_Int = PicPreDownloadUtils.a();
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_b_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
        paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 1;
      }
      paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_h_of_type_JavaLangString;
    }
    for (;;)
    {
      localTransferRequest.jdField_e_of_type_JavaLangString = paramPicDownloadInfo.jdField_f_of_type_JavaLangString;
      localTransferRequest.jdField_c_of_type_Long = paramPicDownloadInfo.jdField_b_of_type_Long;
      localTransferRequest.jdField_c_of_type_Int = paramPicDownloadInfo.jdField_e_of_type_Int;
      localTransferRequest.jdField_d_of_type_Int = paramPicDownloadInfo.jdField_a_of_type_Int;
      localTransferRequest.jdField_f_of_type_Boolean = true;
      localTransferRequest.jdField_f_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
      return localTransferRequest;
      bool = false;
      break;
      label350:
      if (localTransferRequest.jdField_b_of_type_Int == 1)
      {
        paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_i_of_type_JavaLangString;
        if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_i_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_j_of_type_Int = PicPreDownloadUtils.a();
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 2;
        }
      }
      else if (localTransferRequest.jdField_b_of_type_Int == 131075)
      {
        paramString.jdField_a_of_type_JavaLangString = paramPicDownloadInfo.jdField_j_of_type_JavaLangString;
        if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo != null)
        {
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_i_of_type_Int = paramPicDownloadInfo.jdField_j_of_type_Int;
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_j_of_type_Int = PicPreDownloadUtils.a();
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_c_of_type_Long = (System.currentTimeMillis() - paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_a_of_type_Long);
          paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicReportInfo.jdField_e_of_type_Int = 2;
        }
      }
    }
  }
  
  private String a(PicFowardInfo paramPicFowardInfo)
  {
    Object localObject3 = null;
    int i;
    Object localObject1;
    if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.m == 1)
    {
      i = 1;
      if (!FileUtils.b(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString)) {
        break label362;
      }
      localObject1 = new CompressInfo(paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString, 0, 1009);
      CompressOperator.a((CompressInfo)localObject1);
      localObject1 = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject1);
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        Object localObject2 = URLDrawableHelper.a(paramPicFowardInfo, 1, null);
        if (localObject2 != null) {}
        for (localObject2 = AbsDownloader.d(((URL)localObject2).toString());; localObject2 = null)
        {
          if (!FileUtils.b((String)localObject2)) {
            break label174;
          }
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find big compress image at " + (String)localObject2);
          localObject1 = localObject2;
          return localObject1;
          i = 0;
          break;
        }
        label174:
        localObject2 = localObject1;
        if (i != 0)
        {
          localObject2 = URLDrawableHelper.a(paramPicFowardInfo, 131075, null);
          if (localObject2 == null) {
            break label354;
          }
        }
        label354:
        for (String str = AbsDownloader.d(((URL)localObject2).toString());; str = null)
        {
          localObject2 = localObject1;
          if (FileUtils.b(str))
          {
            localObject1 = new CompressInfo(str, 0);
            ((CompressInfo)localObject1).jdField_a_of_type_Int = 1009;
            CompressOperator.a((CompressInfo)localObject1);
            localObject2 = ((CompressInfo)localObject1).jdField_e_of_type_JavaLangString;
            Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "Compress raw to big compress image at " + (String)localObject2);
          }
          localObject1 = localObject2;
          if (localObject2 != null) {
            break;
          }
          localObject1 = URLDrawableHelper.a(paramPicFowardInfo, 65537, null);
          paramPicFowardInfo = localObject3;
          if (localObject1 != null) {
            paramPicFowardInfo = AbsDownloader.d(((URL)localObject1).toString());
          }
          localObject1 = localObject2;
          if (!FileUtils.b(paramPicFowardInfo)) {
            break;
          }
          Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "uploadForwardMultiMsgPics.getTargetPicFilepath", "find thumb image at " + paramPicFowardInfo);
          return paramPicFowardInfo;
        }
      }
      return localObject1;
      label362:
      localObject1 = null;
    }
  }
  
  private void a(MessageForPic paramMessageForPic)
  {
    int i = 1;
    if (paramMessageForPic.md5 == null) {}
    do
    {
      return;
      if (paramMessageForPic.fileSizeFlag == 1) {
        i = 131075;
      }
      str = URLDrawableHelper.a(paramMessageForPic.md5, i).toString();
    } while (AbsDownloader.a(str));
    String str = AbsDownloader.d(str);
    FileUtils.c(paramMessageForPic.path, str);
  }
  
  private void a(MessageRecord paramMessageRecord)
  {
    long l = System.currentTimeMillis();
    ((SVIPHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(12)).a(paramMessageRecord);
    if ((PicItemBuilder.jdField_g_of_type_Int == 1) || (PicItemBuilder.jdField_g_of_type_Int == 2)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
    for (;;)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a());
    }
  }
  
  private void a(PicFowardInfo paramPicFowardInfo)
  {
    ThreadManager.b(new jlp(this, paramPicFowardInfo));
  }
  
  private boolean a(PicDownloadInfo paramPicDownloadInfo)
  {
    if (paramPicDownloadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info:" + paramPicDownloadInfo);
      return paramPicDownloadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicDownloadInfo", "info == null");
    return false;
  }
  
  private boolean a(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      return paramPicFowardInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private boolean a(PicUploadInfo paramPicUploadInfo)
  {
    if (paramPicUploadInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info:" + paramPicUploadInfo);
      return paramPicUploadInfo.a();
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkPicUploadInfo", "info == null");
    return false;
  }
  
  private void b(PicUploadInfo paramPicUploadInfo)
  {
    ThreadManager.b(new jlr(this, paramPicUploadInfo));
  }
  
  private boolean b(PicFowardInfo paramPicFowardInfo)
  {
    if (paramPicFowardInfo != null)
    {
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info:" + paramPicFowardInfo);
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo == null)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "upInfo == null");
        return false;
      }
      if (((paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1000) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1020) || (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int == 1004)) && (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_JavaLangString == null))
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "secondId invalid,uinType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_b_of_type_Int + ",secondId:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_d_of_type_JavaLangString);
        return false;
      }
      if (paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_h_of_type_Int == -1)
      {
        paramPicFowardInfo.a("PicFowardInfo.check", "protocolType invalid,protocolType:" + paramPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_h_of_type_Int);
        return false;
      }
      if (a(paramPicFowardInfo) != null) {
        return true;
      }
      paramPicFowardInfo.a("PicFowardInfo.check", "getForwardMultiMsgPicsTargetFilepath == null");
      return false;
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkFowardPicInfo", "info == null");
    return false;
  }
  
  private void c(PicReq paramPicReq)
  {
    int i = 0;
    PicDownloadInfo localPicDownloadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (!a(localPicDownloadInfo))
    {
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.jdField_a_of_type_Int = -1;
      paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
      a(paramPicReq);
    }
    String str;
    label457:
    do
    {
      MessageForPic localMessageForPic;
      int j;
      TransferRequest localTransferRequest;
      long l;
      do
      {
        return;
        localMessageForPic = paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        j = paramPicReq.p;
        localTransferRequest = a(localPicDownloadInfo, localPicDownloadInfo.jdField_e_of_type_JavaLangString);
        str = localTransferRequest.jdField_g_of_type_JavaLangString;
        l = new File(str).length();
        if ((1537 != j) || (l <= 0L) || (l >= paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)) {
          break;
        }
        paramPicReq = new DownCallBack.DownResult();
        paramPicReq.jdField_a_of_type_Int = 0;
        paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.jdField_g_of_type_JavaLangString;
        paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.jdField_e_of_type_JavaLangString;
        paramPicReq.jdField_c_of_type_Int = localTransferRequest.jdField_b_of_type_Int;
        paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_j_of_type_Int;
        paramPicReq.jdField_a_of_type_Boolean = true;
        a(paramPicReq);
      } while (!QLog.isDevelopLevel());
      QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():head download second pass " + str);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (l == 0L)
      {
        localTransferRequest.jdField_g_of_type_Int = 0;
        if (localMessageForPic.mDownloadLength == paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size)
        {
          localTransferRequest.jdField_h_of_type_Int = 0;
          localStringBuilder.append("nofile:");
        }
      }
      for (;;)
      {
        localStringBuilder.append("mRequestOffset is " + localTransferRequest.jdField_g_of_type_Int + ", mRequestLength is " + localTransferRequest.jdField_h_of_type_Int + ", ");
        localStringBuilder.append("outPath is " + str);
        if (QLog.isDevelopLevel()) {
          QLog.d("peak_pgjpeg", 4, localStringBuilder.toString());
        }
        localTransferRequest.jdField_i_of_type_Int = localMessageForPic.mShowLength;
        localTransferRequest.jdField_j_of_type_JavaLangString = localPicDownloadInfo.c();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localTransferRequest);
        return;
        if (j != 1536) {
          i = localMessageForPic.mDownloadLength;
        }
        localTransferRequest.jdField_h_of_type_Int = i;
        break;
        if (l >= paramPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic.size) {
          break label457;
        }
        localTransferRequest.jdField_g_of_type_Int = localMessageForPic.mDownloadLength;
        localTransferRequest.jdField_h_of_type_Int = 0;
        localStringBuilder.append("part1:");
      }
      paramPicReq = new DownCallBack.DownResult();
      paramPicReq.jdField_a_of_type_Int = 0;
      paramPicReq.jdField_b_of_type_JavaLangString = localTransferRequest.jdField_g_of_type_JavaLangString;
      paramPicReq.jdField_c_of_type_JavaLangString = localTransferRequest.jdField_e_of_type_JavaLangString;
      paramPicReq.jdField_c_of_type_Int = localTransferRequest.jdField_b_of_type_Int;
      paramPicReq.jdField_d_of_type_Int = localPicDownloadInfo.jdField_j_of_type_Int;
      paramPicReq.jdField_a_of_type_Boolean = false;
      a(paramPicReq);
    } while (!QLog.isDevelopLevel());
    QLog.d("peak_pgjpeg", 4, "BasePicOperator.downloadBigPic():complete download second pass" + str);
  }
  
  private void d(PicReq paramPicReq)
  {
    ThreadManager.b(new jlo(this, paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo));
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public TransferResult a(PicDownloadInfo paramPicDownloadInfo, URLDrawableHandler paramURLDrawableHandler, String paramString)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPicSync", "start " + Thread.currentThread().getId());
    if (a(paramPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + paramPicDownloadInfo.jdField_a_of_type_Long);
      TransFileController localTransFileController = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
      paramPicDownloadInfo.jdField_e_of_type_JavaLangString = paramString;
      paramPicDownloadInfo = a(paramPicDownloadInfo, paramString);
      paramPicDownloadInfo.jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      if ((paramPicDownloadInfo.jdField_a_of_type_JavaLangObject != null) && ((paramPicDownloadInfo.jdField_a_of_type_JavaLangObject instanceof TransferRequest.PicDownExtraInfo))) {
        ((TransferRequest.PicDownExtraInfo)paramPicDownloadInfo.jdField_a_of_type_JavaLangObject).jdField_a_of_type_ComTencentImageURLDrawableHandler = paramURLDrawableHandler;
      }
      return localTransFileController.a(paramPicDownloadInfo);
    }
    paramURLDrawableHandler = new DownCallBack.DownResult();
    paramURLDrawableHandler.jdField_a_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(paramURLDrawableHandler);
    paramURLDrawableHandler = new TransferResult();
    paramURLDrawableHandler.jdField_d_of_type_Int = -1;
    paramURLDrawableHandler.jdField_a_of_type_Long = 9302L;
    if (paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo != null)
    {
      paramURLDrawableHandler.jdField_a_of_type_JavaLangString = ("downloadPicSync," + paramPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo.jdField_b_of_type_JavaLangString);
      return paramURLDrawableHandler;
    }
    paramURLDrawableHandler.jdField_a_of_type_JavaLangString = "downloadPicSync param check error";
    return paramURLDrawableHandler;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  public void a(int paramInt, PicInfoInterface.ErrInfo paramErrInfo)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = paramErrInfo;
    localPicResult.jdField_d_of_type_Int = -1;
    a(paramInt, -1, localPicResult);
    if (paramErrInfo != null)
    {
      Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_a_of_type_JavaLangString, paramErrInfo.jdField_b_of_type_JavaLangString);
      return;
    }
    Logger.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, PicResult paramPicResult)
  {
    PicResult localPicResult = paramPicResult;
    if (paramPicResult == null) {
      localPicResult = new PicResult();
    }
    localPicResult.jdField_d_of_type_Int = 0;
    localPicResult.jdField_a_of_type_ComTencentMobileqqPicPicReq = this.jdField_a_of_type_ComTencentMobileqqPicPicReq;
    a(paramInt, 0, localPicResult);
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    PicResult localPicResult = new PicResult();
    localPicResult.jdField_d_of_type_Int = 0;
    localPicResult.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    localPicResult.b = paramBoolean;
    a(1, 0, localPicResult);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    CompressOperator.a(paramCompressInfo);
    if (paramCompressInfo.jdField_a_of_type_Boolean)
    {
      a(2, null);
      return;
    }
    a(2, null);
  }
  
  public void a(DownCallBack.DownResult paramDownResult)
  {
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_ComTencentMobileqqPicPicReq != null)
    {
      if ((paramDownResult != null) && (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic != null) && (paramDownResult.jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
        if (GifDrawable.isGifFile(new File(paramDownResult.jdField_b_of_type_JavaLangString)))
        {
          ((MessageForPic)localObject1).imageType = 3;
          ((MessageForPic)localObject1).serial();
          if (((MessageForPic)localObject1).subMsgId != MessageForPic.defaultSuMsgId) {
            break label281;
          }
          localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq);
          if (!(localObject2 instanceof MessageForStructing)) {
            break label235;
          }
          localObject2 = (MessageForStructing)localObject2;
          if ((((MessageForStructing)localObject2).structingMsg instanceof StructMsgForImageShare))
          {
            StructMsgItemImage localStructMsgItemImage = ((StructMsgForImageShare)((MessageForStructing)localObject2).structingMsg).getFirstImageElement();
            if (localStructMsgItemImage != null)
            {
              Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of StructMsgForImageShare");
              localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic = ((MessageForPic)localObject1);
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForStructing)localObject2).structingMsg.getBytes());
            }
          }
        }
      }
      ThreadManager.a().post(new jlq(this, paramDownResult));
      if (paramDownResult != null) {
        break label367;
      }
      paramDownResult = new PicInfoInterface.ErrInfo();
      paramDownResult.jdField_b_of_type_JavaLangString = "result == null";
      paramDownResult.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramDownResult);
    }
    for (;;)
    {
      return;
      label235:
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForPic");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, ((MessageForPic)localObject1).msgData);
      break;
      label281:
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq);
      if (!(localObject2 instanceof MessageForMixedMsg)) {
        break;
      }
      localObject2 = ((MessageForMixedMsg)localObject2).upateMessageForPic((MessageForPic)localObject1);
      if (localObject2 == null) {
        break;
      }
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "Update GIF flag of MessageForMixedMsg");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(((MessageForPic)localObject1).frienduin, ((MessageForPic)localObject1).istroop, ((MessageForPic)localObject1).uniseq, (byte[])localObject2);
      break;
      label367:
      Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramDownResult.jdField_a_of_type_Int);
      localObject1 = new PicResult();
      ((PicResult)localObject1).jdField_d_of_type_Int = paramDownResult.jdField_a_of_type_Int;
      ((PicResult)localObject1).jdField_a_of_type_JavaLangObject = paramDownResult;
      ((PicResult)localObject1).jdField_a_of_type_Boolean = paramDownResult.jdField_a_of_type_Boolean;
      if (paramDownResult.jdField_a_of_type_Int == 0) {
        a(0, (PicResult)localObject1);
      }
      while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.n == 3)
      {
        if (paramDownResult.jdField_a_of_type_Int != 0) {
          break label570;
        }
        this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString = paramDownResult.jdField_b_of_type_JavaLangString;
        a(this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo);
        return;
        if (paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo == null)
        {
          localObject1 = new PicInfoInterface.ErrInfo();
          ((PicInfoInterface.ErrInfo)localObject1).jdField_b_of_type_JavaLangString = (paramDownResult.jdField_b_of_type_Int + "_" + paramDownResult.jdField_a_of_type_JavaLangString);
          ((PicInfoInterface.ErrInfo)localObject1).jdField_a_of_type_JavaLangString = "onDownload";
          a(0, (PicInfoInterface.ErrInfo)localObject1);
        }
        else
        {
          a(0, paramDownResult.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
        }
      }
    }
    label570:
    a(4, this.jdField_a_of_type_ComTencentMobileqqPicPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(PicReq paramPicReq)
  {
    PicFowardInfo localPicFowardInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicFowardInfo;
    if (!a(localPicFowardInfo))
    {
      a(4, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
      return;
    }
    if (FileUtils.b(localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString))
    {
      localPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
      a(localPicFowardInfo);
      return;
    }
    if (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.b())
    {
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_g_of_type_JavaLangString = localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.a().toString();
      localPicFowardInfo.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
      a(localPicFowardInfo);
      return;
    }
    localPicFowardInfo.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a(localPicFowardInfo);
    if ((localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_f_of_type_JavaLangString == null) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.jdField_c_of_type_Long == 0L) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.k == 0) || (localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicUploadInfo.l == 0))
    {
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_a_of_type_Int = 3;
      localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo.jdField_e_of_type_JavaLangString = "chatimg";
      paramPicReq = PicBusiManager.a(6, 3);
      paramPicReq.a((MessageForPic)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, localPicFowardInfo.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo);
      b(paramPicReq);
      return;
    }
    d(paramPicReq);
  }
  
  public void a(PicUploadInfo paramPicUploadInfo)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendPic.start", "");
    if (a(paramPicUploadInfo))
    {
      b(paramPicUploadInfo);
      return;
    }
    a(3, paramPicUploadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo);
  }
  
  public void a(UiCallBack paramUiCallBack)
  {
    this.jdField_a_of_type_ComTencentMobileqqPicUiCallBack = paramUiCallBack;
  }
  
  public void a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(5, -1, null);
      return;
    }
    ((PicFowardInfo)paramArrayList.get(0)).jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = a((PicFowardInfo)paramArrayList.get(0));
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("MultiMsg", 2, "[uploadForwardMultiMsgPics] start");
    }
    new jlk(this, paramArrayList, l).execute(new Void[0]);
  }
  
  public void b(PicReq paramPicReq)
  {
    Logger.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadPic", "start " + Thread.currentThread().getId());
    PicDownloadInfo localPicDownloadInfo = paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicDownloadInfo;
    if (a(localPicDownloadInfo))
    {
      this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + "|" + localPicDownloadInfo.jdField_a_of_type_Long);
      if (localPicDownloadInfo.jdField_e_of_type_JavaLangString != "chatimg")
      {
        paramPicReq = a(localPicDownloadInfo, localPicDownloadInfo.jdField_e_of_type_JavaLangString);
        if (!new File(paramPicReq.jdField_g_of_type_JavaLangString).exists())
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramPicReq);
          return;
        }
        DownCallBack.DownResult localDownResult = new DownCallBack.DownResult();
        localDownResult.jdField_a_of_type_Int = 0;
        localDownResult.jdField_b_of_type_JavaLangString = paramPicReq.jdField_g_of_type_JavaLangString;
        localDownResult.jdField_c_of_type_JavaLangString = paramPicReq.jdField_e_of_type_JavaLangString;
        localDownResult.jdField_c_of_type_Int = paramPicReq.jdField_b_of_type_Int;
        localDownResult.jdField_d_of_type_Int = localPicDownloadInfo.jdField_j_of_type_Int;
        a(localDownResult);
        return;
      }
      c(paramPicReq);
      return;
    }
    paramPicReq = new DownCallBack.DownResult();
    paramPicReq.jdField_a_of_type_Int = -1;
    paramPicReq.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo = localPicDownloadInfo.jdField_a_of_type_ComTencentMobileqqPicPicInfoInterface$ErrInfo;
    a(paramPicReq);
  }
  
  public void b(UpCallBack.SendResult paramSendResult)
  {
    if (paramSendResult == null) {
      a(3, null);
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq == null);
      if ((this.jdField_a_of_type_ComTencentMobileqqPicPicReq.n == 2) || (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.n == 4))
      {
        if (paramSendResult.jdField_a_of_type_Int == 0)
        {
          a(paramSendResult);
          localObject = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
          if (localObject != null) {
            ((PicStatisticsManager)localObject).a(13057, paramSendResult.jdField_a_of_type_Long);
          }
          localObject = new PicResult();
          ((PicResult)localObject).jdField_d_of_type_Int = 0;
          ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
          a(3, (PicResult)localObject);
          return;
        }
        localObject = new PicInfoInterface.ErrInfo();
        ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
        a(3, (PicInfoInterface.ErrInfo)localObject);
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqPicPicReq.n != 3);
    if (paramSendResult.jdField_a_of_type_Int == 0)
    {
      a(paramSendResult);
      localObject = (PicStatisticsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(69);
      if (localObject != null) {
        ((PicStatisticsManager)localObject).a(13058, paramSendResult.jdField_a_of_type_Long);
      }
      localObject = new PicResult();
      ((PicResult)localObject).jdField_d_of_type_Int = 0;
      ((PicResult)localObject).jdField_a_of_type_JavaLangObject = paramSendResult;
      a(4, (PicResult)localObject);
      return;
    }
    Object localObject = new PicInfoInterface.ErrInfo();
    ((PicInfoInterface.ErrInfo)localObject).jdField_b_of_type_JavaLangString = paramSendResult.jdField_a_of_type_JavaLangString;
    ((PicInfoInterface.ErrInfo)localObject).jdField_a_of_type_JavaLangString = String.valueOf(paramSendResult.jdField_b_of_type_Int);
    a(4, (PicInfoInterface.ErrInfo)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.BasePicOprerator
 * JD-Core Version:    0.7.0.1
 */