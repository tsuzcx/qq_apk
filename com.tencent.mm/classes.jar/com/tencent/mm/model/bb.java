package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ah;

public final class bb
{
  public static SharedPreferences ayR()
  {
    AppMethodBeat.i(132249);
    SharedPreferences localSharedPreferences = ai.getContext().getSharedPreferences("auth_info_key_prefs", g.YK());
    if (!localSharedPreferences.getBoolean("key_auth_info_prefs_created", false))
    {
      e.wTc.idkeyStat(148L, 12L, 1L, true);
      Object localObject = new ad(ah.GDu + "autoauth.cfg");
      if ((!((ad)localObject).GCY) && (((ad)localObject).get(3) != null))
      {
        localEditor = localSharedPreferences.edit();
        localEditor.putBoolean("key_auth_info_prefs_created", true);
        localEditor.putInt("key_auth_update_version", ((Integer)((ad)localObject).get(1)).intValue());
        localEditor.putInt("_auth_uin", ((Integer)((ad)localObject).get(2)).intValue());
        localEditor.putString("_auth_key", (String)((ad)localObject).get(3));
        localEditor.putString("server_id", (String)((ad)localObject).get(4));
        ac.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use autoauthcfg now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
        e.wTc.idkeyStat(148L, 51L, 1L, true);
        AppMethodBeat.o(132249);
        return localSharedPreferences;
      }
      localObject = ai.getContext().getSharedPreferences("auto_auth_key_prefs", g.YK());
      SharedPreferences.Editor localEditor = localSharedPreferences.edit();
      if (bs.isNullOrNil(((SharedPreferences)localObject).getString("_auth_key", ""))) {
        break label525;
      }
      localEditor.putBoolean("key_auth_info_prefs_created", true);
      localEditor.putInt("key_auth_update_version", ((SharedPreferences)localObject).getInt("key_auth_update_version", 0));
      localEditor.putInt("_auth_uin", ((SharedPreferences)localObject).getInt("_auth_uin", 0));
      localEditor.putString("_auth_key", ((SharedPreferences)localObject).getString("_auth_key", ""));
      localEditor.putString("server_id", ai.getContext().getSharedPreferences("server_id_prefs", g.YK()).getString("server_id", ""));
      ac.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! use oldAAKsp now commit[%b] create[%b], ver[%d], uin[%d], aak[%s], sid[%s]", new Object[] { Boolean.valueOf(localEditor.commit()), Boolean.valueOf(localSharedPreferences.getBoolean("key_auth_info_prefs_created", false)), Integer.valueOf(localSharedPreferences.getInt("key_auth_update_version", 0)), Integer.valueOf(localSharedPreferences.getInt("_auth_uin", 0)), localSharedPreferences.getString("_auth_key", ""), localSharedPreferences.getString("server_id", "") });
    }
    for (;;)
    {
      AppMethodBeat.o(132249);
      return localSharedPreferences;
      label525:
      ac.i("MicroMsg.MMReqRespAuthComm", "summerauth auth_info_key_prefs not exit! neither autoauthcfg nor oldAAKsp existed just install! stack[%s]", new Object[] { bs.eWi() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bb
 * JD-Core Version:    0.7.0.1
 */