package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.aqm;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ci
  extends c
{
  private static final int eFO;
  private static final int eFV;
  private static final int eGY = "username".hashCode();
  private static final int eJD;
  private static final int eJG;
  private static final int eMy;
  private static final int eQh;
  private static final int eUQ;
  private static final int eWO;
  private static final int eZz;
  private static final int fbA;
  private static final int fbB;
  private static final int fbC;
  private static final int fbD = "contact".hashCode();
  private static final int fbE = "replyContact".hashCode();
  private static final int fbF = "aggregatedContacts".hashCode();
  private static final int fbG = "followExpireTime".hashCode();
  private static final int fbH = "clientMsgId".hashCode();
  private static final int fbI = "followId".hashCode();
  private static final int fbJ = "objectType".hashCode();
  public static String fbc = "FinderIdentityMsg";
  public static String fbd = "WxIdentityMsg";
  private static final int fbu = "headUrl".hashCode();
  private static final int fbv;
  private static final int fbw;
  private static final int fbx;
  private static final int fby;
  private static final int fbz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFr = true;
  private boolean eFy = true;
  private boolean eGV = true;
  private boolean eJA = true;
  private boolean eJE = true;
  private boolean eMu = true;
  private boolean eQd = true;
  private boolean eUe = true;
  private boolean eWJ = true;
  private boolean eZp = true;
  private boolean fbe = true;
  private boolean fbf = true;
  private boolean fbg = true;
  private boolean fbh = true;
  private boolean fbi = true;
  private boolean fbj = true;
  private boolean fbk = true;
  private boolean fbl = true;
  private boolean fbm = true;
  private boolean fbn = true;
  private boolean fbo = true;
  private boolean fbp = true;
  private boolean fbq = true;
  private boolean fbr = true;
  private boolean fbs = true;
  private boolean fbt = true;
  public aps field_aggregatedContacts;
  public String field_clientMsgId;
  public long field_commentId;
  public FinderContact field_contact;
  public String field_content;
  public int field_createTime;
  public String field_description;
  public int field_extFlag;
  public int field_flag;
  public long field_followExpireTime;
  public long field_followId;
  public String field_headUrl;
  public long field_id;
  public int field_mediaType;
  public String field_nickname;
  public aqm field_notify;
  public long field_objectId;
  public String field_objectNonceId;
  public long field_objectType;
  public String field_refContent;
  public String field_replayNickname;
  public String field_replayUsername;
  public FinderContact field_replyContact;
  public String field_thumbUrl;
  public int field_type;
  public int field_userVersion;
  public String field_username;
  
  static
  {
    eMy = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    eFV = "content".hashCode();
    eFO = "createTime".hashCode();
    eUQ = "thumbUrl".hashCode();
    eQh = "id".hashCode();
    fbv = "objectId".hashCode();
    fbw = "commentId".hashCode();
    eJG = "flag".hashCode();
    fbx = "refContent".hashCode();
    eWO = "extFlag".hashCode();
    fby = "mediaType".hashCode();
    eJD = "description".hashCode();
    fbz = "notify".hashCode();
    fbA = "replayUsername".hashCode();
    fbB = "replayNickname".hashCode();
    eZz = "objectNonceId".hashCode();
    fbC = "userVersion".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[27];
    locala.columns = new String[28];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "headUrl";
    locala.IBN.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "nickname";
    locala.IBN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.IBN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IBN.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbUrl";
    locala.IBN.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "id";
    locala.IBN.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "objectId";
    locala.IBN.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "commentId";
    locala.IBN.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.IBN.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "refContent";
    locala.IBN.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.IBN.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "mediaType";
    locala.IBN.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "description";
    locala.IBN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "notify";
    locala.IBN.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "replayUsername";
    locala.IBN.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "replayNickname";
    locala.IBN.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "objectNonceId";
    locala.IBN.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "userVersion";
    locala.IBN.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "contact";
    locala.IBN.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "replyContact";
    locala.IBN.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    locala.columns[22] = "aggregatedContacts";
    locala.IBN.put("aggregatedContacts", "BLOB");
    localStringBuilder.append(" aggregatedContacts BLOB");
    localStringBuilder.append(", ");
    locala.columns[23] = "followExpireTime";
    locala.IBN.put("followExpireTime", "LONG");
    localStringBuilder.append(" followExpireTime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "clientMsgId";
    locala.IBN.put("clientMsgId", "TEXT");
    localStringBuilder.append(" clientMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "followId";
    locala.IBN.put("followId", "LONG");
    localStringBuilder.append(" followId LONG");
    localStringBuilder.append(", ");
    locala.columns[26] = "objectType";
    locala.IBN.put("objectType", "LONG");
    localStringBuilder.append(" objectType LONG");
    locala.columns[27] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fbu != k) {
        break label60;
      }
      this.field_headUrl = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eUQ == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (eQh == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (fbv == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (fbw == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fbx == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (eWO == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (fby == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (eJD == k) {
        this.field_description = paramCursor.getString(i);
      } else if (fbz == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((aqm)new aqm().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
        }
      } else if (fbA == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (fbB == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (eZz == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (fbC == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fbD == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_contact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
        }
      } else if (fbE == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_replyContact = ((FinderContact)new FinderContact().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
        }
      } else if (fbF == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((aps)new aps().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
        }
      } else if (fbG == k) {
        this.field_followExpireTime = paramCursor.getLong(i);
      } else if (fbH == k) {
        this.field_clientMsgId = paramCursor.getString(i);
      } else if (fbI == k) {
        this.field_followId = paramCursor.getLong(i);
      } else if (fbJ == k) {
        this.field_objectType = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbe) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eFr) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eUe) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eQd) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.fbf) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.fbg) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fbh) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.eWJ) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.fbi) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eJA) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.fbj) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.fbk) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.fbl) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.eZp) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.fbm) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.eGV) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.fbn) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.fbo) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.fbp) || (this.field_aggregatedContacts == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
              if (this.fbq) {
                localContentValues.put("followExpireTime", Long.valueOf(this.field_followExpireTime));
              }
              if (this.fbr) {
                localContentValues.put("clientMsgId", this.field_clientMsgId);
              }
              if (this.fbs) {
                localContentValues.put("followId", Long.valueOf(this.field_followId));
              }
              if (this.fbt) {
                localContentValues.put("objectType", Long.valueOf(this.field_objectType));
              }
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ae.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ci
 * JD-Core Version:    0.7.0.1
 */