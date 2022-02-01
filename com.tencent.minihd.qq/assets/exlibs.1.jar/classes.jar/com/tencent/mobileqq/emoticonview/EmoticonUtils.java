package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.RecentEmotionData;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.magicface.model.MagicPromotionInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.pb.emosm.EmosmPb.SubCmd0x5RspBQRecommend;
import com.tencent.qphone.base.util.QLog;
import igk;
import igl;
import igm;
import ign;
import igo;
import igp;
import igq;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmoticonUtils
{
  private static final String a = "EmoticonUtils";
  
  public static Bundle a(AppInterface paramAppInterface)
  {
    paramAppInterface = a(paramAppInterface);
    if (paramAppInterface == null) {
      return null;
    }
    try
    {
      paramAppInterface = new JSONObject(paramAppInterface).getJSONObject("addbutton");
      if (Integer.parseInt(paramAppInterface.getString("hide")) == 1) {}
      for (boolean bool = false;; bool = true)
      {
        paramAppInterface = paramAppInterface.getString("url");
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("plusbutton", bool);
        localBundle.putString("url", paramAppInterface);
        return localBundle;
      }
      return null;
    }
    catch (JSONException paramAppInterface)
    {
      paramAppInterface.printStackTrace();
    }
  }
  
  public static PicEmoticonInfo a(MarkFaceMessage paramMarkFaceMessage, QQAppInterface paramQQAppInterface)
  {
    if ((paramMarkFaceMessage == null) || (paramQQAppInterface == null)) {}
    String str1;
    do
    {
      return null;
      str1 = EmosmUtils.bytes2eId(paramMarkFaceMessage.sbufID, paramMarkFaceMessage.mediaType);
    } while (str1 == null);
    String str2 = String.valueOf(paramMarkFaceMessage.dwTabID);
    int i = paramMarkFaceMessage.imageWidth;
    int j = paramMarkFaceMessage.imageHeight;
    Emoticon localEmoticon = ((EmoticonManager)paramQQAppInterface.getManager(13)).a(str2, str1);
    if (localEmoticon != null)
    {
      paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
      paramQQAppInterface.c = 6;
      paramQQAppInterface.a = localEmoticon;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      if (localEmoticon.width == 0) {
        localEmoticon.width = i;
      }
      if (localEmoticon.height == 0) {
        localEmoticon.height = j;
      }
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.height = j;
      paramQQAppInterface.j = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
    }
    paramQQAppInterface = new PicEmoticonInfo(paramQQAppInterface.a());
    paramQQAppInterface.c = 6;
    localEmoticon = new Emoticon();
    if (paramMarkFaceMessage.mediaType == 1) {
      localEmoticon.isSound = true;
    }
    for (;;)
    {
      if ((paramMarkFaceMessage.mobileparam != null) && (paramMarkFaceMessage.mobileparam.length > 0))
      {
        localEmoticon.jobType = 2;
        localEmoticon.magicValue = new String(paramMarkFaceMessage.mobileparam);
      }
      localEmoticon.epId = str2;
      localEmoticon.eId = str1;
      localEmoticon.encryptKey = new String(paramMarkFaceMessage.sbfKey);
      localEmoticon.width = i;
      localEmoticon.height = j;
      localEmoticon.name = paramMarkFaceMessage.faceName;
      paramQQAppInterface.a = localEmoticon;
      paramQQAppInterface.j = paramMarkFaceMessage.cSubType;
      return paramQQAppInterface;
      if (paramMarkFaceMessage.mediaType == 2) {
        localEmoticon.jobType = 1;
      }
    }
  }
  
  public static MagicPromotionInfo a(AppInterface paramAppInterface)
  {
    Object localObject2 = null;
    Object localObject1 = new File(paramAppInterface.getApplication().getFilesDir() + "/magic_promotion_" + paramAppInterface.a() + ".json");
    paramAppInterface = localObject2;
    if (((File)localObject1).exists()) {
      paramAppInterface = FileUtils.a((File)localObject1);
    }
    try
    {
      localObject1 = new String(paramAppInterface, "UTF-8");
      paramAppInterface = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramAppInterface = a((String)localObject1);
      }
      return paramAppInterface;
    }
    catch (UnsupportedEncodingException paramAppInterface)
    {
      for (;;)
      {
        paramAppInterface.printStackTrace();
        localObject1 = null;
      }
    }
  }
  
  public static MagicPromotionInfo a(String paramString)
  {
    Object localObject2 = null;
    try
    {
      Object localObject1 = new JSONObject(paramString).getJSONObject("data").getJSONArray("emojiAioConfig");
      if (localObject1 != null)
      {
        if (((JSONArray)localObject1).length() == 0) {
          return null;
        }
        paramString = new MagicPromotionInfo();
      }
      label157:
      return null;
    }
    catch (JSONException localJSONException1)
    {
      try
      {
        localObject1 = (JSONObject)((JSONArray)localObject1).get(0);
        if (((JSONObject)localObject1).has("hide")) {
          paramString.jdField_a_of_type_Int = ((JSONObject)localObject1).getInt("hide");
        }
        if (((JSONObject)localObject1).has("version")) {
          paramString.jdField_b_of_type_Int = ((JSONObject)localObject1).getInt("version");
        }
        if (((JSONObject)localObject1).has("url")) {
          paramString.c = ((JSONObject)localObject1).getString("url");
        }
        if (((JSONObject)localObject1).has("gifUrl")) {
          paramString.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).getString("gifUrl");
        }
        if (((JSONObject)localObject1).has("imgUrl")) {
          paramString.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).getString("imgUrl");
        }
        return paramString;
      }
      catch (JSONException localJSONException2)
      {
        break label157;
      }
      localJSONException1 = localJSONException1;
      paramString = localObject2;
      localJSONException1.printStackTrace();
      return paramString;
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    paramAppInterface = new File(paramAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramAppInterface.a() + ".json");
    if (paramAppInterface.exists())
    {
      paramAppInterface = FileUtils.a(paramAppInterface);
      try
      {
        paramAppInterface = new String(paramAppInterface, "UTF-8");
        return paramAppInterface;
      }
      catch (UnsupportedEncodingException paramAppInterface)
      {
        return null;
      }
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat");
    byte[] arrayOfByte;
    if (paramQQAppInterface.exists())
    {
      arrayOfByte = FileUtils.a(paramQQAppInterface);
      paramQQAppInterface = new EmosmPb.SubCmd0x5RspBQRecommend();
    }
    try
    {
      paramQQAppInterface.mergeFrom(arrayOfByte);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface.str_morebq_img_url.get();
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    localObject = null;
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("rec");
        localArrayList = new ArrayList(paramQQAppInterface.length());
        j = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        int j;
        JSONObject localJSONObject;
        int i;
        paramQQAppInterface.printStackTrace();
        return localObject;
      }
      try
      {
        if (j >= paramQQAppInterface.length()) {
          continue;
        }
        localObject = new EmoticonPackage();
        localJSONObject = paramQQAppInterface.getJSONObject(j);
        if ((!localJSONObject.has("packageId")) || (!localJSONObject.has("name")) || (!localJSONObject.has("label")) || (!localJSONObject.has("idlist"))) {
          continue;
        }
        ((EmoticonPackage)localObject).epId = localJSONObject.getString("packageId");
        ((EmoticonPackage)localObject).name = localJSONObject.getString("name");
        ((EmoticonPackage)localObject).upperLeftLable = Integer.parseInt(localJSONObject.getString("label"));
        ((EmoticonPackage)localObject).firstEmotionId = localJSONObject.getString("idlist").split(",")[0];
        ((EmoticonPackage)localObject).type = 1;
        k = 0;
        i = 0;
      }
      catch (Exception paramQQAppInterface)
      {
        localObject = localArrayList;
        continue;
        k += 1;
        continue;
      }
      if (k < localArrayList.size())
      {
        if (!((EmoticonPackage)localArrayList.get(k)).epId.equals(((EmoticonPackage)localObject).epId)) {
          break label266;
        }
        i = 1;
        break label266;
      }
      if (i == 0) {
        localArrayList.add(localObject);
      }
      j += 1;
    }
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return new ArrayList();
    }
    ArrayList localArrayList = new ArrayList();
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    List localList = localEntityManager.a(RecentEmotionData.class, false, null, null, null, null, null, null);
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    if (localList != null)
    {
      int i;
      int j;
      label96:
      RecentEmotionData localRecentEmotionData;
      Object localObject;
      if (localList.size() > 8)
      {
        i = localList.size() - 8;
        j = localList.size() - 1;
        if (j < i) {
          break label341;
        }
        localRecentEmotionData = (RecentEmotionData)localList.get(j);
        if (localRecentEmotionData.type != 4) {
          break label170;
        }
        localObject = new EmojiEmoticonInfo();
        ((EmojiEmoticonInfo)localObject).c = 2;
        ((EmojiEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
        localArrayList.add(localObject);
      }
      for (;;)
      {
        j -= 1;
        break label96;
        i = 0;
        break;
        label170:
        if (localRecentEmotionData.type == 0)
        {
          localObject = new SystemEmoticonInfo();
          ((SystemEmoticonInfo)localObject).c = 1;
          ((SystemEmoticonInfo)localObject).jdField_a_of_type_Int = localRecentEmotionData.emoIndex;
          localArrayList.add(localObject);
        }
        else if ((localRecentEmotionData.type == 5) && (d(paramInt)))
        {
          localObject = new PicEmoticonInfo(paramQQAppInterface.a());
          ((PicEmoticonInfo)localObject).c = 6;
          String str = localRecentEmotionData.emoPath;
          ((PicEmoticonInfo)localObject).a = localEmoticonManager.a(String.valueOf(localRecentEmotionData.emoIndex), str);
          localArrayList.add(localObject);
        }
        else if (localRecentEmotionData.type == 3)
        {
          localObject = new FavoriteEmoticonInfo();
          ((FavoriteEmoticonInfo)localObject).c = 5;
          ((FavoriteEmoticonInfo)localObject).i = localRecentEmotionData.emoPath;
          localArrayList.add(localObject);
        }
      }
    }
    label341:
    localEntityManager.a();
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList(3);
    localArrayList.add(new RecentAndFavPanelViewBinder(paramQQAppInterface, paramContext, paramInt, paramEmoticonCallback, 0));
    return localArrayList;
  }
  
  public static List a(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new ClassicEmoticonPanelViewBinder(paramContext, paramEmoticonCallback, 9, true));
    List localList = ((EmoticonManager)paramQQAppInterface.getManager(13)).b();
    if (ClubContentJsonTask.a(paramQQAppInterface).size() > 0) {
      localArrayList.add(new RecommendEmoticonViewBinder(paramQQAppInterface, paramContext, 0));
    }
    localArrayList.add(new MagicFaceViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0));
    Object localObject;
    EmoticonPackage localEmoticonPackage1;
    if (localList != null)
    {
      localObject = localList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        if ((!"100000".equals(localEmoticonPackage1.epId)) && (localEmoticonPackage1.type != 1) && (3 != localEmoticonPackage1.jobType) && (1 != localEmoticonPackage1.jobType)) {
          localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        }
      }
      localObject = a(paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0).getString("emosm_recommend_tab_json", ""));
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    label269:
    label378:
    label379:
    for (;;)
    {
      int i;
      if (((Iterator)localObject).hasNext())
      {
        localEmoticonPackage1 = (EmoticonPackage)((Iterator)localObject).next();
        Iterator localIterator = localList.iterator();
        i = 0;
        if (localIterator.hasNext())
        {
          EmoticonPackage localEmoticonPackage2 = (EmoticonPackage)localIterator.next();
          if (!localEmoticonPackage1.epId.equalsIgnoreCase(localEmoticonPackage2.epId)) {
            break label378;
          }
          localEmoticonPackage2.isRecommendation = true;
          i = 1;
        }
      }
      for (;;)
      {
        break label269;
        if (i != 0) {
          break label379;
        }
        localEmoticonPackage1.isRecommendation = true;
        localEmoticonPackage1.valid = true;
        localArrayList.add(new BigEmoticonViewBinder(paramQQAppInterface, paramContext, paramEmoticonCallback, 0, localEmoticonPackage1));
        break;
        localArrayList.add(new ActionTabViewBinder(101));
        return localArrayList;
      }
    }
  }
  
  /* Error */
  public static List a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_0
    //   6: ifnull +115 -> 121
    //   9: new 299	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 348	java/util/ArrayList:<init>	()V
    //   16: astore_3
    //   17: new 234	org/json/JSONArray
    //   20: dup
    //   21: aload_0
    //   22: invokespecial 475	org/json/JSONArray:<init>	(Ljava/lang/String;)V
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 238	org/json/JSONArray:length	()I
    //   30: istore_2
    //   31: iconst_0
    //   32: istore_1
    //   33: iload_1
    //   34: iload_2
    //   35: if_icmpge +86 -> 121
    //   38: new 304	com/tencent/mobileqq/data/EmoticonPackage
    //   41: dup
    //   42: invokespecial 305	com/tencent/mobileqq/data/EmoticonPackage:<init>	()V
    //   45: astore 4
    //   47: aload_0
    //   48: iload_1
    //   49: invokevirtual 245	org/json/JSONArray:get	(I)Ljava/lang/Object;
    //   52: checkcast 21	org/json/JSONObject
    //   55: astore 5
    //   57: aload 5
    //   59: ldc_w 311
    //   62: invokevirtual 249	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   65: ifeq +16 -> 81
    //   68: aload 4
    //   70: aload 5
    //   72: ldc_w 311
    //   75: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 317	com/tencent/mobileqq/data/EmoticonPackage:name	Ljava/lang/String;
    //   81: aload 5
    //   83: ldc_w 310
    //   86: invokevirtual 249	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   89: ifeq +16 -> 105
    //   92: aload 4
    //   94: aload 5
    //   96: ldc_w 310
    //   99: invokevirtual 36	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: putfield 316	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   105: aload_3
    //   106: aload 4
    //   108: invokeinterface 345 2 0
    //   113: pop
    //   114: iload_1
    //   115: iconst_1
    //   116: iadd
    //   117: istore_1
    //   118: goto -85 -> 33
    //   121: aload_3
    //   122: areturn
    //   123: astore_3
    //   124: aload 4
    //   126: astore_0
    //   127: aload_3
    //   128: invokevirtual 346	java/lang/Exception:printStackTrace	()V
    //   131: aload_0
    //   132: areturn
    //   133: astore 4
    //   135: aload_3
    //   136: astore_0
    //   137: aload 4
    //   139: astore_3
    //   140: goto -13 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	paramString	String
    //   32	86	1	i	int
    //   30	6	2	j	int
    //   4	118	3	localArrayList	ArrayList
    //   123	13	3	localException1	Exception
    //   139	1	3	localException2	Exception
    //   1	124	4	localEmoticonPackage	EmoticonPackage
    //   133	5	4	localException3	Exception
    //   55	40	5	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	17	123	java/lang/Exception
    //   17	31	133	java/lang/Exception
    //   38	81	133	java/lang/Exception
    //   81	105	133	java/lang/Exception
    //   105	114	133	java/lang/Exception
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    if (((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramPicEmoticonInfo.a.epId).mobileFeetype == 1)
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, 0, null, paramQQProgressDialog, paramSessionInfo);
      return;
    }
    if ((!NetworkUtil.f(paramContext)) || (paramInt > 1000))
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, -404, "网络异常，请稍后再试", paramQQProgressDialog, paramSessionInfo);
      return;
    }
    EmosmHandler localEmosmHandler = (EmosmHandler)paramQQAppInterface.a(11);
    localEmosmHandler.a(new igk(localEmosmHandler, paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, paramQQProgressDialog, paramSessionInfo));
    localEmosmHandler.a(paramInt, Integer.valueOf(paramPicEmoticonInfo.a.epId).intValue(), paramPicEmoticonInfo.a.eId);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_magic_emotion_" + paramQQAppInterface.a() + ".json", paramArrayOfByte, false);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x1) == 1;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str = RecentEmotionData.class.getSimpleName();
    paramString = "delete from " + str + " where emoIndex = " + paramString;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonUtils", 2, paramString);
    }
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    boolean bool = paramQQAppInterface.b(paramString);
    paramQQAppInterface.a();
    return bool;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return false;
    }
    return FileUtils.a(paramQQAppInterface.getApplication().getFilesDir() + "/recommend_emoticon_" + paramQQAppInterface.a() + ".dat", paramArrayOfByte, false);
  }
  
  public static boolean a(EmoticonPackage paramEmoticonPackage)
  {
    return (paramEmoticonPackage != null) && (paramEmoticonPackage.status == 2) && ((paramEmoticonPackage.updateFlag & 0x1) == 1);
  }
  
  public static List b(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    EmoticonManager localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    localEmoticonManager = (EmoticonManager)paramQQAppInterface.getManager(13);
    Object localObject1 = localEmoticonManager.b();
    Object localObject2 = new ArrayList();
    Object localObject3;
    if (localObject1 != null)
    {
      int i = 0;
      if (i < ((List)localObject1).size())
      {
        localObject3 = (EmoticonPackage)((List)localObject1).get(i);
        if ((3 != ((EmoticonPackage)localObject3).jobType) || ("100000".equals(((EmoticonPackage)localObject3).epId))) {}
        for (;;)
        {
          i += 1;
          break;
          ((List)localObject2).add(localObject3);
        }
      }
    }
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (EmoticonPackage)((Iterator)localObject1).next();
      localObject3 = localEmoticonManager.a(((EmoticonPackage)localObject2).epId);
      if (localObject3 != null)
      {
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Emoticon localEmoticon = (Emoticon)((Iterator)localObject3).next();
          localEmoticon.jobType = 2;
          localEmoticon.name = ((EmoticonPackage)localObject2).name;
          localEmoticon.value = ((EmoticonPackage)localObject2).valid;
          PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(paramQQAppInterface.a());
          localPicEmoticonInfo.c = 9;
          localPicEmoticonInfo.a = localEmoticon;
          localArrayList.add(localPicEmoticonInfo);
        }
      }
    }
    return localArrayList;
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131365736, 2131366429, new igp(paramContext, paramQQAppInterface, paramEmoticon, paramInt), new igq()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private static void b(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, int paramInt2, String paramString, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    Handler localHandler = new Handler(Looper.getMainLooper());
    paramQQProgressDialog.dismiss();
    if (paramInt2 == 0)
    {
      if (7 == paramInt1 % 1000) {}
      do
      {
        do
        {
          try
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putInt("forward_type", 9);
            paramPicEmoticonInfo = new Intent(paramContext, ForwardRecentActivity.class);
            paramPicEmoticonInfo.putExtras(paramQQAppInterface);
            ((BaseActivity)paramContext).startActivityForResult(paramPicEmoticonInfo, 21);
            return;
          }
          catch (Exception paramContext)
          {
            while (!QLog.isColorLevel()) {}
            QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
            return;
          }
          if (6 != paramInt1 % 1000) {
            break;
          }
          paramString = paramQQAppInterface.a().createEntityManager();
          paramQQProgressDialog = paramString.a(CustomEmotionData.class, false, null, null, null, null, null, null);
          if (paramQQProgressDialog != null)
          {
            paramInt1 = 1;
            paramInt2 = 0;
            for (;;)
            {
              i = paramInt1;
              if (paramInt2 >= paramQQProgressDialog.size()) {
                break;
              }
              paramSessionInfo = (CustomEmotionData)paramQQProgressDialog.get(paramInt2);
              if ((paramSessionInfo.isMarkFace) && (paramSessionInfo.emoPath.equals(paramPicEmoticonInfo.a.epId)) && (paramSessionInfo.eId.equals(paramPicEmoticonInfo.a.eId)))
              {
                localHandler.post(new igl(paramContext));
                return;
              }
              i = paramInt1;
              if (paramInt1 < paramSessionInfo.emoId) {
                i = paramSessionInfo.emoId;
              }
              paramInt2 += 1;
              paramInt1 = i;
            }
          }
          int i = 1;
          paramQQProgressDialog = new CustomEmotionData();
          paramQQProgressDialog.uin = paramQQAppInterface.a();
          paramQQProgressDialog.emoId = (i + 1);
          paramQQProgressDialog.isMarkFace = true;
          paramQQProgressDialog.emoPath = paramPicEmoticonInfo.a.epId;
          paramQQProgressDialog.eId = paramPicEmoticonInfo.a.eId;
          paramString.a(paramQQProgressDialog);
          paramString.a();
          ChatActivityFacade.a(paramQQAppInterface, paramPicEmoticonInfo.a);
          a(paramQQAppInterface, MarketFaceItemBuilder.a.frienduin, "ep_mall", "Clk_collect_suc", 0);
          localHandler.post(new igm(paramContext));
          if (paramImageView != null) {
            paramImageView.setEnabled(false);
          }
          paramContext = paramQQAppInterface.a(ChatActivity.class);
        } while (paramContext == null);
        paramContext.obtainMessage(10).sendToTarget();
        return;
      } while (107 != paramInt1 % 1000);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramPicEmoticonInfo.a.epId, "", "");
      paramPicEmoticonInfo.a(paramQQAppInterface, paramContext, null, paramSessionInfo);
      return;
    }
    if (paramInt2 < 0)
    {
      localHandler.post(new ign(paramContext, paramString));
      return;
    }
    localHandler.post(new igo(paramInt1, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramString));
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x2) == 2;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = a(paramQQAppInterface.getApplication().getSharedPreferences("mobileQQ", 0).getString("emosm_recommend_tab_json", ""));
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.iterator();
      while (paramQQAppInterface.hasNext()) {
        if (paramString.equals(((EmoticonPackage)paramQQAppInterface.next()).epId)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x4) == 4;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 0) || (paramInt == 1) || (paramInt == 3000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonUtils
 * JD-Core Version:    0.7.0.1
 */