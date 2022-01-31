package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac;

public final class aw
{
  public static SharedPreferences HD()
  {
    SharedPreferences localSharedPreferences = ae.getContext().getSharedPreferences("auth_info_key_prefs", 4);
    if (!localSharedPreferences.getBoolean("key_auth_info_prefs_created", false))
    {
      f.nEG.a(148L, 12L, 1L, true);
      Object localObject = new com.tencent.mm.storage.y(ac.dOP + "autoauth.cfg");
      if ((!((com.tencent.mm.storage.y)localObject).unp) && (((com.tencent.mm.storage.y)localObject).get(3) != null))
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", ((Integer)((com.tencent.mm.storage.y)localObject).get(1)).intValue());
        localEditor.putInt("_auth_uin", ((Integer)((com.tencent.mm.storage.y)localObject).get(2)).intValue());
        localEditor.putString("_auth_key", (String)((com.tencent.mm.storage.y)localObject).get(3));
        localEditor.putString("server_id", (String)((com.tencent.mm.storage.y)localObject).get(4));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
        f.nEG.a(148L, 51L, 1L, true);
        return localSharedPreferences;
      }
      localObject = ae.getContext().getSharedPreferences("auto_auth_key_prefs", 4);
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (bk.bl(((SharedPreferences)localObject).getString("_auth_key", ""))) {
        break label504;
      }
      localEditor.putBoolean("key_auth_info_prefs_created", true);
      localEditor.putInt("key_auth_update_version", ((SharedPreferences)localObject).getInt("key_auth_update_version", 0));
      localEditor.putInt("_auth_uin", ((SharedPreferences)localObject).getInt("_auth_uin", 0));
      localEditor.putString("_auth_key", ((SharedPreferences)localObject).getString("_auth_key", ""));
      localEditor.putString("server_id", ae.getContext().getSharedPreferences("server_id_prefs", 4).getString("server_id", ""));
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
    }
    for (;;)
    {
      return localSharedPreferences;
      label504:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", new Object[] { bk.csb() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.aw
 * JD-Core Version:    0.7.0.1
 */