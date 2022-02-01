package com.tencent.mobileqq.magicface.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ShakeListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.magicface.magicfaceaction.Action;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionGlobalData.ActionCountdownOver;
import com.tencent.mobileqq.magicface.magicfaceaction.ActionProcess;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfaceActionDecoder;
import com.tencent.mobileqq.magicface.magicfaceaction.MagicfacebackText;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.magicface.model.RecordVolume;
import com.tencent.mobileqq.magicface.view.MagicfaceContainerView.MagicfaceGestureListener;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jee;
import jef;
import jeg;
import jeh;
import mqq.app.AppRuntime;

public class MagicfaceActionManager
  implements ActionGlobalData.ActionCountdownOver, MagicfaceContainerView.MagicfaceGestureListener
{
  static final float jdField_a_of_type_Float = 9.81F;
  public static final int a = 0;
  public static final String a;
  public static final float[] a;
  public static final int[] a;
  public static final int b = 1;
  public static final String b = "sendSound";
  public static final String c = "receiveSound";
  public static final String d = "send.xml";
  public static final String e = "receive.xml";
  public static final String f = "MagicfaceActionManager";
  public long a;
  private ShakeListener jdField_a_of_type_ComTencentMobileqqAppShakeListener = new jeg(this);
  public Emoticon a;
  public Action a;
  public ActionGlobalData a;
  public MagicfaceActionDecoder a;
  public MagicfaceResLoader a;
  private RecordVolume jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume = new RecordVolume(new jeh(this));
  MagicfaceActionManager.MagicfaceActionListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener;
  MagicfaceActionManager.MagicfaceCloseListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener;
  private MagicfaceActionManager.MagicfaceSensorOperation jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation = new jee(this);
  MagicfaceActionManager.MagicfaceTextUpdateListener jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener;
  public MagicfacePlayManager a;
  SoundPoolUtil jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil;
  MagicfaceViewController jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController;
  public List a;
  volatile boolean jdField_a_of_type_Boolean = false;
  long b;
  public volatile boolean b;
  public int c;
  public volatile boolean c;
  int d = 0;
  public int e = 0;
  String g;
  
  static
  {
    jdField_a_of_type_JavaLangString = MagicfaceActionManager.class.getSimpleName();
    jdField_a_of_type_ArrayOfFloat = new float[] { 1.4F, 1.5F, 1.6F, 1.7F, 1.8F, 1.9F, 2.0F, 2.1F, 2.2F, 2.3F };
    jdField_a_of_type_ArrayOfInt = new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };
  }
  
  public MagicfaceActionManager(MagicfaceViewController paramMagicfaceViewController)
  {
    this.jdField_c_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData = null;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicfaceActionManager begins");
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = paramMagicfaceViewController;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfaceActionDecoder = new MagicfaceActionDecoder();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = new SoundPoolUtil();
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func MagicfaceActionManager ends");
    }
  }
  
  public static int a(Emoticon paramEmoticon, int paramInt)
  {
    MagicfaceResLoader localMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(paramEmoticon.epId, paramEmoticon.eId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localMagicfaceResLoader.a("send.xml");
    }
    for (;;)
    {
      return new MagicfaceActionDecoder().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localMagicfaceResLoader.a("receive.xml");
      }
    }
  }
  
  public static ActionGlobalData a(Emoticon paramEmoticon, int paramInt)
  {
    MagicfaceResLoader localMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(paramEmoticon.epId, paramEmoticon.eId));
    paramEmoticon = null;
    if (paramInt == 0) {
      paramEmoticon = localMagicfaceResLoader.a("send.xml");
    }
    for (;;)
    {
      return new MagicfaceActionDecoder().a(paramEmoticon);
      if (paramInt == 1) {
        paramEmoticon = localMagicfaceResLoader.a("receive.xml");
      }
    }
  }
  
  private List a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      Action localAction;
      if (localIterator.hasNext())
      {
        localAction = (Action)localIterator.next();
        if (localAction == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localAction.b)) {
            continue;
          }
          localArrayList.add(localAction);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localAction.b)) {
        localArrayList.add(localAction);
      }
    }
  }
  
  private void a(ActionGlobalData paramActionGlobalData)
  {
    c(paramActionGlobalData);
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.a(paramActionGlobalData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.a(paramActionGlobalData.l);
      if (this.jdField_c_of_type_Int == 1)
      {
        if (paramActionGlobalData.n == null) {
          break label118;
        }
        this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b(paramActionGlobalData.n.replace("%param%", "" + paramActionGlobalData.b));
      }
    }
    for (;;)
    {
      if ((paramActionGlobalData != null) && (paramActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null))
      {
        paramActionGlobalData.a(this);
        paramActionGlobalData.a();
      }
      return;
      label118:
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.b("");
    }
  }
  
  private int[] a(String paramString)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func splitVersion begins, version:" + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    do
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      paramString = paramString.split("\\.");
      if ((paramString != null) && (paramString.length > 1))
      {
        i = j;
        try
        {
          while (i < arrayOfInt.length)
          {
            arrayOfInt[i] = Integer.valueOf(paramString[i]).intValue();
            if (QLog.isColorLevel()) {
              QLog.d("MagicfaceActionManager", 2, "func splitVersion, intVers[" + i + "],=" + arrayOfInt[i]);
            }
            i += 1;
          }
          paramString = arrayOfInt;
        }
        catch (Throwable paramString)
        {
          paramString.printStackTrace();
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("MagicfaceActionManager", 2, "func splitVersion ends");
    return arrayOfInt;
  }
  
  private void b(ActionGlobalData paramActionGlobalData)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func onEndMagicface, 【magic end】");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (paramActionGlobalData != null) {
      d(paramActionGlobalData);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener.b(paramActionGlobalData);
    }
  }
  
  private void c(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.j)) {
      ThreadManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume);
    }
    do
    {
      return;
      if ("gravity".equalsIgnoreCase(paramActionGlobalData.j))
      {
        paramActionGlobalData = (SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor");
        paramActionGlobalData.registerListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener, paramActionGlobalData.getDefaultSensor(1), 0);
        return;
      }
    } while (!"touch".equalsIgnoreCase(paramActionGlobalData.j));
  }
  
  private void d(ActionGlobalData paramActionGlobalData)
  {
    if ("mic".equalsIgnoreCase(paramActionGlobalData.j)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelRecordVolume.a();
    }
    while (!"gravity".equalsIgnoreCase(paramActionGlobalData.j)) {
      return;
    }
    ((SensorManager)BaseApplicationImpl.getContext().getSystemService("sensor")).unregisterListener(this.jdField_a_of_type_ComTencentMobileqqAppShakeListener);
  }
  
  private void f()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController != null) && (this.jdField_c_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController.a();
    }
  }
  
  private void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func initActionData begins.");
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a();
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader = new MagicfaceResLoader(EmosmUtils.getMagicfaceFolderPath(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId));
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceModelMagicfaceResLoader);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func initActionData ends.");
    }
  }
  
  private void h()
  {
    boolean bool2 = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData == null) || ("non-ver".equals(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.i)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("5.9.3");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.i);
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func filterAction, qqver:" + arrayOfInt1 + ",magicVer:" + arrayOfInt2);
    }
    int i;
    boolean bool1;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      label142:
      if (QLog.isColorLevel()) {
        QLog.d("MagicfaceActionManager", 2, "func filterAction, isQQSupport:" + bool1);
      }
      if (!bool1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        this.jdField_a_of_type_JavaUtilList = a(bool1);
        return;
        if (arrayOfInt1[i] < arrayOfInt2[i])
        {
          bool1 = false;
          break label142;
        }
        i += 1;
        break;
      }
      bool1 = true;
    }
  }
  
  private void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, magicValue:" + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue != null)
    {
      String[] arrayOfString = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.magicValue.split("&");
      if ((arrayOfString.length >= 0) && (arrayOfString[0].contains("value")))
      {
        arrayOfString = arrayOfString[0].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b = Integer.parseInt(arrayOfString[1]);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceActionManager", 2, "func parseReceiveValue, value:" + this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b);
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText != null)) {
      return this.d;
    }
    return 0;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.b();
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    if ((this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener != null) && (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.m != null))
    {
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(this.d, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
    }
  }
  
  public void a(Emoticon paramEmoticon, int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "func doAction begins. isStart:" + this.jdField_a_of_type_Boolean + ",isRelease:" + this.jdField_c_of_type_Boolean);
    }
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = paramEmoticon;
    this.jdField_c_of_type_Int = paramInt;
    this.g = paramString;
    new Thread(new jef(this, paramInt)).start();
  }
  
  public void a(MagicfaceActionManager.MagicfaceActionListener paramMagicfaceActionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceActionListener = paramMagicfaceActionListener;
  }
  
  public void a(MagicfaceActionManager.MagicfaceCloseListener paramMagicfaceCloseListener)
  {
    if (paramMagicfaceCloseListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceCloseListener = paramMagicfaceCloseListener;
    }
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
  }
  
  public void a(MagicfaceActionManager.MagicfaceTextUpdateListener paramMagicfaceTextUpdateListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener = paramMagicfaceTextUpdateListener;
  }
  
  public void a(MagicfacePlayManager paramMagicfacePlayManager)
  {
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager = paramMagicfacePlayManager;
  }
  
  public void a(boolean paramBoolean)
  {
    BaseApplicationImpl.a().a().getPreferences().edit().putBoolean("sendSound", paramBoolean).commit();
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.c(paramInt, this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceSensorOperation);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction == null) {}
    do
    {
      do
      {
        ActionProcess localActionProcess;
        do
        {
          return;
          localActionProcess = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionAction.a;
        } while ((localActionProcess == null) || (!"gravity".equalsIgnoreCase(localActionProcess.e)));
        if (!"record".equalsIgnoreCase(localActionProcess.d)) {
          break;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
      this.d = this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.b;
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.m);
      return;
    } while (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener == null);
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfaceActionManager$MagicfaceTextUpdateListener.c(this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionMagicfacebackText.a(1, this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.jdField_a_of_type_Float));
  }
  
  public void b(boolean paramBoolean)
  {
    BaseApplicationImpl.a().a().getPreferences().edit().putBoolean("receiveSound", paramBoolean).commit();
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.a().a().getPreferences().getBoolean("sendSound", false);
  }
  
  public void c()
  {
    a(null);
  }
  
  public void c(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.d = true;
    }
  }
  
  public boolean c()
  {
    return BaseApplicationImpl.a().a().getPreferences().getBoolean("receiveSound", false);
  }
  
  public void d()
  {
    c();
    a(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon, this.jdField_c_of_type_Int, this.g);
  }
  
  public void e()
  {
    this.jdField_c_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData != null) {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceMagicfaceactionActionGlobalData.a(null);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.a(null);
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceMagicfacePlayManager.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqMagicfaceServiceSoundPoolUtil = null;
    }
    if ((this.jdField_c_of_type_Int == 0) && (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long > 0L))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.a().a();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        ReportController.b((QQAppInterface)localAppRuntime, "CliOper", "", "", "MbFasong", "MbZhizuoShichang", 0, 0, String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long), "", "", "");
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceViewMagicfaceViewController = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.MagicfaceActionManager
 * JD-Core Version:    0.7.0.1
 */