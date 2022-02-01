package midas.x;

import android.text.TextUtils;
import com.pay.api.request.APBaseRequest;
import com.pay.tool.APTools;
import com.tencent.midas.comm.APLog;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d0
{
  public static volatile d0 h;
  public ArrayList<r> a = null;
  public s b = null;
  public r c = null;
  public boolean d = false;
  public boolean e = false;
  public String f;
  public String g = "";
  
  public static d0 i()
  {
    try
    {
      if (h == null) {
        try
        {
          if (h == null) {
            h = new d0();
          }
        }
        finally {}
      }
      d0 locald0 = h;
      return locald0;
    }
    finally {}
  }
  
  public int a(int paramInt)
  {
    return i(paramInt) + d(paramInt);
  }
  
  public final int a(int paramInt, ArrayList<r> paramArrayList)
  {
    j = -1;
    m = j;
    if (paramArrayList != null)
    {
      int i = 0;
      for (k = -1;; k = m)
      {
        m = j;
        if (i >= paramArrayList.size()) {
          break;
        }
        r localr = (r)paramArrayList.get(i);
        try
        {
          int i1 = localr.a.b.a;
          n = j;
          m = k;
          if (paramInt >= i1)
          {
            n = j;
            m = k;
            if (i1 > k)
            {
              n = i;
              m = i1;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            int n = j;
            m = k;
          }
        }
        i += 1;
        j = n;
      }
    }
    else
    {
      return m;
    }
  }
  
  public final String a()
  {
    return a(a(this.c).c);
  }
  
  public final String a(ArrayList<w> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        localStringBuffer.append(((w)paramArrayList.get(i)).a);
        localStringBuffer.append('×');
        localStringBuffer.append(((w)paramArrayList.get(i)).b);
        localStringBuffer.append(65292);
        i += 1;
      }
      if (localStringBuffer.length() > 0) {
        localStringBuffer.deleteCharAt(localStringBuffer.length() - 1);
      }
    }
    return localStringBuffer.toString();
  }
  
  public ArrayList<w> a(ArrayList<w> paramArrayList1, ArrayList<w> paramArrayList2)
  {
    if ((paramArrayList1 == null) && (paramArrayList2 == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    w localw1;
    if (paramArrayList2 == null)
    {
      paramArrayList1 = paramArrayList1.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (w)paramArrayList1.next();
        localw1 = new w();
        localw1.a = paramArrayList2.a;
        localw1.b = paramArrayList2.b;
        localArrayList.add(localw1);
      }
      return localArrayList;
    }
    if (paramArrayList1 == null)
    {
      paramArrayList1 = paramArrayList2.iterator();
      while (paramArrayList1.hasNext())
      {
        paramArrayList2 = (w)paramArrayList1.next();
        localw1 = new w();
        localw1.a = paramArrayList2.a;
        localw1.b = paramArrayList2.b;
        localArrayList.add(localw1);
      }
      return localArrayList;
    }
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      localw1 = (w)paramArrayList1.next();
      w localw2 = new w();
      localw2.a = localw1.a;
      localw2.b = localw1.b;
      localArrayList.add(localw2);
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      localw1 = (w)paramArrayList1.next();
      paramArrayList2 = new w();
      paramArrayList2.a = localw1.a;
      paramArrayList2.b = localw1.b;
      int k = 0;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= localArrayList.size()) {
          break;
        }
        localw1 = (w)localArrayList.get(i);
        if (localw1.a.equals(paramArrayList2.a))
        {
          localw1.b = String.valueOf(i.b(localw1.b) + i.b(paramArrayList2.b));
          j = 1;
          break;
        }
        i += 1;
      }
      if (j == 0) {
        localArrayList.add(paramArrayList2);
      }
    }
    return localArrayList;
  }
  
  public final e0 a(int paramInt, r paramr)
  {
    e0 locale01 = paramr.a;
    e0 locale02 = paramr.b;
    k = 0;
    i = 0;
    j = 0;
    if ((locale02 != null) && (locale01 == null)) {}
    try
    {
      i = locale02.b.a;
    }
    catch (Exception paramr)
    {
      for (;;)
      {
        i = j;
      }
    }
    if (paramInt == i)
    {
      return locale02;
      if ((locale02 != null) || (locale01 == null)) {}
    }
    try
    {
      i = locale01.b.a;
    }
    catch (Exception paramr)
    {
      for (;;)
      {
        label116:
        label119:
        label122:
        i = k;
      }
    }
    if (paramInt >= i)
    {
      return locale01;
      if ((locale02 == null) || (locale01 == null)) {}
    }
    try
    {
      j = locale01.b.a;
    }
    catch (Exception localException1)
    {
      break label119;
    }
    try
    {
      k = locale02.b.a;
      i = k;
    }
    catch (Exception localException2)
    {
      break label116;
    }
    break label122;
    j = 0;
    if ((paramInt == i) && (paramInt < j)) {
      return locale02;
    }
    if ((paramInt != i) && (paramInt >= j)) {
      return locale01;
    }
    if ((paramInt == i) && (paramInt >= j)) {
      return a(paramr);
    }
    return null;
  }
  
  public final e0 a(r paramr)
  {
    str2 = "";
    if ((paramr.b == null) && (paramr.a == null)) {
      return null;
    }
    Object localObject1 = paramr.b;
    if (localObject1 == null) {
      return paramr.a;
    }
    Object localObject2 = paramr.a;
    if (localObject2 == null) {
      return localObject1;
    }
    try
    {
      if ((((e0)localObject2).b != null) && (!TextUtils.isEmpty(((e0)localObject2).b.e))) {
        localObject1 = paramr.a.b.e;
      }
    }
    catch (Exception localException1)
    {
      label79:
      break label79;
    }
    localObject1 = "";
    localObject2 = str2;
    try
    {
      if (paramr.b.b != null)
      {
        localObject2 = str2;
        if (!TextUtils.isEmpty(paramr.b.b.e)) {
          localObject2 = paramr.b.b.e;
        }
      }
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        String str1 = str2;
      }
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
      return paramr.b;
    }
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
      return paramr.a;
    }
    if ((TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
      return paramr.b;
    }
    return paramr.b;
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
    Object localObject1 = this.a;
    if (localObject1 != null) {
      ((ArrayList)localObject1).clear();
    }
    localObject1 = this.c;
    if (localObject1 != null) {
      ((r)localObject1).a();
    }
    p.o().a();
    localObject1 = this.b;
    if (localObject1 != null) {
      ((s)localObject1).a();
    }
    this.g = "";
    int j = 0;
    this.d = false;
    this.e = false;
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.has("first_mpinfo"))
        {
          this.c = b(paramString.getJSONObject("first_mpinfo"));
          if (a(this.c).b()) {
            this.d = true;
          } else {
            this.d = false;
          }
        }
        Object localObject2;
        Object localObject3;
        if (paramString.has("utp_mpinfo"))
        {
          localObject1 = paramString.getJSONArray("utp_mpinfo");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = b(((JSONArray)localObject1).getJSONObject(i));
            localObject3 = a((r)localObject2);
            if (((e0)localObject3).b()) {
              this.e = true;
            }
            ((e0)localObject3).c();
            this.a.add(localObject2);
            i += 1;
            continue;
          }
        }
        if (paramString.has("utp_mpinfo_detail"))
        {
          localObject1 = paramString.getJSONObject("utp_mpinfo_detail");
          this.b.a((JSONObject)localObject1);
          if ((this.b.b()) || (this.b.c())) {
            this.e = true;
          }
          this.b.c();
        }
        p.o().a();
        if (paramString.has("gold_mpinfo"))
        {
          localObject1 = paramString.getJSONObject("gold_mpinfo");
          Object localObject5;
          String str;
          Object localObject4;
          if ((localObject1 != null) && (((JSONObject)localObject1).has("resinfo")))
          {
            localObject2 = ((JSONObject)localObject1).getJSONArray("resinfo");
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject5 = ((JSONArray)localObject2).getJSONObject(i);
              localObject3 = ((JSONObject)localObject5).getString("type");
              str = ((JSONObject)localObject5).getString("name");
              localObject4 = ((JSONObject)localObject5).getString("title");
              localObject5 = ((JSONObject)localObject5).getString("num");
              if (Integer.parseInt((String)localObject5) <= 0) {
                break label608;
              }
              u localu = new u();
              localu.d((String)localObject3);
              localu.a(str);
              localu.c((String)localObject4);
              localu.b((String)localObject5);
              p.o().a(localu);
              break label608;
            }
          }
          if ((localObject1 != null) && (((JSONObject)localObject1).has("resrule")))
          {
            localObject1 = ((JSONObject)localObject1).getJSONArray("resrule");
            i = j;
            if (i < ((JSONArray)localObject1).length())
            {
              localObject4 = ((JSONArray)localObject1).getJSONObject(i);
              localObject2 = ((JSONObject)localObject4).getString("type");
              localObject3 = ((JSONObject)localObject4).getString("rank");
              str = ((JSONObject)localObject4).getString("derate_type");
              localObject4 = ((JSONObject)localObject4).getString("derate_num");
              localObject5 = new v();
              ((v)localObject5).a((String)localObject2);
              ((v)localObject5).b(Integer.parseInt((String)localObject3));
              ((v)localObject5).c(Integer.parseInt(str));
              ((v)localObject5).a(Integer.parseInt((String)localObject4));
              p.o().a((v)localObject5);
              i += 1;
              continue;
            }
          }
        }
        p.o().m();
        f(paramString);
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      label608:
      i += 1;
    }
  }
  
  public final void a(x paramx, JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        if (paramString.equals(localJSONObject.getString("flag")))
        {
          paramJSONArray = new y();
          paramJSONArray.a(localJSONObject.getString("activitymeta"));
          paramJSONArray.b(localJSONObject.getString("activityname"));
          paramJSONArray.c(localJSONObject.getString("currenttime"));
          paramJSONArray.d(localJSONObject.getString("endtime"));
          paramJSONArray.e(localJSONObject.getString("extend"));
          paramJSONArray.f(localJSONObject.getString("flag"));
          paramJSONArray.g(localJSONObject.getString("goodsmeta"));
          paramJSONArray.h(localJSONObject.getString("goodsname"));
          paramJSONArray.i(localJSONObject.getString("img"));
          paramJSONArray.j(localJSONObject.getString("minparticipants"));
          paramJSONArray.k(b(localJSONObject.getString("originalprice")));
          paramJSONArray.l(localJSONObject.getString("participants"));
          paramJSONArray.m(b(localJSONObject.getString("price")));
          paramJSONArray.n(localJSONObject.getString("productid"));
          paramJSONArray.o(localJSONObject.getString("starttime"));
          paramx.a(paramJSONArray);
          paramx.d("1");
          return;
        }
        i += 1;
      }
      return;
    }
    catch (JSONException paramx)
    {
      paramx.printStackTrace();
    }
  }
  
  public void a(JSONObject paramJSONObject)
    throws JSONException
  {
    this.f = paramJSONObject.toString();
    x localx = x.f();
    localx.a();
    a6.c();
    if (paramJSONObject.has("tuan_mpinfo"))
    {
      paramJSONObject = paramJSONObject.getJSONObject("tuan_mpinfo");
      localx.b(paramJSONObject.getString("mall_url"));
      localx.c(paramJSONObject.getString("result_url"));
      localx.a(paramJSONObject.getString("actset_id"));
      if (paramJSONObject.getJSONArray("list").length() > 0)
      {
        localx.d("1");
        return;
      }
      localx.d("0");
      return;
    }
    localx.d("0");
  }
  
  public final boolean a(JSONArray paramJSONArray, String paramString)
  {
    try
    {
      int j = paramJSONArray.length();
      int i = 0;
      while (i < j)
      {
        boolean bool = paramString.equals(((JSONObject)paramJSONArray.get(i)).getString("flag"));
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (JSONException paramJSONArray)
    {
      paramJSONArray.printStackTrace();
    }
  }
  
  public final String b(String paramString)
  {
    float f1 = Float.valueOf(APTools.j(paramString)).floatValue() / 100.0F;
    paramString = new DecimalFormat();
    paramString.applyPattern("0.00");
    return paramString.format(f1);
  }
  
  public ArrayList<w> b(int paramInt)
  {
    ArrayList localArrayList = a(j(paramInt), e(paramInt));
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      return localArrayList;
    }
    return null;
  }
  
  public final e0 b(int paramInt, ArrayList<r> paramArrayList)
  {
    int i;
    Object localObject;
    if (paramArrayList != null)
    {
      i = 0;
      if (i < paramArrayList.size()) {
        localObject = (r)paramArrayList.get(i);
      }
    }
    for (;;)
    {
      try
      {
        if ((((r)localObject).a == null) || (((r)localObject).a.b == null)) {
          break label206;
        }
        j = ((r)localObject).a.b.a;
        if ((((r)localObject).b == null) || (((r)localObject).b.b == null)) {
          break label212;
        }
        k = ((r)localObject).b.b.a;
        if ((paramInt == j) && (paramInt != k)) {
          return ((r)localObject).a;
        }
        if ((paramInt != j) && (paramInt == k)) {
          return ((r)localObject).b;
        }
        if ((paramInt == j) && (paramInt == k))
        {
          localObject = a((r)localObject);
          return localObject;
        }
      }
      catch (Exception localException)
      {
        APLog.w("getLevelType", localException.toString());
        i += 1;
      }
      break;
      paramInt = a(paramInt, paramArrayList);
      if ((paramInt >= 0) && (paramInt < paramArrayList.size())) {
        return ((r)paramArrayList.get(paramInt)).a;
      }
      return null;
      label206:
      int j = 0;
      continue;
      label212:
      int k = 0;
    }
  }
  
  public final r b(JSONObject paramJSONObject)
  {
    r localr = new r();
    try
    {
      e0 locale0 = c(paramJSONObject);
      locale0.a = 1;
      localr.a = locale0;
      if (paramJSONObject.has("single_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONArray("single_ex");
        if (paramJSONObject != null)
        {
          paramJSONObject = c(paramJSONObject.getJSONObject(0));
          paramJSONObject.a = 2;
          localr.b = paramJSONObject;
          return localr;
        }
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
    return localr;
  }
  
  public boolean b()
  {
    int i = p4.p().e().b.saveType;
    return (this.d) && (i == 0);
  }
  
  public final int c(int paramInt)
  {
    Object localObject = this.c;
    if (localObject == null) {
      return 0;
    }
    if ((((r)localObject).b == null) && (((r)localObject).a == null))
    {
      this.c = null;
      return 0;
    }
    localObject = this.c.a;
    if (localObject != null)
    {
      localObject = ((e0)localObject).b;
      if (localObject != null)
      {
        i = ((t)localObject).a;
        break label73;
      }
    }
    int i = 0;
    label73:
    localObject = this.c.b;
    if (localObject != null)
    {
      localObject = ((e0)localObject).b;
      if (localObject != null)
      {
        j = ((t)localObject).a;
        break label110;
      }
    }
    int j = 0;
    label110:
    if (paramInt == j) {
      return this.c.b.a(paramInt);
    }
    if (paramInt >= i) {
      return this.c.a.a(paramInt);
    }
    return 0;
  }
  
  public final int c(int paramInt, ArrayList<r> paramArrayList)
  {
    paramArrayList = b(paramInt, this.a);
    if (paramArrayList != null) {
      return paramArrayList.b.a(paramInt);
    }
    return 0;
  }
  
  public String c(String paramString)
  {
    if (!TextUtils.isEmpty(this.g)) {
      return this.g;
    }
    e0 locale0 = a(this.c);
    StringBuffer localStringBuffer = new StringBuffer();
    if ((locale0.b != null) && (p4.p().e().e.b))
    {
      localStringBuffer.append("首次充值");
      int i = locale0.b.a;
      if (i > 0) {
        localStringBuffer.append(i);
      } else {
        localStringBuffer.append("任意数量");
      }
      localStringBuffer.append(paramString);
      localStringBuffer.append(",额外送");
      if (locale0.b.b() > 0)
      {
        localStringBuffer.append(locale0.b.b());
        localStringBuffer.append(paramString);
      }
      paramString = locale0.c;
      if ((paramString != null) && (paramString.size() > 0))
      {
        if (locale0.b.b() > 0) {
          localStringBuffer.append('+');
        }
        localStringBuffer.append(a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public final e0 c(JSONObject paramJSONObject)
  {
    e0 locale0 = new e0();
    Object localObject = new t();
    try
    {
      if (paramJSONObject.has("num")) {
        ((t)localObject).a = i.b(paramJSONObject.getString("num"));
      }
      if (paramJSONObject.has("send_rate")) {
        ((t)localObject).b = i.b(paramJSONObject.getString("send_rate"));
      }
      if (paramJSONObject.has("send_num")) {
        ((t)localObject).c = i.b(paramJSONObject.getString("send_num"));
      }
      if (paramJSONObject.has("send_type")) {
        ((t)localObject).d = paramJSONObject.getString("send_type");
      }
      if (paramJSONObject.has("send_ext")) {
        ((t)localObject).e = paramJSONObject.getString("send_ext");
      }
      locale0.b = ((t)localObject);
      if (paramJSONObject.has("ex_send"))
      {
        localObject = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("ex_send");
        int i = 0;
        while (i < paramJSONObject.length())
        {
          JSONObject localJSONObject = (JSONObject)paramJSONObject.get(i);
          w localw = new w();
          if (localJSONObject.has("name")) {
            localw.a = localJSONObject.getString("name");
          }
          if (localJSONObject.has("num")) {
            localw.b = localJSONObject.getString("num");
          }
          ((ArrayList)localObject).add(localw);
          i += 1;
        }
        locale0.c = ((ArrayList)localObject);
        return locale0;
      }
    }
    catch (Exception paramJSONObject)
    {
      APLog.w("analyzeSectionOrSingleMpItem", paramJSONObject.toString());
    }
    return locale0;
  }
  
  public boolean c()
  {
    int i = p4.p().e().b.saveType;
    return (this.e) && (i == 0);
  }
  
  public int d(int paramInt)
  {
    if (p4.p().e().e.b) {
      return c(paramInt);
    }
    return 0;
  }
  
  public String d()
  {
    return this.f;
  }
  
  public String d(String paramString)
  {
    return c(paramString);
  }
  
  public void d(JSONObject paramJSONObject)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((ArrayList)localObject).clear();
    }
    localObject = this.c;
    if (localObject != null) {
      ((r)localObject).a();
    }
    int i = 0;
    this.d = false;
    this.e = false;
    try
    {
      int j = paramJSONObject.getInt("firstsave_present_count");
      if (j > 0)
      {
        localObject = new t();
        ((t)localObject).a = 0;
        ((t)localObject).c = j;
        ((t)localObject).d = "2";
        this.c = new r();
        this.c.a = new e0();
        this.c.a.a = 1;
        this.c.a.b = ((t)localObject);
        this.d = true;
      }
      paramJSONObject = new JSONArray(paramJSONObject.getString("present_level"));
      while (i < paramJSONObject.length() / 2)
      {
        localObject = new r();
        t localt = new t();
        j = i * 2;
        localt.a = paramJSONObject.getInt(j);
        localt.c = paramJSONObject.getInt(j + 1);
        localt.d = "2";
        ((r)localObject).a = new e0();
        ((r)localObject).a.a = 1;
        ((r)localObject).a.b = localt;
        this.a.add(localObject);
        this.e = true;
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public String e()
  {
    return this.g;
  }
  
  public ArrayList<w> e(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (this.c != null)
    {
      Object localObject = p4.p().e();
      e0 locale0 = a(paramInt, this.c);
      if ((((o4)localObject).e.b) && (locale0 != null))
      {
        localObject = locale0.b;
        if (localObject != null)
        {
          int k = locale0.a;
          int j = 0;
          int i = 0;
          if (k == 2)
          {
            if ((paramInt == ((t)localObject).a) && (locale0.c != null))
            {
              paramInt = i;
              while (paramInt < locale0.c.size())
              {
                localObject = new w();
                ((w)localObject).a = ((w)locale0.c.get(paramInt)).a;
                ((w)localObject).b = ((w)locale0.c.get(paramInt)).b;
                localArrayList.add(localObject);
                paramInt += 1;
              }
            }
          }
          else if ((paramInt >= ((t)localObject).a) && (locale0.c != null))
          {
            paramInt = j;
            while (paramInt < locale0.c.size())
            {
              localObject = new w();
              ((w)localObject).a = ((w)locale0.c.get(paramInt)).a;
              ((w)localObject).b = ((w)locale0.c.get(paramInt)).b;
              localArrayList.add(localObject);
              paramInt += 1;
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0) {
      return localArrayList;
    }
    return null;
  }
  
  public boolean e(JSONObject paramJSONObject)
  {
    try
    {
      boolean bool = paramJSONObject.has("first_mpinfo_ex");
      if (bool)
      {
        JSONObject localJSONObject = paramJSONObject.getJSONObject("first_mpinfo_ex");
        if ((localJSONObject.has("type")) && (!TextUtils.isEmpty(localJSONObject.getString("type")))) {
          return true;
        }
      }
      if (paramJSONObject.has("utp_mpinfo_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("utp_mpinfo_ex");
        if (paramJSONObject.has("type"))
        {
          bool = TextUtils.isEmpty(paramJSONObject.getString("type"));
          if (!bool) {
            return true;
          }
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      label86:
      break label86;
    }
    return false;
  }
  
  public int f()
  {
    if (h()) {
      return this.b.a.size();
    }
    ArrayList localArrayList = this.a;
    if (localArrayList != null) {
      return localArrayList.size();
    }
    return 0;
  }
  
  public ArrayList<w> f(int paramInt)
  {
    o4 localo4 = p4.p().e();
    ArrayList localArrayList1 = e(paramInt);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localArrayList1;
    if (localArrayList1 == null) {
      localObject = new ArrayList();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add((w)((Iterator)localObject).next());
    }
    paramInt = d(paramInt);
    if (paramInt > 0)
    {
      localObject = new w();
      ((w)localObject).a = localo4.c.b;
      ((w)localObject).b = String.valueOf(paramInt);
      localArrayList2.add(0, localObject);
    }
    if (localArrayList2.size() > 0) {
      return localArrayList2;
    }
    return null;
  }
  
  public void f(JSONObject paramJSONObject)
  {
    x localx = x.f();
    localx.a();
    a6.c();
    try
    {
      if (paramJSONObject.has("tuan_mpinfo"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("tuan_mpinfo");
        localx.b(paramJSONObject.getString("mall_url"));
        localx.c(paramJSONObject.getString("result_url"));
        localx.a(paramJSONObject.getString("actset_id"));
        paramJSONObject = paramJSONObject.getJSONArray("list");
        if (a(paramJSONObject, "1"))
        {
          a(localx, paramJSONObject, "1");
          return;
        }
        if (a(paramJSONObject, "2"))
        {
          a(localx, paramJSONObject, "2");
          return;
        }
        if (a(paramJSONObject, "-1"))
        {
          a(localx, paramJSONObject, "-1");
          return;
        }
        localx.d("0");
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public final ArrayList<r> g()
  {
    return this.a;
  }
  
  public z g(int paramInt)
  {
    boolean bool = h();
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = l(paramInt);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new z();
        ((z)localObject1).a = ((q)localObject3).a;
        ((b0)localObject3).a(((z)localObject1).a);
        ((z)localObject1).b = ((q)localObject3).b;
        localObject2 = ((q)localObject3).c;
        ((b0)localObject3).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = localObject2;
      if (c())
      {
        localObject3 = this.a;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = a((r)((ArrayList)localObject3).get(paramInt));
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = new z();
            localObject2 = ((e0)localObject3).b;
            ((z)localObject1).a = ((t)localObject2).a;
            ((t)localObject2).b();
            ((z)localObject1).b = ((e0)localObject3).b.e;
            localObject2 = ((e0)localObject3).c;
            ((e0)localObject3).a();
          }
        }
      }
    }
    return localObject1;
  }
  
  public void g(JSONObject paramJSONObject)
  {
    this.g = "";
    this.f = paramJSONObject.toString();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseMpTitle :");
    ((StringBuilder)localObject).append(this.f);
    APLog.i("APMPSendInfo", ((StringBuilder)localObject).toString());
    try
    {
      boolean bool = paramJSONObject.has("mpinfo_ex");
      if (bool)
      {
        localObject = paramJSONObject.getJSONObject("mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.g = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("first_mpinfo_ex"))
      {
        localObject = paramJSONObject.getJSONObject("first_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.g = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("acc_mpinfo_ex"))
      {
        localObject = paramJSONObject.getJSONObject("acc_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.g = ((String)localObject);
          return;
        }
      }
      if (paramJSONObject.has("utp_mpinfo_ex"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("utp_mpinfo_ex").getString("title");
        if (!TextUtils.isEmpty(paramJSONObject))
        {
          this.g = paramJSONObject;
          return;
        }
      }
    }
    catch (Exception paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public z h(int paramInt)
  {
    boolean bool = h();
    Object localObject2 = null;
    Object localObject3;
    Object localObject1;
    if (bool)
    {
      localObject3 = this.b.a(paramInt);
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject1 = new z();
        ((z)localObject1).a = ((q)localObject3).a;
        ((q)localObject3).a(((z)localObject1).a);
        ((z)localObject1).b = ((q)localObject3).b;
        localObject2 = ((q)localObject3).c;
        ((q)localObject3).a();
        return localObject1;
      }
    }
    else
    {
      localObject1 = localObject2;
      if (c())
      {
        localObject3 = this.a;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = b(paramInt, (ArrayList)localObject3);
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = new z();
            localObject2 = ((e0)localObject3).b;
            ((z)localObject1).a = ((t)localObject2).a;
            ((t)localObject2).b();
            ((z)localObject1).b = ((e0)localObject3).b.e;
            localObject2 = ((e0)localObject3).c;
            ((e0)localObject3).a();
          }
        }
      }
    }
    return localObject1;
  }
  
  public final boolean h()
  {
    s locals = this.b;
    if (locals != null) {
      return locals.d() ^ true;
    }
    return false;
  }
  
  public int i(int paramInt)
  {
    if (h()) {
      return this.b.b(paramInt);
    }
    if ((c()) && (this.a != null))
    {
      e0 locale0 = b(paramInt, g());
      if (locale0 == null) {
        return 0;
      }
      int i = locale0.a;
      if (i == 2)
      {
        if (m(locale0.b.a) > 0) {
          return n(locale0.b.a);
        }
      }
      else if ((i == 1) && (m(paramInt) > 0)) {
        return n(paramInt);
      }
    }
    return 0;
  }
  
  public ArrayList<w> j(int paramInt)
  {
    Object localObject;
    if (h())
    {
      localObject = this.b.a(paramInt);
      if (localObject != null) {
        return ((q)localObject).c;
      }
    }
    else if (c())
    {
      localObject = this.a;
      if (localObject != null)
      {
        localObject = b(paramInt, (ArrayList)localObject);
        if (localObject != null) {
          return ((e0)localObject).c;
        }
      }
    }
    return null;
  }
  
  public ArrayList<w> k(int paramInt)
  {
    o4 localo4 = p4.p().e();
    if (localo4.b.saveType != 0) {
      return null;
    }
    ArrayList localArrayList1 = j(paramInt);
    ArrayList localArrayList2 = new ArrayList();
    Object localObject = localArrayList1;
    if (localArrayList1 == null) {
      localObject = new ArrayList();
    }
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList2.add((w)((Iterator)localObject).next());
    }
    paramInt = i(paramInt);
    if (paramInt > 0)
    {
      localObject = new w();
      ((w)localObject).a = localo4.c.b;
      ((w)localObject).b = String.valueOf(paramInt);
      localArrayList2.add(0, localObject);
    }
    if (localArrayList2.size() > 0) {
      return localArrayList2;
    }
    return null;
  }
  
  public final b0 l(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = ((s)localObject).a;
      if ((localObject != null) && (((ArrayList)localObject).size() > paramInt)) {
        return (b0)this.b.a.get(paramInt);
      }
    }
    return null;
  }
  
  public final int m(int paramInt)
  {
    e0 locale0 = b(paramInt, this.a);
    if (locale0 != null) {
      return locale0.b.a;
    }
    return 0;
  }
  
  public final int n(int paramInt)
  {
    return c(paramInt, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.9a_179010_92809280434fe4a46110cc442b537591.jar\classes.jar
 * Qualified Name:     midas.x.d0
 * JD-Core Version:    0.7.0.1
 */