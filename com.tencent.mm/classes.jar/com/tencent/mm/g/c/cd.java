package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends c
{
  private static final int eBl;
  private static final int eDW;
  private static final int eES;
  private static final int eET;
  private static final int eEU;
  private static final int eEV;
  private static final int eEW;
  private static final int eEX;
  private static final int eEY;
  private static final int eEZ;
  private static final int eFa;
  private static final int ekU;
  private static final int elb;
  private static final int eme;
  private static final int eoH;
  private static final int eoK;
  private static final int erC;
  private static final int exb;
  private static final int ezn;
  public static String qnP = "FinderIdentityMsg";
  public static String qnQ = "WxIdentityMsg";
  private static final int qoH = "replyContact".hashCode();
  private static final int qoP = "aggregatedContacts".hashCode();
  private static final int qoz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eBg = true;
  private boolean eDM = true;
  private boolean eEJ = true;
  private boolean eEK = true;
  private boolean eEL = true;
  private boolean eEM = true;
  private boolean eEN = true;
  private boolean eEO = true;
  private boolean eEP = true;
  private boolean eEQ = true;
  private boolean eER = true;
  private boolean ekE = true;
  private boolean ekx = true;
  private boolean emb = true;
  private boolean eoE = true;
  private boolean eoI = true;
  private boolean ery = true;
  private boolean ewY = true;
  private boolean eyB = true;
  public dzg field_aggregatedContacts;
  public long field_commentId;
  public FinderContact field_contact;
  public String field_content;
  public int field_createTime;
  public String field_description;
  public int field_extFlag;
  public int field_flag;
  public String field_headUrl;
  public long field_id;
  public int field_mediaType;
  public String field_nickname;
  public akd field_notify;
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
  private boolean qnR = true;
  private boolean qnT = true;
  private boolean qnZ = true;
  
  static
  {
    eES = "headUrl".hashCode();
    erC = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    elb = "content".hashCode();
    ekU = "createTime".hashCode();
    ezn = "thumbUrl".hashCode();
    exb = "id".hashCode();
    eET = "objectId".hashCode();
    eEU = "commentId".hashCode();
    eoK = "flag".hashCode();
    eEV = "refContent".hashCode();
    eBl = "extFlag".hashCode();
    eEW = "mediaType".hashCode();
    eoH = "description".hashCode();
    eEX = "notify".hashCode();
    eEY = "replayUsername".hashCode();
    eEZ = "replayNickname".hashCode();
    eDW = "objectNonceId".hashCode();
    eFa = "userVersion".hashCode();
    eme = "username".hashCode();
    qoz = "contact".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "headUrl";
    locala.EYv.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "nickname";
    locala.EYv.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.EYv.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.EYv.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbUrl";
    locala.EYv.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "id";
    locala.EYv.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "objectId";
    locala.EYv.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "commentId";
    locala.EYv.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.EYv.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "refContent";
    locala.EYv.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.EYv.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "mediaType";
    locala.EYv.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "description";
    locala.EYv.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "notify";
    locala.EYv.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "replayUsername";
    locala.EYv.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "replayNickname";
    locala.EYv.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "objectNonceId";
    locala.EYv.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "userVersion";
    locala.EYv.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "username";
    locala.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "contact";
    locala.EYv.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "replyContact";
    locala.EYv.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    locala.columns[22] = "aggregatedContacts";
    locala.EYv.put("aggregatedContacts", "BLOB");
    localStringBuilder.append(" aggregatedContacts BLOB");
    locala.columns[23] = "rowid";
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
      if (eES != k) {
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
      if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (ezn == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (exb == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (eET == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (eEU == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eEV == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (eBl == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eEW == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (eoH == k) {
        this.field_description = paramCursor.getString(i);
      } else if (eEX == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((akd)new akd().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
        }
      } else if (eEY == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (eEZ == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (eDW == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (eFa == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (qoz == k) {
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
      } else if (qoH == k) {
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
      } else if (qoP == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((dzg)new dzg().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ad.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eEJ) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ekx) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eyB) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.ewY) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.eEK) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.eEL) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eEM) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.eBg) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eEN) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eoE) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.eEO) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.eEP) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.eEQ) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.eDM) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.eER) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.emb) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.qnR) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.qnT) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.qnZ) || (this.field_aggregatedContacts == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cd
 * JD-Core Version:    0.7.0.1
 */