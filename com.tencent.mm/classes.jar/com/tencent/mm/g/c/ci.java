package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ci
  extends c
{
  private static final int eEf;
  private static final int eEm;
  private static final int eFp = "username".hashCode();
  private static final int eHU;
  private static final int eHX;
  private static final int eKP;
  private static final int eOw;
  private static final int eTf;
  private static final int eVd;
  private static final int eXO;
  private static final int eZG;
  private static final int eZH;
  private static final int eZI;
  private static final int eZJ;
  private static final int eZK;
  private static final int eZL;
  private static final int eZM;
  private static final int eZN;
  private static final int eZO;
  private static final int eZP = "contact".hashCode();
  private static final int eZQ = "replyContact".hashCode();
  private static final int eZR = "aggregatedContacts".hashCode();
  private static final int eZS = "followExpireTime".hashCode();
  private static final int eZT = "clientMsgId".hashCode();
  private static final int eZU = "followId".hashCode();
  public static String eZp = "FinderIdentityMsg";
  public static String eZq = "WxIdentityMsg";
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDI = true;
  private boolean eDP = true;
  private boolean eFm = true;
  private boolean eHR = true;
  private boolean eHV = true;
  private boolean eKL = true;
  private boolean eOs = true;
  private boolean eSt = true;
  private boolean eUY = true;
  private boolean eXE = true;
  private boolean eZA = true;
  private boolean eZB = true;
  private boolean eZC = true;
  private boolean eZD = true;
  private boolean eZE = true;
  private boolean eZF = true;
  private boolean eZr = true;
  private boolean eZs = true;
  private boolean eZt = true;
  private boolean eZu = true;
  private boolean eZv = true;
  private boolean eZw = true;
  private boolean eZx = true;
  private boolean eZy = true;
  private boolean eZz = true;
  public apf field_aggregatedContacts;
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
  public apz field_notify;
  public long field_objectId;
  public String field_objectNonceId;
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
    eZG = "headUrl".hashCode();
    eKP = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    eEm = "content".hashCode();
    eEf = "createTime".hashCode();
    eTf = "thumbUrl".hashCode();
    eOw = "id".hashCode();
    eZH = "objectId".hashCode();
    eZI = "commentId".hashCode();
    eHX = "flag".hashCode();
    eZJ = "refContent".hashCode();
    eVd = "extFlag".hashCode();
    eZK = "mediaType".hashCode();
    eHU = "description".hashCode();
    eZL = "notify".hashCode();
    eZM = "replayUsername".hashCode();
    eZN = "replayNickname".hashCode();
    eXO = "objectNonceId".hashCode();
    eZO = "userVersion".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[26];
    locala.columns = new String[27];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "headUrl";
    locala.IhC.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "nickname";
    locala.IhC.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.IhC.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbUrl";
    locala.IhC.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "id";
    locala.IhC.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "objectId";
    locala.IhC.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "commentId";
    locala.IhC.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.IhC.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "refContent";
    locala.IhC.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.IhC.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "mediaType";
    locala.IhC.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "description";
    locala.IhC.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "notify";
    locala.IhC.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "replayUsername";
    locala.IhC.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "replayNickname";
    locala.IhC.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "objectNonceId";
    locala.IhC.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "userVersion";
    locala.IhC.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "contact";
    locala.IhC.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "replyContact";
    locala.IhC.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    locala.columns[22] = "aggregatedContacts";
    locala.IhC.put("aggregatedContacts", "BLOB");
    localStringBuilder.append(" aggregatedContacts BLOB");
    localStringBuilder.append(", ");
    locala.columns[23] = "followExpireTime";
    locala.IhC.put("followExpireTime", "LONG");
    localStringBuilder.append(" followExpireTime LONG");
    localStringBuilder.append(", ");
    locala.columns[24] = "clientMsgId";
    locala.IhC.put("clientMsgId", "TEXT");
    localStringBuilder.append(" clientMsgId TEXT");
    localStringBuilder.append(", ");
    locala.columns[25] = "followId";
    locala.IhC.put("followId", "LONG");
    localStringBuilder.append(" followId LONG");
    locala.columns[26] = "rowid";
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
      if (eZG != k) {
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
      if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eTf == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (eOw == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (eZH == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (eZI == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eZJ == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (eVd == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eZK == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (eHU == k) {
        this.field_description = paramCursor.getString(i);
      } else if (eZL == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((apz)new apz().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
        }
      } else if (eZM == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (eZN == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (eXO == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (eZO == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eZP == k) {
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
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
        }
      } else if (eZQ == k) {
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
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
        }
      } else if (eZR == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((apf)new apf().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
        }
      } else if (eZS == k) {
        this.field_followExpireTime = paramCursor.getLong(i);
      } else if (eZT == k) {
        this.field_clientMsgId = paramCursor.getString(i);
      } else if (eZU == k) {
        this.field_followId = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eZr) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eDI) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eSt) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eOs) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.eZs) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.eZt) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eZu) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.eUY) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eZv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eHR) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.eZw) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.eZx) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.eZy) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.eXE) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.eZz) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.eFm) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.eZA) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.eZB) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.eZC) || (this.field_aggregatedContacts == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
              if (this.eZD) {
                localContentValues.put("followExpireTime", Long.valueOf(this.field_followExpireTime));
              }
              if (this.eZE) {
                localContentValues.put("clientMsgId", this.field_clientMsgId);
              }
              if (this.eZF) {
                localContentValues.put("followId", Long.valueOf(this.field_followId));
              }
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ci
 * JD-Core Version:    0.7.0.1
 */