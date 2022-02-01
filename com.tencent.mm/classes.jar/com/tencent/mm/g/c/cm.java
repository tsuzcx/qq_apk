package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.azp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cm
  extends IAutoDBItem
{
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fAt;
  private static final int fDe;
  private static final int fEe = "objectType".hashCode();
  private static final int fFA;
  private static final int fFB;
  private static final int fFC;
  private static final int fFD;
  private static final int fFE;
  private static final int fFF;
  private static final int fFG;
  private static final int fFH;
  private static final int fFI;
  private static final int fFJ;
  private static final int fFK;
  private static final int fFL;
  private static final int fFM;
  private static final int fFN;
  private static final int fFO;
  private static final int fFP = "refVideoObjectId".hashCode();
  private static final int fFQ = "refVideoObjectNonceId".hashCode();
  public static String fFh = "FinderIdentityMsg";
  public static String fFi = "WxIdentityMsg";
  private static final int fnf;
  private static final int fni;
  private static final int fqf;
  private static final int fyv;
  private static final int id_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetid = true;
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
  private boolean fAo = true;
  private boolean fCU = true;
  private boolean fEa = true;
  private boolean fFj = true;
  private boolean fFk = true;
  private boolean fFl = true;
  private boolean fFm = true;
  private boolean fFn = true;
  private boolean fFo = true;
  private boolean fFp = true;
  private boolean fFq = true;
  private boolean fFr = true;
  private boolean fFs = true;
  private boolean fFt = true;
  private boolean fFu = true;
  private boolean fFv = true;
  private boolean fFw = true;
  private boolean fFx = true;
  public boolean fFy = true;
  public boolean fFz = true;
  public aym field_aggregatedContacts;
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
  public azp field_notify;
  public long field_objectId;
  public String field_objectNonceId;
  public long field_objectType;
  public String field_refContent;
  public long field_refVideoObjectId;
  public String field_refVideoObjectNonceId;
  public String field_replayNickname;
  public String field_replayUsername;
  public FinderContact field_replyContact;
  public String field_thumbUrl;
  public int field_type;
  public int field_userVersion;
  public String field_username;
  private boolean fnc = true;
  private boolean fng = true;
  private boolean fqb = true;
  private boolean fxJ = true;
  
  static
  {
    fFA = "headUrl".hashCode();
    fqf = "nickname".hashCode();
    type_HASHCODE = "type".hashCode();
    content_HASHCODE = "content".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fyv = "thumbUrl".hashCode();
    id_HASHCODE = "id".hashCode();
    fFB = "objectId".hashCode();
    fFC = "commentId".hashCode();
    fni = "flag".hashCode();
    fFD = "refContent".hashCode();
    fAt = "extFlag".hashCode();
    fFE = "mediaType".hashCode();
    fnf = "description".hashCode();
    fFF = "notify".hashCode();
    fFG = "replayUsername".hashCode();
    fFH = "replayNickname".hashCode();
    fDe = "objectNonceId".hashCode();
    fFI = "userVersion".hashCode();
    username_HASHCODE = "username".hashCode();
    fFJ = "contact".hashCode();
    fFK = "replyContact".hashCode();
    fFL = "aggregatedContacts".hashCode();
    fFM = "followExpireTime".hashCode();
    fFN = "clientMsgId".hashCode();
    fFO = "followId".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[29];
    localMAutoDBInfo.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "headUrl";
    localMAutoDBInfo.colsMap.put("headUrl", "TEXT");
    localStringBuilder.append(" headUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "thumbUrl";
    localMAutoDBInfo.colsMap.put("thumbUrl", "TEXT");
    localStringBuilder.append(" thumbUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "id";
    localMAutoDBInfo.colsMap.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "objectId";
    localMAutoDBInfo.colsMap.put("objectId", "LONG");
    localStringBuilder.append(" objectId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "commentId";
    localMAutoDBInfo.colsMap.put("commentId", "LONG");
    localStringBuilder.append(" commentId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "refContent";
    localMAutoDBInfo.colsMap.put("refContent", "TEXT");
    localStringBuilder.append(" refContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "extFlag";
    localMAutoDBInfo.colsMap.put("extFlag", "INTEGER");
    localStringBuilder.append(" extFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "mediaType";
    localMAutoDBInfo.colsMap.put("mediaType", "INTEGER");
    localStringBuilder.append(" mediaType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "notify";
    localMAutoDBInfo.colsMap.put("notify", "BLOB");
    localStringBuilder.append(" notify BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "replayUsername";
    localMAutoDBInfo.colsMap.put("replayUsername", "TEXT");
    localStringBuilder.append(" replayUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "replayNickname";
    localMAutoDBInfo.colsMap.put("replayNickname", "TEXT");
    localStringBuilder.append(" replayNickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "objectNonceId";
    localMAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "userVersion";
    localMAutoDBInfo.colsMap.put("userVersion", "INTEGER");
    localStringBuilder.append(" userVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "contact";
    localMAutoDBInfo.colsMap.put("contact", "BLOB");
    localStringBuilder.append(" contact BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "replyContact";
    localMAutoDBInfo.colsMap.put("replyContact", "BLOB");
    localStringBuilder.append(" replyContact BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "aggregatedContacts";
    localMAutoDBInfo.colsMap.put("aggregatedContacts", "BLOB");
    localStringBuilder.append(" aggregatedContacts BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "followExpireTime";
    localMAutoDBInfo.colsMap.put("followExpireTime", "LONG");
    localStringBuilder.append(" followExpireTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "clientMsgId";
    localMAutoDBInfo.colsMap.put("clientMsgId", "TEXT");
    localStringBuilder.append(" clientMsgId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "followId";
    localMAutoDBInfo.colsMap.put("followId", "LONG");
    localStringBuilder.append(" followId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "objectType";
    localMAutoDBInfo.colsMap.put("objectType", "LONG");
    localStringBuilder.append(" objectType LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "refVideoObjectId";
    localMAutoDBInfo.colsMap.put("refVideoObjectId", "LONG");
    localStringBuilder.append(" refVideoObjectId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "refVideoObjectNonceId";
    localMAutoDBInfo.colsMap.put("refVideoObjectNonceId", "TEXT");
    localStringBuilder.append(" refVideoObjectNonceId TEXT");
    localMAutoDBInfo.columns[29] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (fFA != k) {
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
      if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (fyv == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (id_HASHCODE == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (fFB == k) {
        this.field_objectId = paramCursor.getLong(i);
      } else if (fFC == k) {
        this.field_commentId = paramCursor.getLong(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fFD == k) {
        this.field_refContent = paramCursor.getString(i);
      } else if (fAt == k) {
        this.field_extFlag = paramCursor.getInt(i);
      } else if (fFE == k) {
        this.field_mediaType = paramCursor.getInt(i);
      } else if (fnf == k) {
        this.field_description = paramCursor.getString(i);
      } else if (fFF == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_notify = ((azp)new azp().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
        }
      } else if (fFG == k) {
        this.field_replayUsername = paramCursor.getString(i);
      } else if (fFH == k) {
        this.field_replayNickname = paramCursor.getString(i);
      } else if (fDe == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (fFI == k) {
        this.field_userVersion = paramCursor.getInt(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fFJ == k) {
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
          Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
        }
      } else if (fFK == k) {
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
          Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
        }
      } else if (fFL == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_aggregatedContacts = ((aym)new aym().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
        }
      } else if (fFM == k) {
        this.field_followExpireTime = paramCursor.getLong(i);
      } else if (fFN == k) {
        this.field_clientMsgId = paramCursor.getString(i);
      } else if (fFO == k) {
        this.field_followId = paramCursor.getLong(i);
      } else if (fEe == k) {
        this.field_objectType = paramCursor.getLong(i);
      } else if (fFP == k) {
        this.field_refVideoObjectId = paramCursor.getLong(i);
      } else if (fFQ == k) {
        this.field_refVideoObjectNonceId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fFj) {
      localContentValues.put("headUrl", this.field_headUrl);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.fxJ) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.__hadSetid) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.fFk) {
      localContentValues.put("objectId", Long.valueOf(this.field_objectId));
    }
    if (this.fFl) {
      localContentValues.put("commentId", Long.valueOf(this.field_commentId));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fFm) {
      localContentValues.put("refContent", this.field_refContent);
    }
    if (this.fAo) {
      localContentValues.put("extFlag", Integer.valueOf(this.field_extFlag));
    }
    if (this.fFn) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.fnc) {
      localContentValues.put("description", this.field_description);
    }
    if ((this.fFo) && (this.field_notify != null)) {}
    try
    {
      localContentValues.put("notify", this.field_notify.toByteArray());
      if (this.fFp) {
        localContentValues.put("replayUsername", this.field_replayUsername);
      }
      if (this.fFq) {
        localContentValues.put("replayNickname", this.field_replayNickname);
      }
      if (this.fCU) {
        localContentValues.put("objectNonceId", this.field_objectNonceId);
      }
      if (this.fFr) {
        localContentValues.put("userVersion", Integer.valueOf(this.field_userVersion));
      }
      if (this.__hadSetusername) {
        localContentValues.put("username", this.field_username);
      }
      if ((!this.fFs) || (this.field_contact == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("contact", this.field_contact.toByteArray());
        if ((!this.fFt) || (this.field_replyContact == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("replyContact", this.field_replyContact.toByteArray());
          if ((!this.fFu) || (this.field_aggregatedContacts == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("aggregatedContacts", this.field_aggregatedContacts.toByteArray());
              if (this.fFv) {
                localContentValues.put("followExpireTime", Long.valueOf(this.field_followExpireTime));
              }
              if (this.fFw) {
                localContentValues.put("clientMsgId", this.field_clientMsgId);
              }
              if (this.fFx) {
                localContentValues.put("followId", Long.valueOf(this.field_followId));
              }
              if (this.fEa) {
                localContentValues.put("objectType", Long.valueOf(this.field_objectType));
              }
              if (this.fFy) {
                localContentValues.put("refVideoObjectId", Long.valueOf(this.field_refVideoObjectId));
              }
              if (this.fFz) {
                localContentValues.put("refVideoObjectNonceId", this.field_refVideoObjectNonceId);
              }
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              Log.e("MicroMsg.SDK.BaseFinderFinderMention", localIOException4.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cm
 * JD-Core Version:    0.7.0.1
 */