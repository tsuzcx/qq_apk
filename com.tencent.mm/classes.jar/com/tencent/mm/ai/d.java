package com.tencent.mm.ai;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.h.c.ae;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class d
  extends ae
{
  protected static c.a buS;
  public static int eeS = 1;
  public static int eeT = 0;
  public static int eeU = 1;
  private static int eeX = 0;
  private static d.b eeY = null;
  private List<d.a> eeV;
  public d.b eeW;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[20];
    locala.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.ujN.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "username";
    locala.columns[1] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "brandList";
    locala.ujN.put("brandList", "TEXT default '' ");
    localStringBuilder.append(" brandList TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandListVersion";
    locala.ujN.put("brandListVersion", "TEXT");
    localStringBuilder.append(" brandListVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "brandListContent";
    locala.ujN.put("brandListContent", "TEXT");
    localStringBuilder.append(" brandListContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "brandFlag";
    locala.ujN.put("brandFlag", "INTEGER");
    localStringBuilder.append(" brandFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "extInfo";
    locala.ujN.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "brandInfo";
    locala.ujN.put("brandInfo", "TEXT");
    localStringBuilder.append(" brandInfo TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "brandIconURL";
    locala.ujN.put("brandIconURL", "TEXT");
    localStringBuilder.append(" brandIconURL TEXT");
    localStringBuilder.append(", ");
    locala.columns[9] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "hadAlert";
    locala.ujN.put("hadAlert", "INTEGER");
    localStringBuilder.append(" hadAlert INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "acceptType";
    locala.ujN.put("acceptType", "INTEGER default '0' ");
    localStringBuilder.append(" acceptType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[12] = "type";
    locala.ujN.put("type", "INTEGER default '0' ");
    localStringBuilder.append(" type INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[13] = "status";
    locala.ujN.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[14] = "enterpriseFather";
    locala.ujN.put("enterpriseFather", "TEXT");
    localStringBuilder.append(" enterpriseFather TEXT");
    localStringBuilder.append(", ");
    locala.columns[15] = "kfWorkerId";
    locala.ujN.put("kfWorkerId", "TEXT");
    localStringBuilder.append(" kfWorkerId TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "specialType";
    locala.ujN.put("specialType", "INTEGER");
    localStringBuilder.append(" specialType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "attrSyncVersion";
    locala.ujN.put("attrSyncVersion", "TEXT");
    localStringBuilder.append(" attrSyncVersion TEXT");
    localStringBuilder.append(", ");
    locala.columns[18] = "incrementUpdateTime";
    locala.ujN.put("incrementUpdateTime", "LONG");
    localStringBuilder.append(" incrementUpdateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[19] = "bitFlag";
    locala.ujN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    locala.columns[20] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  private boolean il(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  private void im(int paramInt)
  {
    this.field_bitFlag |= paramInt;
  }
  
  public final boolean LA()
  {
    bS(false);
    if ((this.eeW != null) && (this.eeW.Mb() != null))
    {
      if (this.eeW.efl.efM == 1) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (!il(1)))
        {
          im(1);
          z.My().e(this);
        }
        if (bool) {
          y.d("MicroMsg.BizInfo", "EnterpriseChat,userName : %s", new Object[] { this.field_username });
        }
        return bool;
      }
    }
    return false;
  }
  
  public final boolean LB()
  {
    bS(false);
    if ((this.eeW != null) && (this.eeW.Mb() != null))
    {
      if (this.eeW.efl.efM == 2) {}
      for (boolean bool = true;; bool = false)
      {
        if ((bool) && (!il(2)))
        {
          im(2);
          z.My().e(this);
        }
        if (bool) {
          y.d("MicroMsg.BizInfo", "EnterpriseWeb,userName : %s", new Object[] { this.field_username });
        }
        return bool;
      }
    }
    return false;
  }
  
  public final String LC()
  {
    bS(false);
    if (this.eeW != null)
    {
      d.b.c.a locala = this.eeW.Mb();
      if ((locala != null) && (locala.efN != null) && (!locala.efN.isEmpty())) {
        return locala.efN;
      }
    }
    return null;
  }
  
  public final long LD()
  {
    long l2 = 0L;
    bS(false);
    long l1 = l2;
    if (this.eeW != null)
    {
      d.b.c.a locala = this.eeW.Mb();
      l1 = l2;
      if (locala != null)
      {
        l1 = l2;
        if (locala.appid != 0L) {
          l1 = locala.appid;
        }
      }
    }
    return l1;
  }
  
  public final boolean LE()
  {
    bS(false);
    if (this.eeW == null) {
      y.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo() null");
    }
    do
    {
      return true;
      if (this.eeW.LU() == null)
      {
        y.i("MicroMsg.BizInfo", "isShowUserName bizInfo.getExtInfo().getRegisterSource() null");
        return true;
      }
    } while (!this.eeW.LU().egb);
    return false;
  }
  
  public final String LF()
  {
    bS(false);
    if (this.eeW != null)
    {
      d.b.c.a locala = this.eeW.Mb();
      if (locala != null) {
        return locala.efO;
      }
    }
    return null;
  }
  
  public final String LG()
  {
    String str = bS(false).Mb().efK;
    if (bk.bl(str)) {
      y.e("MicroMsg.BizInfo", "check father: %s, %s", new Object[] { this.field_username, str });
    }
    return str;
  }
  
  public final List<d.a> LH()
  {
    if (this.eeV != null) {
      return this.eeV;
    }
    this.eeV = new LinkedList();
    if ((this.field_brandInfo == null) || (this.field_brandInfo.length() == 0)) {
      return this.eeV;
    }
    try
    {
      JSONArray localJSONArray = new JSONObject(this.field_brandInfo).optJSONArray("urls");
      int i = 0;
      while (i < localJSONArray.length())
      {
        d.a locala = new d.a();
        JSONObject localJSONObject = localJSONArray.optJSONObject(i);
        locala.title = localJSONObject.optString("title");
        locala.url = localJSONObject.optString("url");
        locala.eeZ = localJSONObject.optString("title_key");
        locala.description = localJSONObject.optString("description");
        this.eeV.add(locala);
        i += 1;
      }
      return this.eeV;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.BizInfo", "exception:%s", new Object[] { bk.j(localException) });
    }
  }
  
  public final boolean Lq()
  {
    return (this.field_brandFlag & 0x1) == 0;
  }
  
  public final boolean Lr()
  {
    return (this.field_brandFlag & 0x4) != 0;
  }
  
  public final boolean Ls()
  {
    if (System.currentTimeMillis() - this.field_updateTime > 86400000L) {}
    Calendar localCalendar;
    do
    {
      return true;
      localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
    } while (this.field_updateTime < localCalendar.getTimeInMillis());
    return false;
  }
  
  public final void Lt()
  {
    bS(false);
    d.b localb = this.eeW;
    if (localb.efa != null) {
      localb.efo = localb.efa.optInt("ConnectorMsgType");
    }
    this.field_acceptType = localb.efo;
    this.field_type = bS(false).LW();
    if (LA())
    {
      im(1);
      return;
    }
    this.field_bitFlag &= 0xFFFFFFFE;
  }
  
  public final boolean Lu()
  {
    bS(false);
    y.i("MicroMsg.BizInfo", "is report location, user %s %B", new Object[] { this.field_username, Boolean.valueOf(this.eeW.Lu()) });
    return this.eeW.Lu();
  }
  
  public final boolean Lv()
  {
    bS(false);
    return this.field_type == 1;
  }
  
  public final boolean Lw()
  {
    boolean bool = false;
    bS(false);
    if (this.field_type == 0) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean Lx()
  {
    boolean bool = false;
    bS(false);
    if ((this.field_type == 2) || (this.field_type == 3)) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean Ly()
  {
    boolean bool = false;
    bS(false);
    if (this.field_type == 2) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean Lz()
  {
    boolean bool = false;
    bS(false);
    if (this.field_type == 3) {
      bool = true;
    }
    return bool;
  }
  
  public final d.b bS(boolean paramBoolean)
  {
    if ((this.eeW == null) || (paramBoolean))
    {
      if ((bk.bl(this.field_extInfo)) || (eeX != this.field_extInfo.hashCode())) {
        break label46;
      }
      this.eeW = eeY;
    }
    for (;;)
    {
      return this.eeW;
      label46:
      d.b localb = d.b.kI(this.field_extInfo);
      this.eeW = localb;
      eeY = localb;
      eeX = bk.pm(this.field_extInfo).hashCode();
    }
  }
  
  public final void d(Cursor paramCursor)
  {
    super.d(paramCursor);
  }
  
  protected final c.a rM()
  {
    return buS;
  }
  
  public final ContentValues vf()
  {
    return super.vf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ai.d
 * JD-Core Version:    0.7.0.1
 */