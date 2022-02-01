package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="id")
public class TroopBarPageEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_CONTINUE_SIGN_DAYS = "continue";
  protected static final String JSON_KEY_COVER = "cover";
  protected static final String JSON_KEY_CREATE_TIME = "create_time";
  protected static final String JSON_KEY_ERRNO = "errno";
  protected static final String JSON_KEY_EXSIT = "exsit";
  protected static final String JSON_KEY_FANS = "fans";
  protected static final String JSON_KEY_FLAG = "flag";
  protected static final String JSON_KEY_GROUP_COUNT = "group_count";
  protected static final String JSON_KEY_ICON_LISTS = "icon_list";
  protected static final String JSON_KEY_INTRO = "intro";
  protected static final String JSON_KEY_KEY_WORD = "key_word";
  protected static final String JSON_KEY_LOCATION = "location";
  protected static final String JSON_KEY_NAME = "name";
  protected static final String JSON_KEY_PAGE_LEVEL = "level";
  protected static final String JSON_KEY_PAGE_TYPE_LIST = "typelist";
  protected static final String JSON_KEY_PIC = "pic";
  protected static final String JSON_KEY_PIDS = "pids";
  protected static final String JSON_KEY_POST_CORNER_IMG_PREFIX = "subscript_icon_prefix";
  protected static final String JSON_KEY_RCMD_GROUND_NUM = "rcmdGroupNum";
  protected static final String JSON_KEY_RECOMMEND = "recommend";
  protected static final String JSON_KEY_RECOMMEND_PIDS = "recommend_pids";
  protected static final String JSON_KEY_RED_POINT_FLAG = "red_point_flag";
  protected static final String JSON_KEY_SIGN = "sign";
  protected static final String JSON_KEY_STAR_GROUP = "stargroup";
  protected static final String JSON_KEY_TODAY_PIDS = "today_pids";
  protected static final String JSON_KEY_TROOP_BAR = "bar";
  protected static final String JSON_KEY_USER_LEVEL_BIG_ICON_PREFIX = "big_grade_icon_prefix";
  protected static final String JSON_KEY_USER_LEVEL_SMALL_ICON_PREFIX = "small_grade_icon_prefix";
  private static final String TAG = "TroopBarPageEntity";
  protected static final int TROOP_BAR_EXSIT = 1;
  protected static final int TROOP_BAR_SIGN = 1;
  public static String sPostCornerImgPrefix;
  public static String sUserLevelBigIconPrefix;
  public static String sUserLevelSmallIconPrefix;
  public int continueSignDays;
  public String cover;
  public long create_time;
  @notColumn
  public TroopBarPageEntity.TypeListEntity curType = null;
  public int errno;
  public boolean exsit;
  public int fans;
  public int flag;
  public int group_count;
  public byte[] iconListBytes;
  public String intro;
  public String key_word;
  public String location;
  public String name;
  public String pic;
  public int pids;
  public int publishContent_Max_Word;
  public int publishContent_Min_Word;
  public int publishTitle_Max_Word;
  public int publishTitle_Min_Word;
  public int rcmdGroupNum;
  public byte[] recommendArrayBytes;
  public int recommend_pids;
  public int red_point_flag;
  public boolean sign;
  public int stargroup;
  public String test;
  public int today_pids;
  public byte[] troopBarBytes;
  public byte[] troopbarLevelBytes;
  public byte[] typeListBytes;
  
  /* Error */
  public ArrayList getIconListEntitys()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/tencent/mobileqq/data/TroopBarPageEntity:iconListBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 139	com/tencent/mobileqq/data/TroopBarPageEntity:iconListBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public TroopBarLevelEntity getLevel()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 163	com/tencent/mobileqq/data/TroopBarPageEntity:troopbarLevelBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 165
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 165	com/tencent/mobileqq/data/TroopBarLevelEntity
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public ArrayList getRecommendArray()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 168	com/tencent/mobileqq/data/TroopBarPageEntity:recommendArrayBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public ArrayList getTypeList()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 171	com/tencent/mobileqq/data/TroopBarPageEntity:typeListBytes	[B
    //   4: ifnull +74 -> 78
    //   7: new 141	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 171	com/tencent/mobileqq/data/TroopBarPageEntity:typeListBytes	[B
    //   15: invokespecial 144	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore_2
    //   19: new 146	java/io/ObjectInputStream
    //   22: dup
    //   23: aload_2
    //   24: invokespecial 149	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 153	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   32: astore_1
    //   33: aload_1
    //   34: instanceof 155
    //   37: ifeq +36 -> 73
    //   40: aload_1
    //   41: checkcast 155	java/util/ArrayList
    //   44: astore_1
    //   45: aload_2
    //   46: invokevirtual 158	java/io/ByteArrayInputStream:close	()V
    //   49: aload_3
    //   50: invokevirtual 159	java/io/ObjectInputStream:close	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_1
    //   56: aconst_null
    //   57: areturn
    //   58: astore_2
    //   59: aload_1
    //   60: areturn
    //   61: astore_1
    //   62: aconst_null
    //   63: areturn
    //   64: astore_2
    //   65: aload_1
    //   66: areturn
    //   67: astore_1
    //   68: aconst_null
    //   69: areturn
    //   70: astore_2
    //   71: aload_1
    //   72: areturn
    //   73: aconst_null
    //   74: astore_1
    //   75: goto -30 -> 45
    //   78: aconst_null
    //   79: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	TroopBarPageEntity
    //   32	22	1	localObject1	Object
    //   55	5	1	localIOException1	java.io.IOException
    //   61	5	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   67	5	1	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   74	1	1	localObject2	Object
    //   18	28	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   58	1	2	localIOException2	java.io.IOException
    //   64	1	2	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   70	1	2	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   27	23	3	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   19	28	55	java/io/IOException
    //   28	45	55	java/io/IOException
    //   45	53	58	java/io/IOException
    //   19	28	61	java/io/StreamCorruptedException
    //   28	45	61	java/io/StreamCorruptedException
    //   45	53	64	java/io/StreamCorruptedException
    //   28	45	67	java/lang/ClassNotFoundException
    //   45	53	70	java/lang/ClassNotFoundException
  }
  
  public void readExternal(ObjectInput paramObjectInput) {}
  
  public void refreshData(JSONObject paramJSONObject)
  {
    localObject1 = null;
    boolean bool2 = true;
    if (paramJSONObject == null) {}
    do
    {
      return;
      this.errno = paramJSONObject.optInt("errno", -1);
    } while (this.errno != 0);
    try
    {
      TroopBarPageEntity.TroopBar localTroopBar = new TroopBarPageEntity.TroopBar(paramJSONObject.getJSONObject("bar"));
      this.test = "test";
      this.cover = paramJSONObject.optString("cover", "");
      this.pids = paramJSONObject.optInt("pids", -1);
      this.fans = paramJSONObject.optInt("fans", -1);
      this.today_pids = paramJSONObject.optInt("today_pids", -1);
      this.create_time = paramJSONObject.optLong("create_time", -1L);
      this.pic = paramJSONObject.optString("pic", "");
      this.recommend_pids = paramJSONObject.optInt("recommend_pids", -1);
      this.intro = paramJSONObject.optString("intro", "");
      this.flag = paramJSONObject.optInt("flag", -1);
      this.name = paramJSONObject.optString("name", "");
      this.continueSignDays = paramJSONObject.optInt("continue", -1);
      sPostCornerImgPrefix = paramJSONObject.optString("subscript_icon_prefix", "");
      sUserLevelBigIconPrefix = paramJSONObject.optString("big_grade_icon_prefix", "");
      sUserLevelSmallIconPrefix = paramJSONObject.optString("small_grade_icon_prefix", "");
    }
    catch (JSONException localJSONException3)
    {
      try
      {
        localObject7 = new ArrayList();
      }
      catch (JSONException localJSONException2)
      {
        try
        {
          localObject9 = paramJSONObject.getJSONArray("recommend");
          i = 0;
          for (;;)
          {
            Object localObject4 = localObject7;
            if (i >= ((JSONArray)localObject9).length()) {
              break;
            }
            ((ArrayList)localObject7).add(new TroopBarPageEntity.Recommend(((JSONArray)localObject9).getJSONObject(i)));
            i += 1;
          }
          localJSONException2 = localJSONException2;
          localObject3 = null;
        }
        catch (JSONException localJSONException4)
        {
          for (;;)
          {
            Object localObject7;
            Object localObject9;
            int i;
            Object localObject3;
            Object localObject5;
            boolean bool1;
            Object localObject8;
            ArrayList localArrayList;
            Object localObject6 = localObject8;
          }
        }
        localJSONException3 = localJSONException3;
        localObject5 = null;
      }
    }
    this.location = paramJSONObject.optString("location", "");
    if (paramJSONObject.optInt("exsit", -1) == 1) {
      bool1 = true;
    }
    for (;;)
    {
      this.exsit = bool1;
      this.rcmdGroupNum = paramJSONObject.optInt("rcmdGroupNum", -1);
      this.stargroup = paramJSONObject.optInt("stargroup", -1);
      this.group_count = paramJSONObject.optInt("group_count", -1);
      if (paramJSONObject.optInt("sign", -1) == 1)
      {
        bool1 = bool2;
        this.sign = bool1;
        this.key_word = paramJSONObject.optString("key_word", "");
        this.red_point_flag = paramJSONObject.optInt("red_point_flag", -1);
      }
      try
      {
        localObject7 = new TroopBarLevelEntity(paramJSONObject.getJSONObject("level"));
        try
        {
          localObject9 = new ArrayList();
        }
        catch (JSONException localJSONException6)
        {
          try
          {
            JSONArray localJSONArray;
            label420:
            paramJSONObject = paramJSONObject.getJSONArray("icon_list");
            localArrayList = new ArrayList();
            i = 0;
            while (i < paramJSONObject.length())
            {
              localArrayList.add(new TroopBarIconFlagEntity(paramJSONObject.getJSONObject(i)));
              i += 1;
            }
            this.iconListBytes = TroopBarUtils.a(localArrayList);
          }
          catch (JSONException paramJSONObject)
          {
            break label539;
          }
          if (localObject3 != null)
          {
            this.troopBarBytes = TroopBarUtils.a(localObject3);
            if (localObject1 != null) {
              this.typeListBytes = TroopBarUtils.a(localObject1);
            }
            if (localObject5 == null) {
              break label606;
            }
            this.recommendArrayBytes = TroopBarUtils.a(localObject5);
          }
          for (;;)
          {
            if (localObject8 != null)
            {
              this.troopbarLevelBytes = TroopBarUtils.a(localObject8);
              return;
              this.troopBarBytes = new byte[0];
              break;
              this.recommendArrayBytes = new byte[0];
              continue;
            }
            this.troopbarLevelBytes = new byte[0];
            return;
          }
        }
        try
        {
          localJSONArray = paramJSONObject.getJSONArray("typelist");
          i = 0;
          localObject1 = localObject9;
          if (i >= localJSONArray.length()) {
            break label479;
          }
          ((ArrayList)localObject9).add(new TroopBarPageEntity.TypeListEntity(localJSONArray.getJSONObject(i)));
          i += 1;
          break label420;
          bool1 = false;
        }
        catch (JSONException localJSONException1)
        {
          Object localObject2 = localArrayList;
          break label479;
        }
        bool1 = false;
      }
      catch (JSONException localJSONException5)
      {
        for (;;)
        {
          localObject8 = null;
        }
      }
    }
  }
  
  public void updateBannerDataAfterAction(String paramString, JSONObject paramJSONObject)
  {
    boolean bool = true;
    if ((paramString == null) || (paramJSONObject == null)) {}
    do
    {
      return;
      if (paramString.equals("sign_in"))
      {
        this.sign = true;
        this.troopbarLevelBytes = TroopBarUtils.a(new TroopBarLevelEntity(paramJSONObject));
        return;
      }
    } while (!paramString.equals("follow"));
    this.exsit = true;
    if (paramJSONObject.optInt("sign", -1) == 1) {}
    for (;;)
    {
      this.sign = bool;
      try
      {
        this.troopbarLevelBytes = TroopBarUtils.a(new TroopBarLevelEntity(paramJSONObject.getJSONObject("level")));
        return;
      }
      catch (JSONException paramString) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("TroopBarPageEntity", 2, "updateBannerDataAfterAction-->JSONException");
      return;
      bool = false;
    }
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPageEntity
 * JD-Core Version:    0.7.0.1
 */