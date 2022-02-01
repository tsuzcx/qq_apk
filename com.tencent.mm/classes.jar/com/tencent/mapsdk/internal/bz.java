package com.tencent.mapsdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.sdk.comps.offlinemap.OfflineCity;
import com.tencent.map.sdk.comps.offlinemap.OfflineItem;
import com.tencent.map.sdk.comps.offlinemap.OfflineItemController;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapComponent;
import com.tencent.map.sdk.comps.offlinemap.OfflineMapSyncedListener;
import com.tencent.map.sdk.comps.offlinemap.OfflineNation;
import com.tencent.map.sdk.comps.offlinemap.OfflineProvince;
import com.tencent.map.sdk.comps.offlinemap.OfflineStatusChangedListener;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.json.JsonComposer;
import com.tencent.map.tools.json.JsonUtils;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetRequest.NetRequestBuilder;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateReq;
import com.tencent.mapsdk.core.components.protocol.jce.conf.FileUpdateRsp;
import com.tencent.mapsdk.core.components.protocol.jce.conf.SCFileUpdateRsp;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class bz
  extends bl
  implements OfflineMapComponent, bx.a
{
  public static final String a = "key_offline_map_opened_cities";
  public static final String b = "key_offline_map_config_version";
  public static final String c = "key_offline_map_config_md5";
  public static final String d = "key_offline_map_config_url";
  public static final String e = "sdk_offline_city_ver.json";
  public static final String f = "offline_city_list.json";
  private static final String g = "key_offline_map_items_state";
  private mb h;
  private boolean i;
  private List<OfflineItem> j;
  private List<OfflineItem> k;
  private Map<String, a> l;
  private File m;
  private File n;
  private String o;
  private ca p;
  private Map<by, bx> q;
  private volatile Callback<List<OfflineItem>> r;
  private OfflineMapSyncedListener s;
  private volatile boolean t;
  private boolean u;
  
  public bz()
  {
    AppMethodBeat.i(222323);
    this.j = new ArrayList();
    this.k = new ArrayList();
    this.l = new HashMap();
    AppMethodBeat.o(222323);
  }
  
  private bx a(OfflineItem paramOfflineItem, OfflineStatusChangedListener paramOfflineStatusChangedListener)
  {
    AppMethodBeat.i(222422);
    bm localbm = c_();
    if ((paramOfflineItem == null) || (this.j == null) || (this.p == null) || (localbm == null))
    {
      kh.d("OM", "无效配置 config:" + this.p + "|item:" + paramOfflineItem);
      AppMethodBeat.o(222422);
      return null;
    }
    Object localObject = this.j.iterator();
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
    } while ((OfflineItem)((Iterator)localObject).next() != paramOfflineItem);
    for (int i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        by localby = this.p.a(paramOfflineItem);
        if (localby != null)
        {
          bx localbx = (bx)this.q.get(localby);
          localObject = localbx;
          if (localbx == null)
          {
            localObject = new bx(localbm, this.o, paramOfflineItem, localby, this.h, paramOfflineStatusChangedListener);
            this.q.put(localby, localObject);
          }
          ((bx)localObject).a = paramOfflineStatusChangedListener;
          ((bx)localObject).b = this;
          kh.c("OM", "获得离线城市[" + paramOfflineItem.getName() + "]的配置成功！");
          AppMethodBeat.o(222422);
          return localObject;
        }
      }
      else
      {
        kh.d("OM", "无效城市：".concat(String.valueOf(paramOfflineItem)));
      }
      AppMethodBeat.o(222422);
      return null;
    }
  }
  
  private void a(String paramString)
  {
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      try
      {
        AppMethodBeat.i(222402);
        if (TextUtils.isEmpty(paramString))
        {
          AppMethodBeat.o(222402);
          return;
        }
        paramString = new JSONTokener(paramString).nextValue();
        if (!(paramString instanceof JSONArray)) {
          break label352;
        }
        paramString = JsonUtils.parseToList((JSONArray)paramString, bw.class, new Object[0]);
        if (paramString.isEmpty()) {
          break label352;
        }
        this.j = new ArrayList();
        this.k = new ArrayList();
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          break label348;
        }
        localObject2 = (bw)paramString.next();
        if (((bw)localObject2).b.startsWith("china"))
        {
          localObject1 = new OfflineNation();
          ((OfflineNation)localObject1).setName(((bw)localObject2).a);
          ((OfflineNation)localObject1).setPinyin(((bw)localObject2).b);
          this.k.add(localObject1);
          this.j.add(localObject1);
          continue;
        }
        if (((bw)localObject2).c == null) {
          break label316;
        }
      }
      finally {}
      if (!((bw)localObject2).c.isEmpty())
      {
        localObject1 = new ArrayList();
        OfflineProvince localOfflineProvince = new OfflineProvince();
        localOfflineProvince.setName(((bw)localObject2).a);
        localOfflineProvince.setPinyin(((bw)localObject2).b);
        localOfflineProvince.setCities((List)localObject1);
        this.k.add(localOfflineProvince);
        localObject2 = ((bw)localObject2).c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          OfflineCity localOfflineCity = ((bw)((Iterator)localObject2).next()).a(localOfflineProvince);
          this.j.add(localOfflineCity);
          ((List)localObject1).add(localOfflineCity);
        }
      }
      else
      {
        label316:
        localObject1 = ((bw)localObject2).a(null);
        this.k.add(localObject1);
        this.j.add(localObject1);
        continue;
        label348:
        g();
        label352:
        AppMethodBeat.o(222402);
      }
    }
  }
  
  private void c(final bm parambm)
  {
    AppMethodBeat.i(222332);
    Object localObject = this.h.b("key_offline_map_opened_cities", "");
    if ((!this.i) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      AppMethodBeat.o(222332);
      return;
    }
    localObject = parambm.d;
    if (localObject != null) {
      ((gq)localObject).o().a();
    }
    if (this.t)
    {
      AppMethodBeat.o(222332);
      return;
    }
    this.t = true;
    jw.a(new jw.g()
    {
      public final Object call()
      {
        AppMethodBeat.i(225971);
        bz.a(bz.this, false);
        if (!bz.f(bz.this)) {
          bz.a(bz.this, parambm);
        }
        for (;;)
        {
          AppMethodBeat.o(225971);
          return null;
          bz.a(bz.this, bz.g(bz.this));
          bz.a(bz.this, bz.h(bz.this));
        }
      }
    }).a(null, new jw.a()
    {
      public final void callback(Object paramAnonymousObject)
      {
        AppMethodBeat.i(225898);
        if (bz.a(bz.this) != null)
        {
          bz.a(bz.this).callback(bz.this.getOfflineItemList());
          bz.b(bz.this);
        }
        bz.c(bz.this);
        if (bz.d(bz.this) != null) {
          bz.d(bz.this).onSynced(bz.e(bz.this));
        }
        AppMethodBeat.o(225898);
      }
    });
    AppMethodBeat.o(222332);
  }
  
  private List<OfflineItem> d()
  {
    AppMethodBeat.i(222353);
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = this.h.b("key_offline_map_opened_cities", "").split(",");
    if ((arrayOfString.length != 0) && (this.j != null))
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        OfflineItem localOfflineItem = (OfflineItem)localIterator.next();
        if (Arrays.binarySearch(arrayOfString, localOfflineItem.getPinyin()) >= 0) {
          localArrayList.add(localOfflineItem);
        }
      }
    }
    AppMethodBeat.o(222353);
    return localArrayList;
  }
  
  private void d(bm parambm)
  {
    AppMethodBeat.i(222344);
    Object localObject1 = new ArrayList();
    Object localObject2 = this.h.b("key_offline_map_opened_cities", "").split(",");
    if ((localObject2.length != 0) && (this.j != null))
    {
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        OfflineItem localOfflineItem = (OfflineItem)localIterator.next();
        if (Arrays.binarySearch((Object[])localObject2, localOfflineItem.getPinyin()) >= 0) {
          ((List)localObject1).add(localOfflineItem);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = a((OfflineItem)((Iterator)localObject1).next(), null);
      if (localObject2 != null) {
        ((bx)localObject2).b(parambm);
      }
    }
    AppMethodBeat.o(222344);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(222376);
    Object localObject1 = c_();
    if (localObject1 == null)
    {
      AppMethodBeat.o(222376);
      return false;
    }
    int i1 = this.h.b("key_offline_map_config_version");
    Object localObject2 = this.h.a("key_offline_map_config_md5");
    kh.c("OM", "检查离线配置更新, 当前v:" + i1 + "|md5:" + (String)localObject2 + "obj:" + this);
    Object localObject3 = (dj)cj.a(dj.class);
    ArrayList localArrayList = new ArrayList();
    localObject2 = new FileUpdateReq("sdk_offline_city_ver.json", i1, (String)localObject2);
    localArrayList.add(localObject2);
    localObject1 = ((cv)((dj)localObject3).h()).checkUpdate(gw.h(), gw.d(), gw.k(), gw.f(), ((bm)localObject1).u().b(), localArrayList, ((bm)localObject1).u().b(), ((bm)localObject1).x(), "", ((bm)localObject1).w(), "");
    kh.c("OM", "离线配置请求更新结束：" + ((ds.a)localObject1).toHumanString());
    if (((ds.a)localObject1).available())
    {
      localObject3 = (FileUpdateRsp)((SCFileUpdateRsp)((ds.a)localObject1).a).vItems.get(0);
      if (this.m.exists()) {
        localObject1 = kq.a(this.m);
      }
    }
    for (;;)
    {
      if ((this.m.exists()) && ((localObject3 == null) || (!"sdk_offline_city_ver.json".equals(((FileUpdateRsp)localObject3).sName)) || (((FileUpdateRsp)localObject3).iVersion == ((FileUpdateReq)localObject2).iVersion) || (TextUtils.isEmpty(((FileUpdateRsp)localObject3).sUpdateUrl)) || (((FileUpdateRsp)localObject3).iFileSize == 0) || (((FileUpdateRsp)localObject3).iFileUpdated == 0) || (TextUtils.isEmpty(((FileUpdateRsp)localObject3).sMd5)) || (((FileUpdateRsp)localObject3).sMd5.equals(localObject1))))
      {
        kh.c("OM", "跳过更新");
        label345:
        if (!this.m.exists()) {
          break label684;
        }
        localObject1 = new JSONTokener(new String(ka.c(this.m)));
      }
      try
      {
        localObject1 = ((JSONTokener)localObject1).nextValue();
        if ((localObject1 instanceof JSONObject))
        {
          this.p = ((ca)JsonUtils.parseToModel((JSONObject)localObject1, ca.class, new Object[0]));
          kh.c("OM", "创建离线配置文件对象数据：" + this.p);
        }
        for (;;)
        {
          if (this.p == null) {
            break label695;
          }
          kh.c("OM", "获得离线配置成功！");
          AppMethodBeat.o(222376);
          return true;
          localObject1 = null;
          break;
          localObject2 = ((FileUpdateRsp)localObject3).sUpdateUrl;
          localObject1 = ((FileUpdateRsp)localObject3).sMd5;
          i1 = ((FileUpdateRsp)localObject3).iVersion;
          if ((((FileUpdateRsp)localObject3).iFileUpdated != 0) || (this.m.exists())) {
            break label707;
          }
          localObject2 = this.h.b("key_offline_map_config_url", "");
          localObject1 = this.h.b("key_offline_map_config_md5", "");
          i1 = this.h.b("key_offline_map_config_version", 0);
          if (TextUtils.isEmpty((CharSequence)localObject2))
          {
            kh.d("OM", "离线配置文件的请求链接为空！");
            AppMethodBeat.o(222376);
            return false;
          }
          if (!NetManager.getInstance().builder().url((String)localObject2).downloadTo(this.m).available()) {
            break label345;
          }
          if (kq.a(this.m).equals(localObject1))
          {
            kh.c("OM", "离线配置文件下载成功");
            this.h.a("key_offline_map_config_version", i1);
            this.h.a("key_offline_map_config_md5", (String)localObject1);
            this.h.a("key_offline_map_config_url", (String)localObject2);
            break label345;
          }
          kh.c("OM", "离线配置文件MD5校验失败");
          ka.b(this.m);
          break label345;
          kh.c("OM", "离线地图配置请求错误：" + ((ds.a)localObject1).toHumanString());
          break label345;
          label684:
          kh.d("OM", "离线配置文件不存在！");
        }
        label695:
        AppMethodBeat.o(222376);
        return false;
      }
      catch (JSONException localJSONException)
      {
        label707:
        for (;;) {}
      }
    }
  }
  
  private boolean f()
  {
    AppMethodBeat.i(222386);
    if (!this.n.exists())
    {
      kh.c("OM", "请求离线城市列表...");
      Object localObject = ((cv)((dj)cj.a(dj.class)).h()).downloadOfflineMapCityList(this.o);
      ((dr.a)localObject).charset = "utf-8";
      if (((dr.a)localObject).available())
      {
        kh.c("OM", "离线城市列表下载成功");
        localObject = new dt.a((NetResponse)localObject);
        if (((dt.a)localObject).available())
        {
          a(((dt.a)localObject).a);
          kh.c("OM", "离线城市列表解析成功");
        }
      }
    }
    while (this.j != null)
    {
      kh.c("OM", "获得离线城市列表成功！");
      AppMethodBeat.o(222386);
      return true;
      a(new String(ka.c(this.n)));
      kh.c("OM", "离线城市列表使用缓存");
    }
    AppMethodBeat.o(222386);
    return false;
  }
  
  private void g()
  {
    AppMethodBeat.i(222411);
    if ((this.p != null) && (this.p.e != null) && (!this.j.isEmpty()))
    {
      kh.c("OM", "添加item的数据状态");
      Set localSet = this.l.keySet();
      Iterator localIterator = this.j.iterator();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label210;
        }
        OfflineItem localOfflineItem = (OfflineItem)localIterator.next();
        Object localObject1 = this.p.e.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (by)((Iterator)localObject1).next();
          if (!localOfflineItem.getPinyin().equals(((by)localObject2).c)) {
            break;
          }
          localOfflineItem.setSize(((by)localObject2).d);
          localObject1 = localSet.iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (!localOfflineItem.getPinyin().equals(localObject2)) {
              break;
            }
            localObject1 = a(localOfflineItem, null);
            if (localObject1 != null) {
              localOfflineItem.setUpgrade(((bx)localObject1).checkInvalidate());
            }
          }
        }
      }
      label210:
      kh.c("OM", "添加item的数据状态完成！！");
    }
    AppMethodBeat.o(222411);
  }
  
  public final void a(Context paramContext)
  {
    AppMethodBeat.i(222503);
    super.a(paramContext);
    paramContext = mf.a(paramContext, null);
    kb.a(paramContext.e);
    this.o = paramContext.e;
    this.m = new File(this.o, "sdk_offline_city_ver.json");
    this.n = new File(this.o, "offline_city_list.json");
    this.q = new HashMap();
    AppMethodBeat.o(222503);
  }
  
  public final void a(OfflineItem paramOfflineItem, int paramInt)
  {
    AppMethodBeat.i(222593);
    if (paramOfflineItem == null)
    {
      AppMethodBeat.o(222593);
      return;
    }
    String str = paramOfflineItem.getPinyin();
    a locala2 = (a)this.l.get(str);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(null);
      this.l.put(str, locala1);
    }
    locala1.a = str;
    locala1.b = paramInt;
    paramOfflineItem.setPercentage(paramInt);
    AppMethodBeat.o(222593);
  }
  
  public final void a(OfflineItem paramOfflineItem, boolean paramBoolean)
  {
    AppMethodBeat.i(222584);
    Object localObject = this.h.b("key_offline_map_opened_cities", "");
    kh.c("OM", "当前开启城市IDS：".concat(String.valueOf(localObject)));
    String[] arrayOfString = ((String)localObject).split(",");
    int i1 = Arrays.binarySearch(arrayOfString, paramOfflineItem.getPinyin());
    if (paramBoolean)
    {
      if (i1 < 0)
      {
        paramOfflineItem = (String)localObject + paramOfflineItem.getPinyin() + ",";
        kh.c("OM", "新增开启城市IDS：".concat(String.valueOf(paramOfflineItem)));
        this.h.a("key_offline_map_opened_cities", paramOfflineItem);
        AppMethodBeat.o(222584);
      }
    }
    else if (i1 >= 0)
    {
      localObject = new StringBuilder();
      int i2 = arrayOfString.length;
      i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (!str.equals(paramOfflineItem.getPinyin())) {
          ((StringBuilder)localObject).append(str).append(",");
        }
        i1 += 1;
      }
      paramOfflineItem = ((StringBuilder)localObject).toString();
      kh.c("OM", "剩余开启城市IDS：".concat(String.valueOf(paramOfflineItem)));
      this.h.a("key_offline_map_opened_cities", paramOfflineItem);
    }
    AppMethodBeat.o(222584);
  }
  
  public final void a(bm parambm)
  {
    AppMethodBeat.i(222511);
    super.a(parambm);
    this.i = parambm.a.isOfflineMapEnable();
    this.h = md.a(b(), parambm.u().c);
    Object localObject = this.h.b("key_offline_map_items_state", "");
    kh.c("OM", "获取持久化状态, json：".concat(String.valueOf(localObject)));
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      try
      {
        localObject = JsonUtils.parseToList(new JSONArray((String)localObject), a.class, new Object[0]).iterator();
        while (((Iterator)localObject).hasNext())
        {
          a locala = (a)((Iterator)localObject).next();
          this.l.put(locala.a, locala);
        }
        c(parambm);
      }
      catch (JSONException localJSONException) {}
    }
    AppMethodBeat.o(222511);
  }
  
  public final void b(OfflineItem paramOfflineItem, boolean paramBoolean)
  {
    AppMethodBeat.i(222604);
    if (paramOfflineItem == null)
    {
      AppMethodBeat.o(222604);
      return;
    }
    String str = paramOfflineItem.getPinyin();
    a locala2 = (a)this.l.get(str);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(null);
      this.l.put(str, locala1);
    }
    locala1.a = str;
    locala1.c = paramBoolean;
    paramOfflineItem.setUpgrade(paramBoolean);
    AppMethodBeat.o(222604);
  }
  
  public final void b(bm parambm)
  {
    AppMethodBeat.i(222521);
    super.b(parambm);
    if (this.t)
    {
      this.r = null;
      this.t = false;
    }
    if (!this.l.isEmpty())
    {
      parambm = JsonUtils.collectionToJson(this.l.values());
      kh.c("OM", "保存持久化状态, json：".concat(String.valueOf(parambm)));
      this.h.a("key_offline_map_items_state", parambm);
    }
    AppMethodBeat.o(222521);
  }
  
  public final void b_()
  {
    AppMethodBeat.i(222530);
    super.b_();
    Iterator localIterator = this.q.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      bx localbx = (bx)localEntry.getValue();
      if (localbx != null)
      {
        localbx.b = null;
        localbx.a = null;
      }
      localEntry.setValue(null);
    }
    this.q.clear();
    this.r = null;
    this.s = null;
    AppMethodBeat.o(222530);
  }
  
  public OfflineItemController getOfflineItemController(OfflineItem paramOfflineItem, OfflineStatusChangedListener paramOfflineStatusChangedListener)
  {
    AppMethodBeat.i(222557);
    if (!this.i)
    {
      AppMethodBeat.o(222557);
      return null;
    }
    paramOfflineItem = a(paramOfflineItem, paramOfflineStatusChangedListener);
    AppMethodBeat.o(222557);
    return paramOfflineItem;
  }
  
  public List<OfflineItem> getOfflineItemList()
  {
    try
    {
      AppMethodBeat.i(222564);
      Iterator localIterator = this.j.iterator();
      while (localIterator.hasNext())
      {
        OfflineItem localOfflineItem = (OfflineItem)localIterator.next();
        a locala = (a)this.l.get(localOfflineItem.getPinyin());
        if (locala != null)
        {
          localOfflineItem.setPercentage(locala.b);
          localOfflineItem.setUpgrade(locala.c);
        }
      }
      localList = this.k;
    }
    finally {}
    List localList;
    AppMethodBeat.o(222564);
    return localList;
  }
  
  public void getOfflineItemList(Callback<List<OfflineItem>> paramCallback)
  {
    AppMethodBeat.i(222574);
    this.r = paramCallback;
    if (!this.t) {
      c(c_());
    }
    AppMethodBeat.o(222574);
  }
  
  public boolean isOfflineMapEnable()
  {
    return this.i;
  }
  
  public void syncLatestData(OfflineMapSyncedListener paramOfflineMapSyncedListener)
  {
    AppMethodBeat.i(222547);
    this.s = paramOfflineMapSyncedListener;
    if (!this.t) {
      c(c_());
    }
    AppMethodBeat.o(222547);
  }
  
  static class a
    extends JsonComposer
  {
    String a;
    int b;
    boolean c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.bz
 * JD-Core Version:    0.7.0.1
 */