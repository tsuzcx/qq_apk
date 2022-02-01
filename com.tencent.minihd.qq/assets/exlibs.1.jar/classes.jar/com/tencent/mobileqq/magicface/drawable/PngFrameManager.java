package com.tencent.mobileqq.magicface.drawable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.Holder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import jdn;
import jdo;
import jdp;
import jdr;
import jdu;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PngFrameManager
  implements IMessageHandler, Manager
{
  private static final int jdField_a_of_type_Int = 224;
  private static final String jdField_a_of_type_JavaLangString = PngFrameManager.class.getSimpleName();
  private static final int jdField_b_of_type_Int = 225;
  private static final int jdField_c_of_type_Int = 226;
  private static final int d = 227;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PngFrameUtil jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil;
  private DownloaderInterface jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private HashMap jdField_b_of_type_JavaUtilHashMap;
  private HashMap jdField_c_of_type_JavaUtilHashMap;
  
  @SuppressLint({"UseSparseArrays"})
  public PngFrameManager(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "PngFrameManager 【Constructor】  ");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = a(this);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil = new PngFrameUtil();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.b = new HashMap();
    this.c = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  public static Handler a(IMessageHandler paramIMessageHandler)
  {
    return new jdu(paramIMessageHandler);
  }
  
  private PngFrameDrawable a(String paramString, int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPngFrameDrawable begins,epId:" + paramString + ",pos:" + paramInt + ",showProcess:" + paramBoolean);
    }
    String str = paramString + "_" + paramInt;
    paramString = a(paramString);
    if (paramString == null)
    {
      localObject = null;
      return localObject;
    }
    Object localObject = (PngFrameDrawable)this.b.get(str);
    if ((localObject == null) || (paramBoolean) || (!((PngFrameDrawable)localObject).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPngFrameDrawable, 【NOT find】  drawable in the map.");
      }
      paramString.jdField_a_of_type_Boolean = paramBoolean;
      paramString = new PngFrameDrawable(paramString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources());
      this.b.put(str, paramString);
      paramString.a(paramInt);
    }
    for (;;)
    {
      localObject = paramString;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPngFrameDrawable ends");
      return paramString;
      paramString = (String)localObject;
      if (QLog.isColorLevel())
      {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func getPngFrameDrawable, drawable exists in map,pos:" + paramInt);
        paramString = (String)localObject;
      }
    }
  }
  
  @SuppressLint({"InlinedApi"})
  private void a(MarketFaceItemBuilder.Holder paramHolder, boolean paramBoolean)
  {
    int j = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
    int i = (j * 200 + 160) / 320;
    j = (200 * j + 160) / 320;
    if (paramBoolean)
    {
      paramHolder.e.setLayoutParams(new FrameLayout.LayoutParams(i, j));
      return;
    }
    paramHolder = (RelativeLayout.LayoutParams)paramHolder.e.getLayoutParams();
    paramHolder.width = i;
    paramHolder.height = j;
  }
  
  private void a(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if ((paramRandomDrawableParam != null) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder != null) && (paramRandomDrawableParam.jdField_a_of_type_Long == paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func onTypeGif, 【rsyType is GIF, use the OLD way to show.】");
      }
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback.a(true);
    }
  }
  
  private void b(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageResource(2130840720);
    new Thread(new jdo(this, paramRandomDrawableParam)).start();
  }
  
  private void c(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func onTypePngZip begins, param:" + paramRandomDrawableParam);
    }
    if (new File(EmosmUtils.getPngFramePath(paramRandomDrawableParam.jdField_a_of_type_JavaLangString)).exists())
    {
      f(paramRandomDrawableParam);
      return;
    }
    int i = NetworkUtil.a(BaseApplication.getContext());
    if ((i != 1) && (i != 3) && (i != 4) && (i != 0))
    {
      d(paramRandomDrawableParam);
      return;
    }
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageResource(2130840720);
    e(paramRandomDrawableParam);
  }
  
  private void d(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    String str = EmosmUtils.getEmoticonAIOPreviewPath(paramRandomDrawableParam.jdField_a_of_type_JavaLangString, paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.eId);
    Bitmap localBitmap = (Bitmap)BaseApplicationImpl.a.get(str);
    if ((localBitmap != null) && (!localBitmap.isRecycled()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func showAIOPreview, 【aio preview】, exist in Cache.");
      }
      paramRandomDrawableParam.jdField_a_of_type_JavaLangObject = localBitmap;
      this.jdField_a_of_type_AndroidOsHandler.obtainMessage(227, paramRandomDrawableParam).sendToTarget();
      return;
    }
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageResource(2130840720);
    new Thread(new jdp(this, str, paramRandomDrawableParam)).start();
  }
  
  private void e(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    new Thread(new jdr(this, paramRandomDrawableParam)).start();
  }
  
  private void f(PngFrameManager.RandomDrawableParam paramRandomDrawableParam)
  {
    Object localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString);
    if ((localObject == null) || (!((PngPlayParam)localObject).a())) {}
    do
    {
      return;
      localObject = a(paramRandomDrawableParam.jdField_a_of_type_JavaLangString, paramRandomDrawableParam.b, paramRandomDrawableParam.jdField_a_of_type_Boolean);
      if ((paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder != null) && (paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long == paramRandomDrawableParam.jdField_a_of_type_Long)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "func showDrawable ends, 【holder not Exists!】");
    return;
    if (localObject != null)
    {
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramRandomDrawableParam.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageDrawable((Drawable)localObject);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.obtainMessage(226, paramRandomDrawableParam).sendToTarget();
  }
  
  public PngPlayParam a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    PngPlayParam localPngPlayParam;
    do
    {
      return localObject;
      localPngPlayParam = (PngPlayParam)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      localObject = localPngPlayParam;
    } while (localPngPlayParam != null);
    return b(paramString);
  }
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
        paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.d = paramMessage.jdField_a_of_type_Int;
        if (paramMessage.jdField_a_of_type_Int == 0)
        {
          a(paramMessage);
          return;
        }
      } while (paramMessage.jdField_a_of_type_Int != 1);
      c(paramMessage);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      f(paramMessage);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageResource(2130840721);
      return;
      paramMessage = (PngFrameManager.RandomDrawableParam)paramMessage.obj;
    } while (paramMessage.jdField_a_of_type_Long != paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_Long);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramMessage.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.e.setImageBitmap((Bitmap)paramMessage.jdField_a_of_type_JavaLangObject);
  }
  
  public void a(String paramString, MarketFaceItemBuilder.Holder paramHolder, long paramLong, boolean paramBoolean1, boolean paramBoolean2, PngFrameManager.IMagicCallback paramIMagicCallback)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHolder == null)) {
      if (paramIMagicCallback != null) {
        paramIMagicCallback.a(true);
      }
    }
    for (;;)
    {
      return;
      a(paramHolder, paramBoolean2);
      paramString = new PngFrameManager.RandomDrawableParam(this);
      paramString.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager$IMagicCallback = paramIMagicCallback;
      paramString.jdField_a_of_type_JavaLangString = paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.epId;
      paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder = paramHolder;
      paramString.jdField_a_of_type_Long = paramLong;
      paramString.jdField_a_of_type_Boolean = paramBoolean1;
      paramString.b = PngFrameUtil.b(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
      if (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar == null) {
        paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(BaseApplicationImpl.getContext());
      }
      if (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView == null) {
        paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetImageView = new ImageView(BaseApplicationImpl.getContext());
      }
      int i = PngFrameUtil.a(paramHolder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a.magicValue);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "func setMagicDrawable, 【rscType】:" + i + ",【randomValue】:" + paramString.b + ",【showProcess】:" + paramBoolean1 + ",tag:" + paramLong);
      }
      paramHolder.d = i;
      switch (i)
      {
      }
      while (paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetFrameLayout != null)
      {
        paramString.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder$Holder.jdField_a_of_type_AndroidWidgetFrameLayout.setOnClickListener(new jdn(this, paramString));
        return;
        a(paramString);
        continue;
        c(paramString);
        continue;
        b(paramString);
      }
    }
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 73	com/tencent/mobileqq/magicface/drawable/PngFrameManager:c	Ljava/util/HashMap;
    //   6: lload_1
    //   7: invokestatic 443	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   10: invokevirtual 126	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: checkcast 445	java/lang/Boolean
    //   16: ifnonnull +29 -> 45
    //   19: aload_0
    //   20: getfield 59	com/tencent/mobileqq/magicface/drawable/PngFrameManager:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   23: new 447	jdt
    //   26: dup
    //   27: aload_0
    //   28: lload_1
    //   29: invokespecial 450	jdt:<init>	(Lcom/tencent/mobileqq/magicface/drawable/PngFrameManager;J)V
    //   32: ldc2_w 451
    //   35: invokevirtual 456	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   38: pop
    //   39: iconst_1
    //   40: istore_3
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: iconst_0
    //   46: istore_3
    //   47: goto -6 -> 41
    //   50: astore 4
    //   52: aload_0
    //   53: monitorexit
    //   54: aload 4
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	PngFrameManager
    //   0	57	1	paramLong	long
    //   40	7	3	bool	boolean
    //   50	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	39	50	finally
  }
  
  public PngPlayParam b(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    PngPlayParam localPngPlayParam;
    do
    {
      return localObject;
      localPngPlayParam = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameUtil.a(paramString);
      localObject = localPngPlayParam;
    } while (localPngPlayParam == null);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localPngPlayParam);
    return localPngPlayParam;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "PngFrameManager 【onDestroy】  ");
    }
    if (this.jdField_a_of_type_JavaUtilHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap = null;
    }
    if (this.b != null)
    {
      Iterator localIterator = this.b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        PngFrameDrawable localPngFrameDrawable = (PngFrameDrawable)((Map.Entry)localIterator.next()).getValue();
        if (localPngFrameDrawable != null) {
          localPngFrameDrawable.a();
        }
      }
      this.b.clear();
      this.b = null;
    }
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.drawable.PngFrameManager
 * JD-Core Version:    0.7.0.1
 */