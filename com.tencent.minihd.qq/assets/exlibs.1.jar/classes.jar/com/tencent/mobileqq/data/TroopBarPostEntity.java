package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopBarPostEntity
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_ADDRESS = "addr";
  protected static final String JSON_KEY_BEST = "best";
  protected static final String JSON_KEY_BID = "bid";
  protected static final String JSON_KEY_BRIEF = "brief";
  protected static final String JSON_KEY_GID = "gid";
  protected static final String JSON_KEY_ICON_LISTS = "icon_list";
  protected static final String JSON_KEY_LAYOUT = "layout";
  protected static final String JSON_KEY_LIKES = "likes";
  protected static final String JSON_KEY_PID = "pid";
  protected static final String JSON_KEY_POST = "post";
  protected static final String JSON_KEY_SUBSCRIBERS = "subscribers";
  protected static final String JSON_KEY_SUBSCRIPT_ADDR = "subscript_addr";
  protected static final String JSON_KEY_TIME = "time";
  protected static final String JSON_KEY_TITLE = "title";
  protected static final String JSON_KEY_TOTAL_COMMENT = "total_comment";
  protected static final String JSON_KEY_TYPE = "type";
  protected static final String JSON_KEY_UIN = "uin";
  protected static final String JSON_KEY_USER = "user";
  protected static final String JSON_KEY_ZAN = "zan";
  public byte[] addrBytes;
  public int best;
  public String bid;
  public String brief;
  public byte[] contentBytes;
  public long gid;
  public byte[] iconListBytes;
  public int layout;
  public int likes;
  public long subscribers;
  public String subscript_addr;
  public String time;
  public String title;
  public long total_comment;
  public String type;
  public long uin;
  public byte[] userBytes;
  public int zan;
  
  public TroopBarPostEntity() {}
  
  public TroopBarPostEntity(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    if (paramJSONObject == null) {
      return;
    }
    try
    {
      this.contentBytes = TroopBarUtils.a(new TroopBarPostContentEntity(paramJSONObject.getJSONObject("post")));
      label30:
      this.uin = paramJSONObject.optLong("uin", -1L);
      this.id = paramJSONObject.optString("pid", "");
      this.type = paramJSONObject.optString("type", "");
      this.title = paramJSONObject.optString("title", "");
      this.time = paramJSONObject.optString("time", "");
      this.total_comment = paramJSONObject.optLong("total_comment", -1L);
      this.zan = paramJSONObject.optInt("zan", -1);
      this.likes = paramJSONObject.optInt("likes", -1);
      this.best = paramJSONObject.optInt("best", -1);
      this.subscribers = paramJSONObject.optLong("subscribers", -1L);
      this.bid = paramJSONObject.optString("bid", "");
      this.layout = paramJSONObject.optInt("layout", -1);
      this.gid = paramJSONObject.optLong("gid", -1L);
      try
      {
        this.userBytes = TroopBarUtils.a(new TroopBarUserEntity(paramJSONObject.getJSONObject("user")));
        label206:
        this.brief = paramJSONObject.optString("brief", "");
        for (;;)
        {
          try
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("icon_list");
            ArrayList localArrayList = new ArrayList();
            int i = 0;
            if (i < localJSONArray.length())
            {
              localArrayList.add(new TroopBarIconFlagEntity(localJSONArray.getJSONObject(i)));
              i += 1;
              continue;
            }
            this.iconListBytes = TroopBarUtils.a(localArrayList);
          }
          catch (JSONException localJSONException2)
          {
            continue;
          }
          try
          {
            this.addrBytes = TroopBarUtils.a(new TroopBarPostEntity.TroopBarPostAddress(this, paramJSONObject.getJSONObject("addr")));
            this.subscript_addr = paramJSONObject.optString("subscript_addr", "");
            return;
          }
          catch (JSONException localJSONException1) {}
        }
      }
      catch (JSONException localJSONException3)
      {
        break label206;
      }
    }
    catch (JSONException localJSONException4)
    {
      break label30;
    }
  }
  
  /* Error */
  public TroopBarPostContentEntity getContentEntity()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 96	com/tencent/mobileqq/data/TroopBarPostEntity:contentBytes	[B
    //   4: ifnull +116 -> 120
    //   7: new 190	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 96	com/tencent/mobileqq/data/TroopBarPostEntity:contentBytes	[B
    //   15: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore 4
    //   20: new 195	java/io/ObjectInputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: instanceof 81
    //   41: ifeq +74 -> 115
    //   44: aload_1
    //   45: checkcast 81	com/tencent/mobileqq/data/TroopBarPostContentEntity
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 206	java/io/ObjectInputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 209	java/lang/ClassNotFoundException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 210	java/io/StreamCorruptedException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -22 -> 85
    //   110: astore 4
    //   112: goto -39 -> 73
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -68 -> 49
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	TroopBarPostEntity
    //   36	47	1	localObject1	java.lang.Object
    //   84	2	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   91	4	1	localIOException1	java.io.IOException
    //   100	1	1	localIOException2	java.io.IOException
    //   104	1	1	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   116	1	1	localObject2	java.lang.Object
    //   50	57	2	localObject3	java.lang.Object
    //   52	47	3	localObject4	java.lang.Object
    //   18	36	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	9	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   110	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   29	34	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   31	49	69	java/lang/ClassNotFoundException
    //   53	58	84	java/io/StreamCorruptedException
    //   62	67	84	java/io/StreamCorruptedException
    //   77	82	84	java/io/StreamCorruptedException
    //   20	31	91	java/io/IOException
    //   31	49	91	java/io/IOException
    //   53	58	100	java/io/IOException
    //   62	67	100	java/io/IOException
    //   77	82	100	java/io/IOException
    //   20	31	104	java/io/StreamCorruptedException
    //   31	49	104	java/io/StreamCorruptedException
    //   53	58	110	java/lang/ClassNotFoundException
    //   62	67	110	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public ArrayList getIconListEntitys()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 171	com/tencent/mobileqq/data/TroopBarPostEntity:iconListBytes	[B
    //   4: ifnull +116 -> 120
    //   7: new 190	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 171	com/tencent/mobileqq/data/TroopBarPostEntity:iconListBytes	[B
    //   15: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore 4
    //   20: new 195	java/io/ObjectInputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: instanceof 152
    //   41: ifeq +74 -> 115
    //   44: aload_1
    //   45: checkcast 152	java/util/ArrayList
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 206	java/io/ObjectInputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 209	java/lang/ClassNotFoundException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 210	java/io/StreamCorruptedException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -22 -> 85
    //   110: astore 4
    //   112: goto -39 -> 73
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -68 -> 49
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	TroopBarPostEntity
    //   36	47	1	localObject1	java.lang.Object
    //   84	2	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   91	4	1	localIOException1	java.io.IOException
    //   100	1	1	localIOException2	java.io.IOException
    //   104	1	1	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   116	1	1	localObject2	java.lang.Object
    //   50	57	2	localObject3	java.lang.Object
    //   52	47	3	localObject4	java.lang.Object
    //   18	36	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	9	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   110	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   29	34	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   31	49	69	java/lang/ClassNotFoundException
    //   53	58	84	java/io/StreamCorruptedException
    //   62	67	84	java/io/StreamCorruptedException
    //   77	82	84	java/io/StreamCorruptedException
    //   20	31	91	java/io/IOException
    //   31	49	91	java/io/IOException
    //   53	58	100	java/io/IOException
    //   62	67	100	java/io/IOException
    //   77	82	100	java/io/IOException
    //   20	31	104	java/io/StreamCorruptedException
    //   31	49	104	java/io/StreamCorruptedException
    //   53	58	110	java/lang/ClassNotFoundException
    //   62	67	110	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public TroopBarPostEntity.TroopBarPostAddress getPostAddress()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 178	com/tencent/mobileqq/data/TroopBarPostEntity:addrBytes	[B
    //   4: ifnull +116 -> 120
    //   7: new 190	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 178	com/tencent/mobileqq/data/TroopBarPostEntity:addrBytes	[B
    //   15: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore 4
    //   20: new 195	java/io/ObjectInputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: instanceof 173
    //   41: ifeq +74 -> 115
    //   44: aload_1
    //   45: checkcast 173	com/tencent/mobileqq/data/TroopBarPostEntity$TroopBarPostAddress
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 206	java/io/ObjectInputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 209	java/lang/ClassNotFoundException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 210	java/io/StreamCorruptedException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -22 -> 85
    //   110: astore 4
    //   112: goto -39 -> 73
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -68 -> 49
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	TroopBarPostEntity
    //   36	47	1	localObject1	java.lang.Object
    //   84	2	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   91	4	1	localIOException1	java.io.IOException
    //   100	1	1	localIOException2	java.io.IOException
    //   104	1	1	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   116	1	1	localObject2	java.lang.Object
    //   50	57	2	localObject3	java.lang.Object
    //   52	47	3	localObject4	java.lang.Object
    //   18	36	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	9	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   110	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   29	34	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   31	49	69	java/lang/ClassNotFoundException
    //   53	58	84	java/io/StreamCorruptedException
    //   62	67	84	java/io/StreamCorruptedException
    //   77	82	84	java/io/StreamCorruptedException
    //   20	31	91	java/io/IOException
    //   31	49	91	java/io/IOException
    //   53	58	100	java/io/IOException
    //   62	67	100	java/io/IOException
    //   77	82	100	java/io/IOException
    //   20	31	104	java/io/StreamCorruptedException
    //   31	49	104	java/io/StreamCorruptedException
    //   53	58	110	java/lang/ClassNotFoundException
    //   62	67	110	java/lang/ClassNotFoundException
  }
  
  /* Error */
  public TroopBarUserEntity getUsers()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 144	com/tencent/mobileqq/data/TroopBarPostEntity:userBytes	[B
    //   4: ifnull +116 -> 120
    //   7: new 190	java/io/ByteArrayInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 144	com/tencent/mobileqq/data/TroopBarPostEntity:userBytes	[B
    //   15: invokespecial 193	java/io/ByteArrayInputStream:<init>	([B)V
    //   18: astore 4
    //   20: new 195	java/io/ObjectInputStream
    //   23: dup
    //   24: aload 4
    //   26: invokespecial 198	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   29: astore 5
    //   31: aload 5
    //   33: invokevirtual 202	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   36: astore_1
    //   37: aload_1
    //   38: instanceof 141
    //   41: ifeq +74 -> 115
    //   44: aload_1
    //   45: checkcast 141	com/tencent/mobileqq/data/TroopBarUserEntity
    //   48: astore_1
    //   49: aload_1
    //   50: astore_2
    //   51: aload_1
    //   52: astore_3
    //   53: aload 4
    //   55: invokevirtual 205	java/io/ByteArrayInputStream:close	()V
    //   58: aload_1
    //   59: astore_2
    //   60: aload_1
    //   61: astore_3
    //   62: aload 5
    //   64: invokevirtual 206	java/io/ObjectInputStream:close	()V
    //   67: aload_1
    //   68: areturn
    //   69: astore 4
    //   71: aconst_null
    //   72: astore_1
    //   73: aload_1
    //   74: astore_2
    //   75: aload_1
    //   76: astore_3
    //   77: aload 4
    //   79: invokevirtual 209	java/lang/ClassNotFoundException:printStackTrace	()V
    //   82: aload_1
    //   83: areturn
    //   84: astore_1
    //   85: aload_1
    //   86: invokevirtual 210	java/io/StreamCorruptedException:printStackTrace	()V
    //   89: aload_2
    //   90: areturn
    //   91: astore_1
    //   92: aconst_null
    //   93: astore_3
    //   94: aload_1
    //   95: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   98: aload_3
    //   99: areturn
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_1
    //   105: aconst_null
    //   106: astore_2
    //   107: goto -22 -> 85
    //   110: astore 4
    //   112: goto -39 -> 73
    //   115: aconst_null
    //   116: astore_1
    //   117: goto -68 -> 49
    //   120: aconst_null
    //   121: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	this	TroopBarPostEntity
    //   36	47	1	localObject1	java.lang.Object
    //   84	2	1	localStreamCorruptedException1	java.io.StreamCorruptedException
    //   91	4	1	localIOException1	java.io.IOException
    //   100	1	1	localIOException2	java.io.IOException
    //   104	1	1	localStreamCorruptedException2	java.io.StreamCorruptedException
    //   116	1	1	localObject2	java.lang.Object
    //   50	57	2	localObject3	java.lang.Object
    //   52	47	3	localObject4	java.lang.Object
    //   18	36	4	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	9	4	localClassNotFoundException1	java.lang.ClassNotFoundException
    //   110	1	4	localClassNotFoundException2	java.lang.ClassNotFoundException
    //   29	34	5	localObjectInputStream	java.io.ObjectInputStream
    // Exception table:
    //   from	to	target	type
    //   31	49	69	java/lang/ClassNotFoundException
    //   53	58	84	java/io/StreamCorruptedException
    //   62	67	84	java/io/StreamCorruptedException
    //   77	82	84	java/io/StreamCorruptedException
    //   20	31	91	java/io/IOException
    //   31	49	91	java/io/IOException
    //   53	58	100	java/io/IOException
    //   62	67	100	java/io/IOException
    //   77	82	100	java/io/IOException
    //   20	31	104	java/io/StreamCorruptedException
    //   31	49	104	java/io/StreamCorruptedException
    //   53	58	110	java/lang/ClassNotFoundException
    //   62	67	110	java/lang/ClassNotFoundException
  }
  
  public void readExternal(ObjectInput paramObjectInput) {}
  
  public void writeExternal(ObjectOutput paramObjectOutput) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPostEntity
 * JD-Core Version:    0.7.0.1
 */