package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.amo;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cf
  extends c
{
  private static final int eBH;
  private static final int eDF;
  private static final int eGq;
  private static final int eHD;
  private static final int eHE;
  private static final int eHF;
  private static final int eHG;
  private static final int eHH;
  private static final int eHI;
  private static final int eHJ;
  private static final int eHK;
  private static final int eHL;
  private static final int eHM = "contact".hashCode();
  private static final int eHN = "replyContact".hashCode();
  private static final int eHO = "aggregatedContacts".hashCode();
  public static String eHp = "FinderIdentityMsg";
  public static String eHq = "WxIdentityMsg";
  private static final int emY;
  private static final int eng;
  private static final int eok;
  private static final int eqL;
  private static final int eqO;
  private static final int etG;
  private static final int ewX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eAV = true;
  private boolean eDA = true;
  private boolean eGg = true;
  private boolean eHA = true;
  private boolean eHB = true;
  private boolean eHC = true;
  private boolean eHr = true;
  private boolean eHs = true;
  private boolean eHt = true;
  private boolean eHu = true;
  private boolean eHv = true;
  private boolean eHw = true;
  private boolean eHx = true;
  private boolean eHy = true;
  private boolean eHz = true;
  private boolean emB = true;
  private boolean emI = true;
  private boolean eoh = true;
  private boolean eqI = true;
  private boolean eqM = true;
  private boolean etC = true;
  private boolean ewT = true;
  public alz field_aggregatedContacts;
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
  public amo field_notify;
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
    eHD = "headUrl".hashCode();
    etG = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    eng = "content".hashCode();
    emY = "createTime".hashCode();
    eBH = "thumbUrl".hashCode();
    ewX = "id".hashCode();
    eHE = "objectId".hashCode();
    eHF = "commentId".hashCode();
    eqO = "flag".hashCode();
    eHG = "refContent".hashCode();
    eDF = "extFlag".hashCode();
    eHH = "mediaType".hashCode();
    eqL = "description".hashCode();
    eHI = "notify".hashCode();
    eHJ = "replayUsername".hashCode();
    eHK = "replayNickname".hashCode();
    eGq = "objectNonceId".hashCode();
    eHL = "userVersion".hashCode();
    eok = "username".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[23];
    locala.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "headUrl";
    locala.GvH.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "nickname";
    locala.GvH.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "content";
    locala.GvH.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "createTime";
    locala.GvH.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "thumbUrl";
    locala.GvH.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "id";
    locala.GvH.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "objectId";
    locala.GvH.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "commentId";
    locala.GvH.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "flag";
    locala.GvH.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "refContent";
    locala.GvH.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[11] = "extFlag";
    locala.GvH.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "mediaType";
    locala.GvH.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[13] = "description";
    locala.GvH.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "notify";
    locala.GvH.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "replayUsername";
    locala.GvH.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "replayNickname";
    locala.GvH.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "objectNonceId";
    locala.GvH.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "userVersion";
    locala.GvH.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    locala.columns[19] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "contact";
    locala.GvH.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    locala.columns[21] = "replyContact";
    locala.GvH.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    locala.columns[22] = "aggregatedContacts";
    locala.GvH.put("aggregatedContacts", "BLOB");
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
      if (eHD != k) {
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
      if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eBH == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (ewX == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (eHE == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (eHF == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eHG == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (eDF == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (eHH == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (eqL == k) {
        this.field_description = paramCursor.getString(i);
      } else if (eHI == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((amo)new amo().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
        }
      } else if (eHJ == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (eHK == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (eGq == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (eHL == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eHM == k) {
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
          ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
        }
      } else if (eHN == k) {
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
          ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
        }
      } else if (eHO == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((alz)new alz().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eHr) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.emB) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eAV) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.ewT) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.eHs) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.eHt) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eHu) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.eDA) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.eHv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eqI) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.eHw) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.eHx) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.eHy) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.eGg) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.eHz) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.eoh) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.eHA) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.eHB) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.eHC) || (this.field_aggregatedContacts == null)) {}
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
              ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              ac.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */